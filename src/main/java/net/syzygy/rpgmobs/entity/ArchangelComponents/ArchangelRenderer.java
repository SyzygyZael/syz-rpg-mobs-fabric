package net.syzygy.rpgmobs.entity.ArchangelComponents;

import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.client.RPGMobsEntityModelLayers;

@Environment(net.fabricmc.api.EnvType.CLIENT)
public class ArchangelRenderer extends MobEntityRenderer<ArchangelEntity, ArchangelRenderState, ArchangelModel> {
    private static final Identifier TEXTURE = Identifier.of(RPGMobs.MOD_ID, "textures/entity/archangel.png");

    public ArchangelRenderer(EntityRendererFactory.Context context) {
        super(context, new ArchangelModel(context.getPart(RPGMobsEntityModelLayers.ARCHANGEL)), 0.0F);
    }

    @Override
    public Identifier getTexture(ArchangelRenderState state) {
        return TEXTURE;
    }

    @Override
    public ArchangelRenderState createRenderState() {
        return new ArchangelRenderState();
    }

    @Override
    public void updateRenderState(ArchangelEntity livingEntity, ArchangelRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);

        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
        livingEntityRenderState.attack1AnimationState.copyFrom(livingEntity.attack1AnimationState);
        livingEntityRenderState.attack2AnimationState.copyFrom(livingEntity.attack2AnimationState);
        livingEntityRenderState.airAttackAnimationState.copyFrom(livingEntity.airAttackAnimationState);
    }
}
