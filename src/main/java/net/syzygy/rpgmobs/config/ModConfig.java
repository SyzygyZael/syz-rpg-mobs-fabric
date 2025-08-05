package net.syzygy.rpgmobs.config;

import eu.midnightdust.lib.config.MidnightConfig;
import net.syzygy.rpgmobs.RPGMobs;


public class ModConfig extends MidnightConfig{
    public static final String ENTITIES = "entities";
    public static final String ITEMS = "items";


    @Entry(category = ENTITIES) public static int archangelSpawnWeight = 7;
    @Entry(category = ENTITIES) public static int crystallineMagmiteSpawnWeight = 10;
    @Entry(category = ENTITIES) public static int twistedTreantSpawnWeight = 9;

    @Entry(category = ENTITIES) public static boolean archangelDoSpawn = true;
    @Entry(category = ENTITIES) public static boolean crystallineMagmiteDoSpawn = true;
    @Entry(category = ENTITIES) public static boolean twistedTreantDoSpawn = true;

    @Entry(category = ENTITIES) public static double archangelAttackDamage = 6.8F;
    @Entry(category = ENTITIES) public static double crystallineMagmiteAttackDamage = 6.0F;
    @Entry(category = ENTITIES) public static double twistedTreantAttackDamage = 5.8F;
    @Entry(category = ENTITIES) public static double standingTwistedTreantAttackDamage = 6.8F;

    @Entry(category = ITEMS) public static int shardBladeDamage = 11;

    @Entry(category = ITEMS) public static int staffOfTheForestMonarchSpawnLimit = 2;

    public static void registerConfigs() {
        RPGMobs.LOGGER.info("Enable configs for " + RPGMobs.MOD_ID);

        MidnightConfig.init(RPGMobs.MOD_ID, ModConfig.class);
    }
}
