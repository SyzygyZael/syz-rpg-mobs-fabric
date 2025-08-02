package net.syzygy.rpgmobs;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ModInitializer;

import net.syzygy.rpgmobs.config.ModConfig;
import net.syzygy.rpgmobs.entity.ModEntities;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.syzygy.rpgmobs.item.ModItemGroups;
import net.syzygy.rpgmobs.item.ModItems;
import net.syzygy.rpgmobs.particle.ModParticles;
import net.syzygy.rpgmobs.sound.ModSounds;
import net.syzygy.rpgmobs.util.ModRegistries;
import net.syzygy.rpgmobs.world.gen.ModEntitySpawns;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RPGMobs implements ModInitializer {
	public static final String MOD_ID = "rpgmobs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModItemGroups.registerItemGroups();
		AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new);
		
		ModItems.registerModItems();
		ModRegistries.registerModStuffs();
		ModEntities.registerModEntites();
		ModEntitySpawns.addSpawns();
		ModParticles.registerParticles();
		ModSounds.registerSounds();
	}
}