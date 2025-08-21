package net.syzygy.rpgmobs.entity.client.TwistedTreantComponents.TwistedTreant;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.entity.client.CrystillineMagmiteComponents.CrystallineMagmiteRenderState;
import net.syzygy.rpgmobs.entity.custom.TwistedTreantEntity;

public class TwistedTreantRenderer extends MobEntityRenderer<TwistedTreantEntity, TwistedTreantRenderState, TwistedTreantModel> {
    private static final Identifier TEXTURE = Identifier.of(RPGMobs.MOD_ID, "textures/entity/twisted_treant.png");

    public TwistedTreantRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new TwistedTreantModel(ctx.getPart(TwistedTreantEntity.TWISTED_TREANT)), 0.7f);
    }

    @Override
    public void render(TwistedTreantRenderState livingEntityRenderState, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(TwistedTreantRenderState state) {
        return TEXTURE;
    }

    @Override
    public TwistedTreantRenderState createRenderState() {
        return new TwistedTreantRenderState();
    }

    @Override
    public void updateRenderState(TwistedTreantEntity livingEntity, TwistedTreantRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);

        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
    }
}
