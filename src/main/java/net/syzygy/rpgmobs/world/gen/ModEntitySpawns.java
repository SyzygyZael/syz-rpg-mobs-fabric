package net.syzygy.rpgmobs.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.biome.BiomeKeys;
import net.syzygy.rpgmobs.entity.ArchangelComponents.ArchangelEntity;
import net.syzygy.rpgmobs.entity.CrystillineMagmiteComponents.CrystallineMagmiteEntity;
import net.syzygy.rpgmobs.entity.ModEntities;
import net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreant.TwistedTreantEntity;

public class ModEntitySpawns {

    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                BiomeKeys.PLAINS,
                BiomeKeys.WINDSWEPT_FOREST,
                BiomeKeys.STONY_SHORE,
                BiomeKeys.STONY_PEAKS,
                BiomeKeys.DESERT,
                BiomeKeys.WINDSWEPT_SAVANNA,
                BiomeKeys.SAVANNA,
                BiomeKeys.SAVANNA_PLATEAU,
                BiomeKeys.WINDSWEPT_HILLS,
                BiomeKeys.DRIPSTONE_CAVES,
                BiomeKeys.LUSH_CAVES,
                BiomeKeys.SNOWY_BEACH,
                BiomeKeys.SNOWY_PLAINS,
                BiomeKeys.SNOWY_SLOPES,
                BiomeKeys.SNOWY_TAIGA,
                BiomeKeys.GROVE,
                BiomeKeys.MEADOW,
                BiomeKeys.FROZEN_PEAKS,
                BiomeKeys.SNOWY_PLAINS,
                BiomeKeys.SUNFLOWER_PLAINS
                ), SpawnGroup.MONSTER, ModEntities.CRYSTALLINE_MAGMITE, 10, 1, 1);
        SpawnRestriction.register(ModEntities.CRYSTALLINE_MAGMITE, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, CrystallineMagmiteEntity::canSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                BiomeKeys.PLAINS,
                BiomeKeys.WINDSWEPT_FOREST,
                BiomeKeys.STONY_SHORE,
                BiomeKeys.STONY_PEAKS,
                BiomeKeys.DESERT,
                BiomeKeys.WINDSWEPT_SAVANNA,
                BiomeKeys.SAVANNA,
                BiomeKeys.SAVANNA_PLATEAU,
                BiomeKeys.WINDSWEPT_HILLS,
                BiomeKeys.SNOWY_BEACH,
                BiomeKeys.SNOWY_PLAINS,
                BiomeKeys.SNOWY_SLOPES,
                BiomeKeys.SNOWY_TAIGA,
                BiomeKeys.GROVE,
                BiomeKeys.MEADOW,
                BiomeKeys.FROZEN_PEAKS,
                BiomeKeys.SNOWY_PLAINS,
                BiomeKeys.SUNFLOWER_PLAINS
                ), SpawnGroup.MONSTER, ModEntities.ARCHANGEL, 7, 1, 1);
        SpawnRestriction.register(ModEntities.ARCHANGEL, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ArchangelEntity::canSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                BiomeKeys.BAMBOO_JUNGLE,
                BiomeKeys.BIRCH_FOREST,
                BiomeKeys.CHERRY_GROVE,
                BiomeKeys.CRIMSON_FOREST,
                BiomeKeys.DARK_FOREST,
                BiomeKeys.FLOWER_FOREST,
                BiomeKeys.TAIGA,
                BiomeKeys.SNOWY_TAIGA,
                BiomeKeys.WOODED_BADLANDS,
                BiomeKeys.OLD_GROWTH_BIRCH_FOREST,
                BiomeKeys.OLD_GROWTH_PINE_TAIGA,
                BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA,
                BiomeKeys.MANGROVE_SWAMP,
                BiomeKeys.JUNGLE,
                BiomeKeys.BAMBOO_JUNGLE,
                BiomeKeys.FOREST
        ), SpawnGroup.MONSTER, ModEntities.TWISTED_TREANT, 9, 1, 2);
        SpawnRestriction.register(ModEntities.TWISTED_TREANT, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, TwistedTreantEntity::canSpawn);
    }
}
