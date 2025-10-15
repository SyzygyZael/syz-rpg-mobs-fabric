package net.syzygy.rpgmobs;

import net.fabricmc.api.ModInitializer;

import net.syzygy.rpgmobs.config.ModConfig;
import net.syzygy.rpgmobs.entity.ModEntities;
import net.syzygy.rpgmobs.item.ModItemGroups;
import net.syzygy.rpgmobs.item.ModItems;
import net.syzygy.rpgmobs.particle.ModParticles;
import net.syzygy.rpgmobs.sound.ModSounds;
import net.syzygy.rpgmobs.util.ModRegistries;
import net.syzygy.rpgmobs.world.gen.ModEntitySpawns;
import java.util.logging.Logger;

public class RPGMobs implements ModInitializer {
	public static final String MOD_ID = "rpgmobs";
	public static final Logger LOGGER = Logger.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModConfig.registerConfigs();
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModRegistries.registerModStuffs();
		ModEntities.registerModEntites();
		ModEntitySpawns.addSpawns();
		ModParticles.registerParticles();
		ModSounds.registerSounds();
	}
}