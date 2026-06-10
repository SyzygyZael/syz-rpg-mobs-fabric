package net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreant;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.client.RPGMobsEntityModelLayers;

public class TwistedTreantRenderer extends MobEntityRenderer<TwistedTreantEntity, TwistedTreantRenderState, TwistedTreantModel> {
    private static final Identifier TEXTURE = Identifier.of(RPGMobs.MOD_ID, "textures/entity/twisted_treant.png");

    public TwistedTreantRenderer(EntityRendererFactory.Context context) {
        super(context, new TwistedTreantModel(context.getPart(RPGMobsEntityModelLayers.TWISTED_TREANT)), 0.0F);
    }

    @Override
    public TwistedTreantRenderState createRenderState() {
        return new TwistedTreantRenderState();
    }

    @Override
    public Identifier getTexture(TwistedTreantRenderState state) {
        return TEXTURE;
    }

    @Override
    public void updateRenderState(TwistedTreantEntity livingEntity, TwistedTreantRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);

        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
        livingEntityRenderState.walkingAnimationState.copyFrom(livingEntity.walkingAnimationState);
        livingEntityRenderState.attack1AnimationState.copyFrom(livingEntity.attack1AnimationState);
        livingEntityRenderState.attack2AnimationState.copyFrom(livingEntity.attack2AnimationState);
        livingEntityRenderState.standUpAnimationState.copyFrom(livingEntity.standingAnimationState);
    }
}
