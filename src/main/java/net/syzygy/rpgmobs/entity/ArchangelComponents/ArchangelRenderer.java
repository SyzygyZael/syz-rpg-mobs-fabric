package net.syzygy.rpgmobs.entity.ArchangelComponents;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;

public class ArchangelRenderer extends MobEntityRenderer<ArchangelEntity, ArchangelModel<ArchangelEntity>> {
    private static final Identifier TEXTURE = new Identifier(RPGMobs.MOD_ID, "textures/entity/archangel.png");

    public ArchangelRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new ArchangelModel<>(ctx.getPart(ArchangelEntity.ARCHANGEL)), 0.7f);
    }

    @Override
    public Identifier getTexture(ArchangelEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(ArchangelEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
