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
                BiomeKeys.STONY_PEAKS), SpawnGroup.AMBIENT, ModEntities.CRYSTALLINE_MAGMITE, 20, 1, 1);
        SpawnRestriction.register(ModEntities.CRYSTALLINE_MAGMITE, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);


    }
}
