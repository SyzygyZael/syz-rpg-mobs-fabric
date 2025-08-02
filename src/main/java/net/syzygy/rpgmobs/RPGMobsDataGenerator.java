package net.syzygy.rpgmobs;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.syzygy.rpgmobs.datagen.ModModelProvider;
import net.syzygy.rpgmobs.datagen.ModRecipeGenerator;

public class RPGMobsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		fabricDataGenerator.addProvider(ModModelProvider::new);
		fabricDataGenerator.addProvider(ModRecipeGenerator::new);
	}
}
