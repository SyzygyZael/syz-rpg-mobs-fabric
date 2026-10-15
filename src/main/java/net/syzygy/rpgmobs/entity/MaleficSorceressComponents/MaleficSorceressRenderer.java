package net.syzygy.rpgmobs.entity.MaleficSorceressComponents;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;

public class MaleficSorceressRenderer extends MobEntityRenderer<MaleficSorceressEntity, MaleficSorceressModel<MaleficSorceressEntity>> {
    private static final Identifier TEXTURE = new Identifier(RPGMobs.MOD_ID, "textures/entity/malefic_sorceress.png");

    public MaleficSorceressRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new MaleficSorceressModel<>(ctx.getPart(MaleficSorceressEntity.MALEFIC_SORCERESS)), 0.7f);
    }

    @Override
    public Identifier getTexture(MaleficSorceressEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(MaleficSorceressEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
