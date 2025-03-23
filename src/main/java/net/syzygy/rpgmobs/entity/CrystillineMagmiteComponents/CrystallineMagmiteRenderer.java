package net.syzygy.rpgmobs.entity.CrystillineMagmiteComponents;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;

public class CrystallineMagmiteRenderer extends MobEntityRenderer<CrystallineMagmiteEntity, CrystallineMagmiteModel<CrystallineMagmiteEntity>> {
    private static final Identifier TEXTURE = new Identifier(RPGMobs.MOD_ID, "textures/entity/crystalline_magmite.png");

    public CrystallineMagmiteRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new CrystallineMagmiteModel<>(ctx.getPart(CrystallineMagmiteEntity.CRYSTALLINE_MAGMITE)), 1.0f);
    }

    @Override
    public Identifier getTexture(CrystallineMagmiteEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(CrystallineMagmiteEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
