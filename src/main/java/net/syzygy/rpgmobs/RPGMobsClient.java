package net.syzygy.rpgmobs;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.syzygy.rpgmobs.entity.ArchangelEntity;
import net.syzygy.rpgmobs.entity.client.ArchangelComponents.ArchangelModel;
import net.syzygy.rpgmobs.entity.client.ArchangelComponents.ArchangelRenderer;
import net.syzygy.rpgmobs.entity.CobbleProjectileEntity;
import net.syzygy.rpgmobs.entity.client.CobbleProjectileComponents.CobbleProjectileModel;
import net.syzygy.rpgmobs.entity.client.CobbleProjectileComponents.CobbleProjectileRenderer;
import net.syzygy.rpgmobs.entity.CrystallineMagmiteEntity;
import net.syzygy.rpgmobs.entity.client.CrystillineMagmiteComponents.CrystallineMagmiteModel;
import net.syzygy.rpgmobs.entity.client.CrystillineMagmiteComponents.CrystallineMagmiteRenderer;
import net.syzygy.rpgmobs.entity.ModEntities;
import net.syzygy.rpgmobs.entity.TwistedTreantEntity;
import net.syzygy.rpgmobs.entity.client.TwistedTreantComponents.TwistedTreant.TwistedTreantModel;
import net.syzygy.rpgmobs.entity.client.TwistedTreantComponents.TwistedTreant.TwistedTreantRenderer;
import net.syzygy.rpgmobs.entity.TwistedTreantStandingEntity;
import net.syzygy.rpgmobs.entity.client.TwistedTreantComponents.TwistedTreantStanding.TwistedTreantStandingModel;
import net.syzygy.rpgmobs.entity.client.TwistedTreantComponents.TwistedTreantStanding.TwistedTreantStandingRenderer;

public class RPGMobsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(CrystallineMagmiteEntity.CRYSTALLINE_MAGMITE, CrystallineMagmiteModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CRYSTALLINE_MAGMITE, CrystallineMagmiteRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(CobbleProjectileEntity.COBBLE_PROJECTILE, CobbleProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.COBBLE_PROJECTILE, CobbleProjectileRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ArchangelEntity.ARCHANGEL, ArchangelModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ARCHANGEL, ArchangelRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(TwistedTreantEntity.TWISTED_TREANT, TwistedTreantModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TWISTED_TREANT, TwistedTreantRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(TwistedTreantStandingEntity.TWISTED_TREANT_STANDING, TwistedTreantStandingModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TWISTED_TREANT_STANDING, TwistedTreantStandingRenderer::new);
    }
}
