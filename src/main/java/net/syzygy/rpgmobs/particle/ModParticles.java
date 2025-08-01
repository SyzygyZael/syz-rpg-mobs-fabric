package net.syzygy.rpgmobs.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;

public class ModParticles {
    public static final DefaultParticleType ARCHANGEL_GOLD_AURA =
            registerParticle("archangel_gold_aura", FabricParticleTypes.simple());

    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(RPGMobs.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        RPGMobs.LOGGER.info("Registering Particles for " + RPGMobs.MOD_ID);
    }
}
