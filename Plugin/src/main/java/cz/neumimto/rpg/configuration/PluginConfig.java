/*    
 *     Copyright (c) 2015, NeumimTo https://github.com/NeumimTo
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *     
 */

package cz.neumimto.rpg.configuration;

import cz.neumimto.configuration.Comment;
import cz.neumimto.configuration.ConfigValue;
import cz.neumimto.configuration.ConfigurationContainer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by NeumimTo on 26.12.2014.
 */
@ConfigurationContainer(path = "{WorkingDir}", filename = "Settings.conf")
public class PluginConfig {

    @Comment(content = {"If you want to use another plugin, which handles mob's hp and damage set this value to true"})
    @ConfigValue
    public static boolean OVERRIDE_MOBS = false;

    @ConfigValue
    public static long COMBAT_TIME = 20000L;
    @ConfigValue
    public static boolean CREATE_FIRST_CHAR_AFTER_LOGIN = true;

    @ConfigValue
    public static boolean REMOVE_PLAYERDATA_AFTER_PERMABAN = false;

    @ConfigValue
    public static boolean DEBUG = true;

    @ConfigValue
    public static short SKILLPOINTS_ON_START = 1;

    @ConfigValue
    public static boolean PLAYER_CAN_CHANGE_RACE = true;

    @ConfigValue
    public static boolean PLAYER_AUTO_CHOOSE_LAST_PLAYED_CHAR = true;

    @ConfigValue
    public static boolean SKILLGAIN_MESSAGES_AFTER_LOGIN = true;

    @ConfigValue
    public static boolean PLAYER_LEARNED_SKILL_GLOBAL_MESSAGE = true;

    @ConfigValue
    public static boolean PLAYER_UPGRADED_SKILL_GLOBAL_MESSAGE = true;

    @ConfigValue
    public static boolean PLAYER_REFUNDED_SKILL_GLOBAL_MESSAGE = true;

    @ConfigValue
    public static short ATTRIBUTEPOINTS_ON_START = 1;

    @ConfigValue
    public static int PLAYER_MAX_CHARS = 5;

    @ConfigValue
    public static boolean CAN_REFUND_SKILL = true;

    @ConfigValue
    @Comment(content = {"Works only, if the server is using jdk, for passing these arguments with jre use -D flag"})
    public static String JJS_ARGS = "--optimistic-types=true";

    @ConfigValue
    @Comment(content = {"Time period in milliseconds"})
    public static long MANA_REGENERATION_RATE = 1000;

    @ConfigValue
    public static String LORE_EFFECT_COLOR = "$b";

    @ConfigValue
    public static boolean ALLOW_COMBAT_FOR_CHARACTERLESS_PLAYERS = true;

    @ConfigValue
    @Comment(content = "Works only if PLAYER_MAX_CHARS > 1.")
    public static boolean TELEPORT_PLAYER_TO_LAST_CHAR_LOCATION = true;

    @ConfigValue
    public static String RW_LORE_COLOR;

    @ConfigValue
    public static double HEALTH_SCALE = 2;

    @ConfigValue
    @Comment(content = {"Count of attribute players gain per level"})
    public static int ATTRIBUTEPOINTS_PER_LEVEL;

    @ConfigValue
    @Comment(content = {"Count of skillpoints players gain per level"})
    public static int SKILLPOINTS_PER_LEVEL;

    @ConfigValue
    public static Set<String> ALLOWED_RUNES_ITEMTYPES = new HashSet<String>() {{
        add("minecraft:nether_star");
    }};

    @ConfigValue
    public static boolean AUTOREMOVE_NONEXISTING_RUNEWORDS = false;

    @ConfigValue
    @Comment(content = {"Enables passing arguments to skills", "eg.: /skill Fireball arg1 arg2"})
    public static boolean SKILL_COMMAND_ARGUMENTS = false;

    @ConfigValue
    @Comment(content = {"Multiplier of shared experience gain for players in a party.", "Exp=(MobExp*Mult)/partyplayers in area"})
    public static double PARTY_EXPERIENCE_MULTIPLIER = 2;

	@ConfigValue
	public static double PARTY_EXPERIENCE_SHARE_DISTANCE = 25;

	@ConfigValue
	@Comment(content = {"Value lesser than 0 means there will be no party limit. Additional content can override this value."})
	public static double MAX_PARTY_SIZE = -68458;


}
