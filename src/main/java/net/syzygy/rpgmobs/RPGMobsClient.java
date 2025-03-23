package net.syzygy.rpgmobs;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.syzygy.rpgmobs.entity.CobbleProjectileComponents.CobbleProjectileEntity;
import net.syzygy.rpgmobs.entity.CobbleProjectileComponents.CobbleProjectileModel;
import net.syzygy.rpgmobs.entity.CobbleProjectileComponents.CobbleProjectileRenderer;
import net.syzygy.rpgmobs.entity.CrystillineMagmiteComponents.CrystallineMagmiteEntity;
import net.syzygy.rpgmobs.entity.CrystillineMagmiteComponents.CrystallineMagmiteModel;
import net.syzygy.rpgmobs.entity.CrystillineMagmiteComponents.CrystallineMagmiteRenderer;
import net.syzygy.rpgmobs.entity.ModEntities;

public class RPGMobsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityModelLayerRegistry.registerModelLayer(CrystallineMagmiteEntity.CRYSTALLINE_MAGMITE, CrystallineMagmiteModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CRYSTALLINE_MAGMITE, CrystallineMagmiteRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(CobbleProjectileEntity.COBBLE_PROJECTILE, CobbleProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.COBBLE_PROJECTILE, CobbleProjectileRenderer::new);
    }
}
