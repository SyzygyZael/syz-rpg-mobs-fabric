package net.syzygy.rpgmobs.util;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.entity.ArchangelComponents.ArchangelEntity;
import net.syzygy.rpgmobs.entity.ChimeraComponents.ChimeraEntity;
import net.syzygy.rpgmobs.entity.CrystillineMagmiteComponents.CrystallineMagmiteEntity;
import net.syzygy.rpgmobs.entity.ModEntities;
import net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreant.TwistedTreantEntity;
import net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreantStanding.TwistedTreantStandingEntity;
import net.syzygy.rpgmobs.event.DemonicBladeApplyWitherHandler;

public class ModRegistries {
    public static void registerModStuffs() {
        registerEvents();
        registerAttributes();


        RPGMobs.LOGGER.info("Registering ModRegistries for " + RPGMobs.MOD_ID);
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.CRYSTALLINE_MAGMITE, CrystallineMagmiteEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.ARCHANGEL, ArchangelEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.TWISTED_TREANT, TwistedTreantEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.TWISTED_TREANT_STANDING, TwistedTreantStandingEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.CHIMERA, ChimeraEntity.createAttributes());
    }

    private static void registerEvents() {
        AttackEntityCallback.EVENT.register(new DemonicBladeApplyWitherHandler());
    }
}
