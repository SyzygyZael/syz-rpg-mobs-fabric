package net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreantStanding;

import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.client.RPGMobsEntityModelLayers;

@Environment(net.fabricmc.api.EnvType.CLIENT)
public class TwistedTreantStandingRenderer extends MobEntityRenderer<TwistedTreantStandingEntity, TwistedTreantStandingRenderState, TwistedTreantStandingModel> {
    private static final Identifier TEXTURE = Identifier.of(RPGMobs.MOD_ID, "textures/entity/twisted_treant.png");

    public TwistedTreantStandingRenderer(EntityRendererFactory.Context context) {
        super(context, new TwistedTreantStandingModel(context.getPart(RPGMobsEntityModelLayers.TWISTED_TREANT_STANDING)), 0.0F);
    }

    @Override
    public Identifier getTexture(TwistedTreantStandingRenderState state) {
        return TEXTURE;
    }

    @Override
    public TwistedTreantStandingRenderState createRenderState() {
        return new TwistedTreantStandingRenderState();
    }

    @Override
    public void updateRenderState(TwistedTreantStandingEntity livingEntity, TwistedTreantStandingRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);

        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.standingIdleAnimationState);
        livingEntityRenderState.walkingAnimationState.copyFrom(livingEntity.standingWalkAnimationState);
        livingEntityRenderState.attack1AnimationState.copyFrom(livingEntity.standingAttack1AnimationState);
        livingEntityRenderState.attack2AnimationState.copyFrom(livingEntity.standingAttack2AnimationState);

        livingEntityRenderState.limbFrequency = livingEntity.limbAnimator.getAnimationProgress(f);
        livingEntityRenderState.limbAmplitudeMultiplier = livingEntity.limbAnimator.getAmplitude(f);
    }
}
