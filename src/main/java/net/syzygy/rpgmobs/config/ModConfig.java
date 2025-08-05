package net.syzygy.rpgmobs.config;

import eu.midnightdust.lib.config.MidnightConfig;
import net.syzygy.rpgmobs.RPGMobs;

public class ModConfig {

    @MidnightConfig.Entry public static int archangelSpawnWeight = 7;
    @MidnightConfig.Entry public static int crystallineMagmiteSpawnWeight = 10;
    @MidnightConfig.Entry public static int twistedTreantSpawnWeight = 9;

    @MidnightConfig.Entry public static boolean archangelDoSpawn = true;
    @MidnightConfig.Entry public static boolean crystallineMagmiteDoSpawn = true;
    @MidnightConfig.Entry public static boolean twistedTreantDoSpawn = true;

    @MidnightConfig.Entry public static double archangelAttackDamage = 6.8F;
    @MidnightConfig.Entry public static double crystallineMagmiteAttackDamage = 6.0F;
    @MidnightConfig.Entry public static double twistedTreantAttackDamage = 5.8F;
    @MidnightConfig.Entry public static double standingTwistedTreantAttackDamage = 6.8F;

    @MidnightConfig.Entry public static int shardBladeDamage = 11;

    @MidnightConfig.Entry public static int staffOfTheForestMonarchSpawnLimit = 2;

    public static void registerConfigs() {
        RPGMobs.LOGGER.info("Enable configs for " + RPGMobs.MOD_ID);

        MidnightConfig.init(RPGMobs.MOD_ID, ModConfig.class);
    }
}
