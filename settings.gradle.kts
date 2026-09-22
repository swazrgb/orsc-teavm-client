// The browser (TeaVM) build of the OpenRSC client, on its own. Another Gradle build may include this
// same directory as a project of its own.
pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

rootProject.name = "client-base-teavm"
