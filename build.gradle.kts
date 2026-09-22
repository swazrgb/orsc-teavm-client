// The OpenRSC client, patched to run in a browser: the shared client (Client_Base/src) and the
// browser launcher (TeaVM_Client/src), transpiled to JavaScript by TeaVM, beside the client cache
// baked into static assets. The result is target/client-base-teavm-1.0-SNAPSHOT/, a directory any
// static host can serve, and the same content as a war.
plugins {
    war
    id("org.teavm") version "0.15.0"
}

group = "openrsc"
version = "1.0-SNAPSHOT"

// target/, where hosts that serve the exploded client look for it.
layout.buildDirectory = layout.projectDirectory.dir("target")

sourceSets.main {
    java.setSrcDirs(listOf("Client_Base/src", "TeaVM_Client/src"))
}

java {
    // The level of the classes TeaVM consumes, NOT of the JDK that runs the build.
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
    // ...which is also why dependency resolution must not match libraries against it: teavm-classlib
    // declares it needs a Java 17 runtime, true of TeaVM's own compiler, not of the classes compiled
    // against it here. Maven never compared the two.
    disableAutoTargetJvm()
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

dependencies {
    compileOnly("org.teavm:teavm-classlib:0.15.0")
    compileOnly("org.teavm:teavm-jso-apis:0.15.0")
}

// The TeaVM plugin puts TeaVM's SPI annotation processor on every project that applies it; the Maven
// build never ran it, and it writes SPI service files — here beside the ones written by hand
// (META-INF/services). Kept off, so what is compiled and packaged is what the Maven build produced.
configurations.named("annotationProcessor") {
    exclude(group = "org.teavm", module = "teavm-extension-annotation-processor")
}

// Reproducible archives: two builds of one commit write the same war.
tasks.withType<AbstractArchiveTask>().configureEach {
    isPreserveFileTimestamps = false
    isReproducibleFileOrder = true
    dirPermissions { unix("rwxr-xr-x") }
    filePermissions { unix("rw-r--r--") }
}

val generated = layout.buildDirectory.dir("generated/js")

// Minified, FULL optimisation, source maps with the sources copied beside them: they cost nothing at
// runtime (the .map is fetched only with devtools open). For an unminified build:
// -Dteavm.minify=false -Dteavm.opt=SIMPLE
val minify = (System.getProperty("teavm.minify") ?: "true").toBoolean()
val teavmOptimization = when (System.getProperty("teavm.opt") ?: "FULL") {
    "SIMPLE" -> org.teavm.gradle.api.OptimizationLevel.NONE
    "ADVANCED" -> org.teavm.gradle.api.OptimizationLevel.BALANCED
    else -> org.teavm.gradle.api.OptimizationLevel.AGGRESSIVE
}

// The TeaVM compile is restored from the build cache when nothing it reads has changed, as the Maven
// build's module cache restored this whole project; the plugin declares its sources, classpath and
// every option as inputs, but does not mark the task cacheable itself.
tasks.matching { it.name == "generateJavaScript" }.configureEach { outputs.cacheIf { true } }

teavm {
    js {
        mainClass = "orsc.BrowserMain"
        // target/generated/js/teavm/classes.js, as the Maven build wrote it: TeaVM_Client/webapp's
        // index.html loads teavm/classes.js. The plugin's own default subdirectory is js/.
        outputDir = generated
        relativePathInOutputDir = "teavm"
        targetFileName = "classes.js"
        // The war is assembled below, from the tasks' outputs; left on, the plugin adds its own copy.
        addedToWebApp = false
        obfuscated = minify
        optimization = teavmOptimization
        debugInformation = false
        sourceMap = true
        sourceFilePolicy = org.teavm.gradle.api.SourceFilePolicy.COPY
    }
}

// The OpenRSC client cache, baked into static assets (pack/ and cache/) for the war's root, so the
// client is self-contained. Defaults to the sibling openrsc checkout; -Dopenrsc.cache.dir overrides.
val cacheDir = file(System.getProperty("openrsc.cache.dir") ?: "../openrsc/Client_Base/Cache")
val baked = layout.buildDirectory.dir("generated/baked")
// Handed to the baker relative to this project (its working directory), because a task's arguments
// are part of its cache key: absolute ones would give every checkout a key of its own.
fun relative(f: File) = f.relativeTo(projectDir).path

val bakeCache = tasks.register<JavaExec>("bakeCache") {
    description = "Bakes the OpenRSC client cache into the client's static assets."
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass = "orsc.tools.CacheBaker"
    args(relative(cacheDir), relative(baked.get().asFile))
    inputs.dir(cacheDir).withPropertyName("cache").withPathSensitivity(PathSensitivity.RELATIVE)
    outputs.dir(baked).withPropertyName("baked")
    // A JVM of its own: capped, not sized off the machine. Under Maven it ran inside Maven's 3g.
    maxHeapSize = "1g"
    // Every input is declared — the cache tree, the baker's classpath, its arguments — so a baked
    // cache is restored rather than rebaked when neither has changed.
    outputs.cacheIf { true }
}

tasks.war {
    // target/client-base-teavm-1.0-SNAPSHOT.war, where the README says it is.
    destinationDirectory = layout.buildDirectory
    from("TeaVM_Client/webapp")
    from(tasks.named("generateJavaScript"))  { into("teavm") }
    from(bakeCache)
}

// The war's zipTree through an injected ArchiveOperations, not the build script's own zipTree: that
// one is the script object's method, which a lazily evaluated lambda would capture, and the
// configuration cache cannot store a build script.
interface ArchiveOps {
    @get:Inject val archives: ArchiveOperations
}

val explodedWar = tasks.register<Sync>("explodedWar") {
    description = "The war's contents as a directory, for a static host to serve."
    val archives = objects.newInstance<ArchiveOps>().archives
    from(tasks.war.flatMap { it.archiveFile }.map { archives.zipTree(it) }) {
        // The war's own manifest; Maven's exploded war had none, and the directory is served as is.
        exclude("META-INF/MANIFEST.MF")
    }
    into(layout.buildDirectory.dir("client-base-teavm-1.0-SNAPSHOT"))
}

tasks.assemble { dependsOn(explodedWar) }
