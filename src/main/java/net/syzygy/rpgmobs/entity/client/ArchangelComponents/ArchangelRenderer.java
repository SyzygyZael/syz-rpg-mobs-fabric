package net.syzygy.rpgmobs.entity.client.ArchangelComponents;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.entity.custom.ArchangelEntity;

public class ArchangelRenderer extends MobEntityRenderer<ArchangelEntity, ArchangelRenderState, ArchangelModel> {
    private static final Identifier TEXTURE = Identifier.of(RPGMobs.MOD_ID, "textures/entity/archangel.png");

    public ArchangelRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new ArchangelModel(ctx.getPart(ArchangelEntity.ARCHANGEL)), 0.7f);
    }

    @Override
    public void render(ArchangelRenderState state, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {

        matrixStack.scale(1f, 1f, 1f);
        super.render(state, matrixStack, vertexConsumerProvider, i);
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
