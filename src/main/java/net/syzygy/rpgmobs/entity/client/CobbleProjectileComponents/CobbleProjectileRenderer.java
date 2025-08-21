package net.syzygy.rpgmobs.entity.client.CobbleProjectileComponents;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.entity.custom.CobbleProjectileEntity;

public class CobbleProjectileRenderer extends EntityRenderer<CobbleProjectileEntity, CobbleProjectileRenderState> {
    public static final Identifier TEXTURE = Identifier.of(RPGMobs.MOD_ID, "textures/entity/cobble_projectile.png");
    protected CobbleProjectileModel model;

    public CobbleProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        model = new CobbleProjectileModel(ctx.getPart(CobbleProjectileEntity.COBBLE_PROJECTILE));
    }

    @Override
    public CobbleProjectileRenderState createRenderState() {
        return new CobbleProjectileRenderState();
    }

    @Override
    public void render(CobbleProjectileRenderState state, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        VertexConsumer vertexconsumer = ItemRenderer.getItemGlintConsumer(vertexConsumers, this.model.getLayer(TEXTURE), false, false);
        this.model.render(matrices, vertexconsumer, light, 0, 1);

        matrices.pop();

        super.render(state, matrices, vertexConsumers, light);
    }

    @Override
    public void updateRenderState(CobbleProjectileEntity entity, CobbleProjectileRenderState state, float tickProgress) {
        super.updateRenderState(entity, state, tickProgress);
    }
}
