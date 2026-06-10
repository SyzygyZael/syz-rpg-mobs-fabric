package net.syzygy.rpgmobs.entity.OrchidManeaterAbstractComponents.OrchidManeater;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.client.RPGMobsEntityModelLayers;

public class OrchidManeaterRenderer extends MobEntityRenderer<OrchidManeaterEntity, OrchidManeaterRenderState, OrchidManeaterModel> {
    private static final Identifier TEXTURE = Identifier.of(RPGMobs.MOD_ID, "textures/entity/orchid_maneater.png");

    public OrchidManeaterRenderer(EntityRendererFactory.Context context) {
        super(context, new OrchidManeaterModel(context.getPart(RPGMobsEntityModelLayers.ORCHID_MANEATER)), 0.0F);
    }

    @Override
    public OrchidManeaterRenderState createRenderState() {
        return new OrchidManeaterRenderState();
    }

    @Override
    public Identifier getTexture(OrchidManeaterRenderState state) {
        return TEXTURE;
    }

    @Override
    public void updateRenderState(OrchidManeaterEntity livingEntity, OrchidManeaterRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);

        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
        livingEntityRenderState.walkingAnimationState.copyFrom(livingEntity.walkAnimationState);
        livingEntityRenderState.attack1AnimationState.copyFrom(livingEntity.attackAnimationState);
    }
}