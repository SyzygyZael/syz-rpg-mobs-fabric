package net.syzygy.rpgmobs.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.syzygy.rpgmobs.entity.ModEntities;

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
                ), SpawnGroup.AMBIENT, ModEntities.CRYSTALLINE_MAGMITE, 12, 1, 1);
        SpawnRestriction.register(ModEntities.CRYSTALLINE_MAGMITE, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

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
                ), SpawnGroup.AMBIENT, ModEntities.ARCHANGEL, 4, 1, 1);
        SpawnRestriction.register(ModEntities.ARCHANGEL, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}
