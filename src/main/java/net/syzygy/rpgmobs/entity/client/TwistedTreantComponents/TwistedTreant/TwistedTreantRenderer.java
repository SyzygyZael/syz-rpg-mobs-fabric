package net.syzygy.rpgmobs.entity.client.TwistedTreantComponents.TwistedTreant;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.entity.TwistedTreantEntity;

public class TwistedTreantRenderer extends MobEntityRenderer<TwistedTreantEntity, TwistedTreantModel<TwistedTreantEntity>> {
    private static final Identifier TEXTURE = new Identifier(RPGMobs.MOD_ID, "textures/entity/twisted_treant.png");

    public TwistedTreantRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new TwistedTreantModel<>(ctx.getPart(TwistedTreantEntity.TWISTED_TREANT)), 0.7f);
    }

    @Override
    public Identifier getTexture(TwistedTreantEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(TwistedTreantEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
