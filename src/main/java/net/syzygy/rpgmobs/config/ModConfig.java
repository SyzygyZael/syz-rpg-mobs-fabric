package net.syzygy.rpgmobs.config;

import eu.midnightdust.lib.config.MidnightConfig;
import net.syzygy.rpgmobs.RPGMobs;

public class ModConfig extends MidnightConfig {
    public static final String ENTITIES = "entities";
    public static final String ITEMS = "items";


    @Entry(category = ENTITIES) public static int archangelSpawnWeight = 4;
    @Entry(category = ENTITIES) public static int crystallineMagmiteSpawnWeight = 7;
    @Entry(category = ENTITIES) public static int twistedTreantSpawnWeight = 7;
    @Entry(category = ENTITIES) public static int chimeraSpawnWeight = 2;
    @Entry(category = ENTITIES) public static int orchidManeaterSpawnWeight = 7;

    @Entry(category = ENTITIES) public static boolean archangelDoSpawn = true;
    @Entry(category = ENTITIES) public static boolean crystallineMagmiteDoSpawn = true;
    @Entry(category = ENTITIES) public static boolean twistedTreantDoSpawn = true;
    @Entry(category = ENTITIES) public static boolean chimeraDoSpawn = true;
    @Entry(category = ENTITIES) public static boolean orchidManeaterDoSpawn = true;

    @Entry(category = ENTITIES) public static double archangelAttackDamage = 6.8F;
    @Entry(category = ENTITIES) public static double crystallineMagmiteAttackDamage = 6.0F;
    @Entry(category = ENTITIES) public static double twistedTreantAttackDamage = 5.8F;
    @Entry(category = ENTITIES) public static double standingTwistedTreantAttackDamage = 6.8F;
    @Entry(category = ENTITIES) public static double chimeraAttackDamage = 8.5F;
    @Entry(category = ENTITIES) public static double orchidManeaterAttackDamage = 6.0F;

    @Entry(category = ITEMS) public static int shardBladeDamage = 11;
    @Entry(category = ITEMS) public static int demonicBladeDamage = 12;

    @Entry(category = ITEMS) public static int staffOfTheForestMonarchSpawnLimit = 2;

    public static void registerConfigs() {
        RPGMobs.LOGGER.info("Enable configs for " + RPGMobs.MOD_ID);

        MidnightConfig.init(RPGMobs.MOD_ID, ModConfig.class);
    }
}
