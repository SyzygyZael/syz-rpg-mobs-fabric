package net.syzygy.rpgmobs.entity.OrchidManeaterAbstractComponents.OrchidManeater;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;

public class OrchidManeaterRenderer extends MobEntityRenderer<OrchidManeaterEntity, OrchidManeaterModel<OrchidManeaterEntity>> {
    private static final Identifier TEXTURE = new Identifier(RPGMobs.MOD_ID, "textures/entity/orchid_maneater.png");

    public OrchidManeaterRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new OrchidManeaterModel<>(ctx.getPart(OrchidManeaterEntity.ORCHID_MANEATER)), 0.7f);
    }

    @Override
    public Identifier getTexture(OrchidManeaterEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(OrchidManeaterEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1F, 1F, 1F);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}