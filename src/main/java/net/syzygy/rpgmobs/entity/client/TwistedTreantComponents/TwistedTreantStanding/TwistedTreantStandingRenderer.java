package net.syzygy.rpgmobs.entity.client.TwistedTreantComponents.TwistedTreantStanding;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.entity.client.CrystillineMagmiteComponents.CrystallineMagmiteModel;
import net.syzygy.rpgmobs.entity.custom.CrystallineMagmiteEntity;
import net.syzygy.rpgmobs.entity.custom.TwistedTreantStandingEntity;

public class TwistedTreantStandingRenderer extends MobEntityRenderer<TwistedTreantStandingEntity, TwistedTreantStandingRenderState, TwistedTreantStandingModel> {
    private static final Identifier TEXTURE = Identifier.of(RPGMobs.MOD_ID, "textures/entity/twisted_treant.png");

    public TwistedTreantStandingRenderer(EntityRendererFactory.Context context) {
        super(context, new TwistedTreantStandingModel(context.getPart(TwistedTreantStandingEntity.TWISTED_TREANT_STANDING)), 1.0f);
    }

    @Override
    public void render(TwistedTreantStandingRenderState livingEntityRenderState, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public TwistedTreantStandingRenderState createRenderState() {
        return new TwistedTreantStandingRenderState();
    }

    @Override
    public Identifier getTexture(TwistedTreantStandingRenderState state) {
        return TEXTURE;
    }

    @Override
    public void updateRenderState(TwistedTreantStandingEntity livingEntity, TwistedTreantStandingRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);

        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.standingIdleAnimationState);
        livingEntityRenderState.attack1AnimationState.copyFrom(livingEntity.standingAttack1AnimationState);
        livingEntityRenderState.attack2AnimationState.copyFrom(livingEntity.standingAttack2AnimationState);
    }
}
