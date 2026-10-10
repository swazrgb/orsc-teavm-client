package orsc;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Properties;

import static orsc.osConfig.F_ANDROID_BUILD;

public class Config {
	private static Properties prop = new Properties();

	public static boolean DEBUG = false; // Enables print out of the config being sent to the client
	static String WINDOW_TITLE = "Open RSC"; // Only set here due to config not set by server fast enough at load time
	public static String SERVER_NAME = "Runescape";
	public static String SERVER_NAME_WELCOME = "Runescape Classic";
	public static String WELCOME_TEXT = "You need a members account to use this server";
	public static String SERVER_IP = null; // Modify this to override "Cache/ip.txt"
	public static int SERVER_PORT; // Modify SERVER_IP above to override "Cache/port.txt" with this value
	public static final int CLIENT_VERSION = 10010;
	private static final int CACHE_VERSION = 4;
	public static boolean MEMBER_WORLD = false;
	public static boolean DISPLAY_LOGO_SPRITE = false;
	private static final boolean CUSTOM_CACHE_DIR_ENABLED = false;
	private static final String CUSTOM_CACHE_DIR = System.getProperty("user.home") + File.separator + "OpenRSC";
	public static String F_CACHE_DIR = "";

	public static final int INVENTORY_TAB = 1;
	public static final int MINIMAP_AND_COMPASS_TAB = 2;
	public static final int SKILLS_AND_QUESTS_TAB = 3;
	public static final int MAGIC_AND_PRAYER_TAB = 4;
	public static final int FRIENDS_TAB = 5;
	public static final int OPTIONS_TAB = 6;

	/* Configurable: */
	public static boolean C_EXPERIENCE_DROPS = false;
	public static boolean C_TOTAL_NPC_KC = false;
	public static boolean C_RECENT_NPC_KC = false;
	public static boolean C_BATCH_PROGRESS_BAR = false;
	public static boolean C_HIDE_ROOFS = true;
	public static boolean C_HIDE_FOG = false;
	public static boolean C_HIDE_UNDERGROUND_FLICKER = false;
	public static int C_SHOW_GROUND_ITEMS = 0;
	public static boolean C_GROUND_ITEM_NAMES = false;
	public static boolean C_WANT_NATURE_RUNE_PROTECTION = true; // Important that nature rune protection is true by default, otherwise we might have some very unhappy players!
	public static boolean C_MESSAGE_TAB_SWITCH = false;
	public static boolean C_NAME_CLAN_TAG_OVERLAY = false;
	public static boolean C_SIDE_MENU_OVERLAY = false;
	public static boolean C_KILL_FEED = false;
	public static int C_FIGHT_MENU = 1;
	public static boolean C_INV_COUNT = false;
	public static boolean C_PARTY_INV = false;
	public static int C_ZOOM;
	public static boolean C_CUSTOM_UI = false; // Enables a osrs style UI
	public static boolean C_HIDE_LOGIN_BOX = false;
	public static boolean C_BLOCK_GLOBAL_FRIEND = false;
	public static int C_MOVE_PER_FRAME = 4;

	/* Experience Config Menu */
	public static int C_EXPERIENCE_COUNTER = 1;
	public static int C_EXPERIENCE_COUNTER_MODE = 0;
	public static int C_EXPERIENCE_COUNTER_COLOR = 0;
	public static int C_EXPERIENCE_DROP_SPEED = 1;
	public static boolean C_EXPERIENCE_CONFIG_SUBMENU = false;

	/* Server Defined: DOUBLE CHECK THESE ON SERVER */
	public static int S_PLAYER_LEVEL_LIMIT = 99;
	public static int S_PLAYER_SLOT_COUNT = 11;
	public static int S_PLAYER_INVENTORY_SLOTS = 30;
	public static boolean S_SPAWN_AUCTION_NPCS = false;
	public static boolean S_SPAWN_IRON_MAN_NPCS = false;
	public static boolean S_SHOW_FLOATING_NAMETAGS = false;
	public static boolean S_WANT_SKILL_MENUS = false;
	public static boolean S_WANT_QUEST_MENUS = false;
	public static boolean S_WANT_EXPERIENCE_ELIXIRS = false;
	public static int S_WANT_KEYBOARD_SHORTCUTS = 0;
	public static boolean S_WANT_CUSTOM_BANKS = false;
	public static boolean S_WANT_BANK_PINS = false;
	public static boolean S_WANT_BANK_NOTES = false;
	public static boolean S_WANT_CERT_DEPOSIT = false;
	public static boolean S_CUSTOM_FIREMAKING = false;
	public static boolean S_WANT_RUNECRAFT = false;
	public static boolean S_WANT_DROP_X = false;
	public static boolean S_WANT_EXP_INFO = false;
	public static boolean S_WANT_WOODCUTTING_GUILD = false;
	public static boolean S_WANT_DECANTING = false;
	public static boolean S_WANT_CERTS_TO_BANK = false;
	public static boolean S_WANT_CUSTOM_RANK_DISPLAY = false;
	public static boolean S_RIGHT_CLICK_BANK = false;
	public static boolean S_RIGHT_CLICK_TRADE = false;
	public static boolean S_WANT_EQUIPMENT_TAB = false;
	public static boolean S_WANT_BANK_PRESETS = false;
	public static boolean S_WANT_LEFTCLICK_WEBS = false;
	public static boolean S_NPC_KILL_COUNTERS = false;
	// if you change these, and the config file,
	// they will also change the options menu to
	// 2-tabs (3 on android). (Not enough room for
	// additional options on the 1-tab layout.)
	public static boolean S_WANT_CLANS = false;
	public static boolean S_WANT_KILL_FEED = false;
	public static boolean S_FOG_TOGGLE = false;
	public static boolean S_GROUND_ITEM_TOGGLE = false;
	public static boolean S_GROUND_ITEM_NAMES = false;
	public static boolean S_WANT_NATURE_RUNE_PROTECTION = true; // Important that nature rune protection is true by default, otherwise we might have some very unhappy players!
	public static boolean S_AUTO_MESSAGE_SWITCH_TOGGLE = false;
	public static boolean S_BATCH_PROGRESSION = false;
	public static boolean S_SIDE_MENU_TOGGLE = false;
	public static boolean S_INVENTORY_COUNT_TOGGLE = false;
	public static boolean S_ZOOM_VIEW_TOGGLE = false;
	public static boolean S_MENU_COMBAT_STYLE_TOGGLE = false;
	public static boolean S_FIGHTMODE_SELECTOR_TOGGLE = false;
	public static boolean S_EXPERIENCE_COUNTER_TOGGLE = false;
	public static boolean S_EXPERIENCE_DROPS_TOGGLE = false;
	public static boolean S_ITEMS_ON_DEATH_MENU = false;
	public static boolean S_SHOW_ROOF_TOGGLE = true;
	public static boolean S_SHOW_UNDERGROUND_FLICKER_TOGGLE = false;
	public static boolean S_WANT_GLOBAL_CHAT = false;
	public static boolean S_WANT_GLOBAL_FRIEND = false;
	public static boolean S_WANT_HIDE_IP = false;
	public static boolean S_WANT_REMEMBER = false;
	public static boolean S_WANT_FIXED_OVERHEAD_CHAT = false;
	public static String C_LOGO_SPRITE_ID = "2010";
	public static int C_FPS = 50;
	public static boolean C_WANT_EMAIL = false;
	public static boolean S_WANT_REGISTRATION_LIMIT = false;
	public static boolean S_ALLOW_RESIZE = false;
	public static boolean S_LENIENT_CONTACT_DETAILS = false;
	public static boolean S_WANT_FATIGUE = true;
	public static boolean S_WANT_CUSTOM_SPRITES = false;
	public static boolean S_WANT_CUSTOM_LANDSCAPE = false;
	public static boolean S_WANT_PLAYER_COMMANDS = false;
	public static boolean S_WANT_PETS = false;
	public static int S_MAX_WALKING_SPEED = 1;
	public static boolean S_SHOW_UNIDENTIFIED_HERB_NAMES = false;
	public static boolean S_WANT_QUEST_STARTED_INDICATOR = false;
	public static boolean S_FISHING_SPOTS_DEPLETABLE = false;
	public static boolean S_IMPROVED_ITEM_OBJECT_NAMES = false;
	public static boolean S_WANT_PARTIES = false;
	public static boolean S_MINING_ROCKS_EXTENDED = false;
	public static boolean S_WANT_CUSTOM_UI = false;
	public static boolean S_HIDE_LOGIN_BOX = false;
	public static int S_CHARACTER_CREATION_MODE = 0;
	public static int S_SKILLING_EXP_RATE = 1;
	public static boolean S_WANT_HARVESTING = false;
	public static boolean S_FEATURES_SLEEP = true;
	public static boolean S_WANT_EXTENDED_CATS_BEHAVIOR = false;
	public static boolean S_WANT_CERT_AS_NOTES = false;
	public static boolean S_WANT_OPENPK_POINTS = false;
	public static int S_OPENPK_POINTS_TO_GP_RATIO = 1;
	public static boolean S_WANT_OPENPK_PRESETS = false;
	public static boolean S_DISABLE_MINIMAP_ROTATION = true;
	public static boolean S_ALLOW_BEARDED_LADIES = false;
	public static boolean S_PRIDE_MONTH = false;

	public static void set(String key, Object value) {
		prop.setProperty(key, value.toString());
	}

	static void initConfig() {
		if (!F_ANDROID_BUILD) {
			if (CUSTOM_CACHE_DIR_ENABLED) {
				F_CACHE_DIR = CUSTOM_CACHE_DIR;
			} else {
				F_CACHE_DIR = "Cache";
				System.out.println("Set Cache dir to " + F_CACHE_DIR);
        // Check if F_CACHE_DIR exists, if not, set it to "." (current directory)
        File f = new File(F_CACHE_DIR);
        if (!f.exists()) {
          System.out.println("Could not find cache at " + F_CACHE_DIR + ", using current directory instead.");
          F_CACHE_DIR = ".";
          f = new File(F_CACHE_DIR);
          if (!f.exists()) {
            System.out.println("Could not find cache at current directory either. Game will crash.");
          }
        }
			}
		} else {
			return;
		}
		setConfigurationFromProperties();
		saveConfiguration(false);
	}

	/**
	 * Saves configuration from the constants in this class
	 *
	 * @param force
	 */
	private static void saveConfiguration(boolean force) {
		// Browser build: no field-reflection (TeaVM 0.6.1 lacks Field.getInt/set on primitives); client
		// settings aren't persisted. TODO: persist to localStorage via an explicit field map.
	}

	/**
	 * Browser build: TeaVM has no field reflection, so this spells out by hand what the desktop
	 * client's reflective loop does — every property sets the primitive, non-F_ field of the same
	 * name, and a field with no property keeps its value. Strings stay in `prop` (read via
	 * getServerName() etc.), as on desktop. A field added to this class needs a line here.
	 */
	private static void setConfigurationFromProperties() {
		DEBUG = bool("DEBUG", DEBUG);
		SERVER_PORT = integer("SERVER_PORT", SERVER_PORT);
		MEMBER_WORLD = bool("MEMBER_WORLD", MEMBER_WORLD);
		DISPLAY_LOGO_SPRITE = bool("DISPLAY_LOGO_SPRITE", DISPLAY_LOGO_SPRITE);

		C_EXPERIENCE_DROPS = bool("C_EXPERIENCE_DROPS", C_EXPERIENCE_DROPS);
		C_TOTAL_NPC_KC = bool("C_TOTAL_NPC_KC", C_TOTAL_NPC_KC);
		C_RECENT_NPC_KC = bool("C_RECENT_NPC_KC", C_RECENT_NPC_KC);
		C_BATCH_PROGRESS_BAR = bool("C_BATCH_PROGRESS_BAR", C_BATCH_PROGRESS_BAR);
		C_HIDE_ROOFS = bool("C_HIDE_ROOFS", C_HIDE_ROOFS);
		C_HIDE_FOG = bool("C_HIDE_FOG", C_HIDE_FOG);
		C_HIDE_UNDERGROUND_FLICKER = bool("C_HIDE_UNDERGROUND_FLICKER", C_HIDE_UNDERGROUND_FLICKER);
		C_SHOW_GROUND_ITEMS = integer("C_SHOW_GROUND_ITEMS", C_SHOW_GROUND_ITEMS);
		C_GROUND_ITEM_NAMES = bool("C_GROUND_ITEM_NAMES", C_GROUND_ITEM_NAMES);
		C_WANT_NATURE_RUNE_PROTECTION = bool("C_WANT_NATURE_RUNE_PROTECTION", C_WANT_NATURE_RUNE_PROTECTION);
		C_MESSAGE_TAB_SWITCH = bool("C_MESSAGE_TAB_SWITCH", C_MESSAGE_TAB_SWITCH);
		C_NAME_CLAN_TAG_OVERLAY = bool("C_NAME_CLAN_TAG_OVERLAY", C_NAME_CLAN_TAG_OVERLAY);
		C_SIDE_MENU_OVERLAY = bool("C_SIDE_MENU_OVERLAY", C_SIDE_MENU_OVERLAY);
		C_KILL_FEED = bool("C_KILL_FEED", C_KILL_FEED);
		C_FIGHT_MENU = integer("C_FIGHT_MENU", C_FIGHT_MENU);
		C_INV_COUNT = bool("C_INV_COUNT", C_INV_COUNT);
		C_PARTY_INV = bool("C_PARTY_INV", C_PARTY_INV);
		C_ZOOM = integer("C_ZOOM", C_ZOOM);
		C_CUSTOM_UI = bool("C_CUSTOM_UI", C_CUSTOM_UI);
		C_HIDE_LOGIN_BOX = bool("C_HIDE_LOGIN_BOX", C_HIDE_LOGIN_BOX);
		C_BLOCK_GLOBAL_FRIEND = bool("C_BLOCK_GLOBAL_FRIEND", C_BLOCK_GLOBAL_FRIEND);
		C_MOVE_PER_FRAME = integer("C_MOVE_PER_FRAME", C_MOVE_PER_FRAME);
		C_EXPERIENCE_COUNTER = integer("C_EXPERIENCE_COUNTER", C_EXPERIENCE_COUNTER);
		C_EXPERIENCE_COUNTER_MODE = integer("C_EXPERIENCE_COUNTER_MODE", C_EXPERIENCE_COUNTER_MODE);
		C_EXPERIENCE_COUNTER_COLOR = integer("C_EXPERIENCE_COUNTER_COLOR", C_EXPERIENCE_COUNTER_COLOR);
		C_EXPERIENCE_DROP_SPEED = integer("C_EXPERIENCE_DROP_SPEED", C_EXPERIENCE_DROP_SPEED);
		C_EXPERIENCE_CONFIG_SUBMENU = bool("C_EXPERIENCE_CONFIG_SUBMENU", C_EXPERIENCE_CONFIG_SUBMENU);
		C_FPS = integer("C_FPS", C_FPS);
		C_WANT_EMAIL = bool("C_WANT_EMAIL", C_WANT_EMAIL);

		S_PLAYER_LEVEL_LIMIT = integer("S_PLAYER_LEVEL_LIMIT", S_PLAYER_LEVEL_LIMIT);
		S_PLAYER_SLOT_COUNT = integer("S_PLAYER_SLOT_COUNT", S_PLAYER_SLOT_COUNT);
		S_PLAYER_INVENTORY_SLOTS = integer("S_PLAYER_INVENTORY_SLOTS", S_PLAYER_INVENTORY_SLOTS);
		S_SPAWN_AUCTION_NPCS = bool("S_SPAWN_AUCTION_NPCS", S_SPAWN_AUCTION_NPCS);
		S_SPAWN_IRON_MAN_NPCS = bool("S_SPAWN_IRON_MAN_NPCS", S_SPAWN_IRON_MAN_NPCS);
		S_SHOW_FLOATING_NAMETAGS = bool("S_SHOW_FLOATING_NAMETAGS", S_SHOW_FLOATING_NAMETAGS);
		S_WANT_SKILL_MENUS = bool("S_WANT_SKILL_MENUS", S_WANT_SKILL_MENUS);
		S_WANT_QUEST_MENUS = bool("S_WANT_QUEST_MENUS", S_WANT_QUEST_MENUS);
		S_WANT_EXPERIENCE_ELIXIRS = bool("S_WANT_EXPERIENCE_ELIXIRS", S_WANT_EXPERIENCE_ELIXIRS);
		S_WANT_KEYBOARD_SHORTCUTS = integer("S_WANT_KEYBOARD_SHORTCUTS", S_WANT_KEYBOARD_SHORTCUTS);
		S_WANT_CUSTOM_BANKS = bool("S_WANT_CUSTOM_BANKS", S_WANT_CUSTOM_BANKS);
		S_WANT_BANK_PINS = bool("S_WANT_BANK_PINS", S_WANT_BANK_PINS);
		S_WANT_BANK_NOTES = bool("S_WANT_BANK_NOTES", S_WANT_BANK_NOTES);
		S_WANT_CERT_DEPOSIT = bool("S_WANT_CERT_DEPOSIT", S_WANT_CERT_DEPOSIT);
		S_CUSTOM_FIREMAKING = bool("S_CUSTOM_FIREMAKING", S_CUSTOM_FIREMAKING);
		S_WANT_RUNECRAFT = bool("S_WANT_RUNECRAFT", S_WANT_RUNECRAFT);
		S_WANT_DROP_X = bool("S_WANT_DROP_X", S_WANT_DROP_X);
		S_WANT_EXP_INFO = bool("S_WANT_EXP_INFO", S_WANT_EXP_INFO);
		S_WANT_WOODCUTTING_GUILD = bool("S_WANT_WOODCUTTING_GUILD", S_WANT_WOODCUTTING_GUILD);
		S_WANT_DECANTING = bool("S_WANT_DECANTING", S_WANT_DECANTING);
		S_WANT_CERTS_TO_BANK = bool("S_WANT_CERTS_TO_BANK", S_WANT_CERTS_TO_BANK);
		S_WANT_CUSTOM_RANK_DISPLAY = bool("S_WANT_CUSTOM_RANK_DISPLAY", S_WANT_CUSTOM_RANK_DISPLAY);
		S_RIGHT_CLICK_BANK = bool("S_RIGHT_CLICK_BANK", S_RIGHT_CLICK_BANK);
		S_RIGHT_CLICK_TRADE = bool("S_RIGHT_CLICK_TRADE", S_RIGHT_CLICK_TRADE);
		S_WANT_EQUIPMENT_TAB = bool("S_WANT_EQUIPMENT_TAB", S_WANT_EQUIPMENT_TAB);
		S_WANT_BANK_PRESETS = bool("S_WANT_BANK_PRESETS", S_WANT_BANK_PRESETS);
		S_WANT_LEFTCLICK_WEBS = bool("S_WANT_LEFTCLICK_WEBS", S_WANT_LEFTCLICK_WEBS);
		S_NPC_KILL_COUNTERS = bool("S_NPC_KILL_COUNTERS", S_NPC_KILL_COUNTERS);
		S_WANT_CLANS = bool("S_WANT_CLANS", S_WANT_CLANS);
		S_WANT_KILL_FEED = bool("S_WANT_KILL_FEED", S_WANT_KILL_FEED);
		S_FOG_TOGGLE = bool("S_FOG_TOGGLE", S_FOG_TOGGLE);
		S_GROUND_ITEM_TOGGLE = bool("S_GROUND_ITEM_TOGGLE", S_GROUND_ITEM_TOGGLE);
		S_GROUND_ITEM_NAMES = bool("S_GROUND_ITEM_NAMES", S_GROUND_ITEM_NAMES);
		S_WANT_NATURE_RUNE_PROTECTION = bool("S_WANT_NATURE_RUNE_PROTECTION", S_WANT_NATURE_RUNE_PROTECTION);
		S_AUTO_MESSAGE_SWITCH_TOGGLE = bool("S_AUTO_MESSAGE_SWITCH_TOGGLE", S_AUTO_MESSAGE_SWITCH_TOGGLE);
		S_BATCH_PROGRESSION = bool("S_BATCH_PROGRESSION", S_BATCH_PROGRESSION);
		S_SIDE_MENU_TOGGLE = bool("S_SIDE_MENU_TOGGLE", S_SIDE_MENU_TOGGLE);
		S_INVENTORY_COUNT_TOGGLE = bool("S_INVENTORY_COUNT_TOGGLE", S_INVENTORY_COUNT_TOGGLE);
		S_ZOOM_VIEW_TOGGLE = bool("S_ZOOM_VIEW_TOGGLE", S_ZOOM_VIEW_TOGGLE);
		S_MENU_COMBAT_STYLE_TOGGLE = bool("S_MENU_COMBAT_STYLE_TOGGLE", S_MENU_COMBAT_STYLE_TOGGLE);
		S_FIGHTMODE_SELECTOR_TOGGLE = bool("S_FIGHTMODE_SELECTOR_TOGGLE", S_FIGHTMODE_SELECTOR_TOGGLE);
		S_EXPERIENCE_COUNTER_TOGGLE = bool("S_EXPERIENCE_COUNTER_TOGGLE", S_EXPERIENCE_COUNTER_TOGGLE);
		S_EXPERIENCE_DROPS_TOGGLE = bool("S_EXPERIENCE_DROPS_TOGGLE", S_EXPERIENCE_DROPS_TOGGLE);
		S_ITEMS_ON_DEATH_MENU = bool("S_ITEMS_ON_DEATH_MENU", S_ITEMS_ON_DEATH_MENU);
		S_SHOW_ROOF_TOGGLE = bool("S_SHOW_ROOF_TOGGLE", S_SHOW_ROOF_TOGGLE);
		S_SHOW_UNDERGROUND_FLICKER_TOGGLE = bool("S_SHOW_UNDERGROUND_FLICKER_TOGGLE", S_SHOW_UNDERGROUND_FLICKER_TOGGLE);
		S_WANT_GLOBAL_CHAT = bool("S_WANT_GLOBAL_CHAT", S_WANT_GLOBAL_CHAT);
		S_WANT_GLOBAL_FRIEND = bool("S_WANT_GLOBAL_FRIEND", S_WANT_GLOBAL_FRIEND);
		S_WANT_HIDE_IP = bool("S_WANT_HIDE_IP", S_WANT_HIDE_IP);
		S_WANT_REMEMBER = bool("S_WANT_REMEMBER", S_WANT_REMEMBER);
		S_WANT_FIXED_OVERHEAD_CHAT = bool("S_WANT_FIXED_OVERHEAD_CHAT", S_WANT_FIXED_OVERHEAD_CHAT);
		S_WANT_REGISTRATION_LIMIT = bool("S_WANT_REGISTRATION_LIMIT", S_WANT_REGISTRATION_LIMIT);
		S_ALLOW_RESIZE = bool("S_ALLOW_RESIZE", S_ALLOW_RESIZE);
		S_LENIENT_CONTACT_DETAILS = bool("S_LENIENT_CONTACT_DETAILS", S_LENIENT_CONTACT_DETAILS);
		S_WANT_FATIGUE = bool("S_WANT_FATIGUE", S_WANT_FATIGUE);
		S_WANT_CUSTOM_SPRITES = bool("S_WANT_CUSTOM_SPRITES", S_WANT_CUSTOM_SPRITES);
		S_WANT_CUSTOM_LANDSCAPE = bool("S_WANT_CUSTOM_LANDSCAPE", S_WANT_CUSTOM_LANDSCAPE);
		S_WANT_PLAYER_COMMANDS = bool("S_WANT_PLAYER_COMMANDS", S_WANT_PLAYER_COMMANDS);
		S_WANT_PETS = bool("S_WANT_PETS", S_WANT_PETS);
		S_MAX_WALKING_SPEED = integer("S_MAX_WALKING_SPEED", S_MAX_WALKING_SPEED);
		S_SHOW_UNIDENTIFIED_HERB_NAMES = bool("S_SHOW_UNIDENTIFIED_HERB_NAMES", S_SHOW_UNIDENTIFIED_HERB_NAMES);
		S_WANT_QUEST_STARTED_INDICATOR = bool("S_WANT_QUEST_STARTED_INDICATOR", S_WANT_QUEST_STARTED_INDICATOR);
		S_FISHING_SPOTS_DEPLETABLE = bool("S_FISHING_SPOTS_DEPLETABLE", S_FISHING_SPOTS_DEPLETABLE);
		S_IMPROVED_ITEM_OBJECT_NAMES = bool("S_IMPROVED_ITEM_OBJECT_NAMES", S_IMPROVED_ITEM_OBJECT_NAMES);
		S_WANT_PARTIES = bool("S_WANT_PARTIES", S_WANT_PARTIES);
		S_MINING_ROCKS_EXTENDED = bool("S_MINING_ROCKS_EXTENDED", S_MINING_ROCKS_EXTENDED);
		S_WANT_CUSTOM_UI = bool("S_WANT_CUSTOM_UI", S_WANT_CUSTOM_UI);
		S_HIDE_LOGIN_BOX = bool("S_HIDE_LOGIN_BOX", S_HIDE_LOGIN_BOX);
		S_CHARACTER_CREATION_MODE = integer("S_CHARACTER_CREATION_MODE", S_CHARACTER_CREATION_MODE);
		S_SKILLING_EXP_RATE = integer("S_SKILLING_EXP_RATE", S_SKILLING_EXP_RATE);
		S_WANT_HARVESTING = bool("S_WANT_HARVESTING", S_WANT_HARVESTING);
		S_FEATURES_SLEEP = bool("S_FEATURES_SLEEP", S_FEATURES_SLEEP);
		S_WANT_EXTENDED_CATS_BEHAVIOR = bool("S_WANT_EXTENDED_CATS_BEHAVIOR", S_WANT_EXTENDED_CATS_BEHAVIOR);
		S_WANT_CERT_AS_NOTES = bool("S_WANT_CERT_AS_NOTES", S_WANT_CERT_AS_NOTES);
		S_WANT_OPENPK_POINTS = bool("S_WANT_OPENPK_POINTS", S_WANT_OPENPK_POINTS);
		S_OPENPK_POINTS_TO_GP_RATIO = integer("S_OPENPK_POINTS_TO_GP_RATIO", S_OPENPK_POINTS_TO_GP_RATIO);
		S_WANT_OPENPK_PRESETS = bool("S_WANT_OPENPK_PRESETS", S_WANT_OPENPK_PRESETS);
		S_DISABLE_MINIMAP_ROTATION = bool("S_DISABLE_MINIMAP_ROTATION", S_DISABLE_MINIMAP_ROTATION);
		S_ALLOW_BEARDED_LADIES = bool("S_ALLOW_BEARDED_LADIES", S_ALLOW_BEARDED_LADIES);
		S_PRIDE_MONTH = bool("S_PRIDE_MONTH", S_PRIDE_MONTH);
	}

	private static boolean bool(String key, boolean current) {
		String value = prop.getProperty(key);
		return value == null ? current : Boolean.parseBoolean(value);
	}

	private static int integer(String key, int current) {
		String value = prop.getProperty(key);
		if (value == null)
			return current;
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			e.printStackTrace(); // desktop's loop logs a bad value and keeps the field too
			return current;
		}
	}

	static void updateServerConfiguration(Properties newConfig) {
		for (Map.Entry<Object, Object> p : newConfig.entrySet()) {
			prop.setProperty(String.valueOf(p.getKey()), String.valueOf(p.getValue()));
		}
		setConfigurationFromProperties();
	}

	public static String getServerIp() { return prop.getProperty("SERVER_IP"); }

	public static int getServerPort() { return Integer.parseInt(prop.getProperty("SERVER_PORT")); }

	public static String getServerName() {
		return prop.getProperty("SERVER_NAME");
	}

	public static String getServerNameWelcome() {
		return prop.getProperty("SERVER_NAME_WELCOME");
	}

	static String getWelcomeText() {
		return prop.getProperty("WELCOME_TEXT");
	}

	public static String getCommandPrefix() {
		return prop.getProperty("COMMAND_PREFIX");
	}

	static String getcLogoSpriteId() {
		return C_LOGO_SPRITE_ID;
	}

	public static int getFPS() {
		return C_FPS;
	}

	public static boolean wantMembers() {
		return MEMBER_WORLD;
	}

	public static boolean isAndroid() {
		return F_ANDROID_BUILD;
	}

	static boolean Remember() {
		return S_WANT_REMEMBER;
	}

	static boolean wantEmail() {
		return C_WANT_EMAIL;
	}

	static boolean allowResize1() {
		return S_ALLOW_RESIZE;
	}

	static boolean isLenientContactDetails() {
		return S_LENIENT_CONTACT_DETAILS;
	}
}
