package net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreantStanding;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;

public class TwistedTreantStandingRenderer extends MobEntityRenderer<TwistedTreantStandingEntity, TwistedTreantStandingModel<TwistedTreantStandingEntity>> {
    private static final Identifier TEXTURE = new Identifier(RPGMobs.MOD_ID, "textures/entity/twisted_treant.png");

    public TwistedTreantStandingRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new TwistedTreantStandingModel<>(ctx.getPart(TwistedTreantStandingEntity.TWISTED_TREANT_STANDING)), 0.7f);
    }

    @Override
    public Identifier getTexture(TwistedTreantStandingEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(TwistedTreantStandingEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
