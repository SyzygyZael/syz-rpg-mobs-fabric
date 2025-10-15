package net.syzygy.rpgmobs.entity.ChimeraComponents;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;

public class ChimeraRenderer extends MobEntityRenderer<ChimeraEntity, ChimeraModel<ChimeraEntity>> {
    private static final Identifier TEXTURE = new Identifier(RPGMobs.MOD_ID, "textures/entity/chimera.png");

    public ChimeraRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new ChimeraModel<>(ctx.getPart(ChimeraEntity.CHIMERA)), 0.7f);
    }

    @Override
    public Identifier getTexture(ChimeraEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(ChimeraEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
