package net.syzygy.rpgmobs.entity.client.CrystillineMagmiteComponents;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.entity.custom.CrystallineMagmiteEntity;

public class CrystallineMagmiteRenderer extends MobEntityRenderer<CrystallineMagmiteEntity, CrystallineMagmiteRenderState, CrystallineMagmiteModel> {
    private static final Identifier TEXTURE = Identifier.of(RPGMobs.MOD_ID, "textures/entity/crystalline_magmite.png");

    public CrystallineMagmiteRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new CrystallineMagmiteModel(ctx.getPart(CrystallineMagmiteEntity.CRYSTALLINE_MAGMITE)), 1.0f);
    }

    @Override
    public void render(CrystallineMagmiteRenderState livingEntityRenderState, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public CrystallineMagmiteRenderState createRenderState() {
        return new CrystallineMagmiteRenderState();
    }

    @Override
    public Identifier getTexture(CrystallineMagmiteRenderState state) {
        return TEXTURE;
    }

    @Override
    public void updateRenderState(CrystallineMagmiteEntity livingEntity, CrystallineMagmiteRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);

        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
        livingEntityRenderState.attack1AnimationState.copyFrom(livingEntity.attack1AnimationState);
        livingEntityRenderState.attack2AnimationState.copyFrom(livingEntity.attack2AnimationState);
    }
}
