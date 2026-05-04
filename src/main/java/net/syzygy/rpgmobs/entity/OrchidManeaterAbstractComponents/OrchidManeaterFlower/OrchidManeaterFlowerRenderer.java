package net.syzygy.rpgmobs.entity.OrchidManeaterAbstractComponents.OrchidManeaterFlower;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;

public class OrchidManeaterFlowerRenderer extends MobEntityRenderer<OrchidManeaterFlowerEntity, OrchidManeaterFlowerModel<OrchidManeaterFlowerEntity>> {
    private static final Identifier TEXTURE = new Identifier(RPGMobs.MOD_ID, "textures/entity/orchid_maneater_flower.png");

    public OrchidManeaterFlowerRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new OrchidManeaterFlowerModel<>(ctx.getPart(OrchidManeaterFlowerEntity.ORCHID_MANEATER_FLOWER)), 0.3f);
    }

    @Override
    public Identifier getTexture(OrchidManeaterFlowerEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(OrchidManeaterFlowerEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1F, 1F, 1F);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
