package net.syzygy.rpgmobs.entity.CobbleProjectileComponents;

import net.minecraft.client.model.*;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;
import net.syzygy.rpgmobs.RPGMobs;

public class CobbleProjectileRenderer extends EntityRenderer<CobbleProjectileEntity> {
    public static final Identifier TEXTURE = new Identifier(RPGMobs.MOD_ID, "textures/entity/cobble_projectile.png");
    protected CobbleProjectileModel model;

    public CobbleProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        model = new CobbleProjectileModel(ctx.getPart(CobbleProjectileEntity.COBBLE_PROJECTILE));
    }

    @Override
    public void render(CobbleProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw()) - 90.0F));
        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(tickDelta, entity.prevPitch, entity.getPitch()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, this.model.getLayer(TEXTURE), false, false);
        this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 0.0F, 0.0F, 1.0F);

        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(CobbleProjectileEntity entity) {
        return TEXTURE;
    }
}
