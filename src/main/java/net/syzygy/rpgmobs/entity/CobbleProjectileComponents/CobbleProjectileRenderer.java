package net.syzygy.rpgmobs.entity.CobbleProjectileComponents;

import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;

public class CobbleProjectileRenderer extends EntityRenderer<CobbleProjectileEntity, CobbleProjectileRenderState> {
    public static final Identifier TEXTURE = Identifier.of(RPGMobs.MOD_ID, "textures/entity/cobble_projectile.png");

    public CobbleProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public CobbleProjectileRenderState createRenderState() {
        return new CobbleProjectileRenderState();
    }

    @Override
    public void updateRenderState(CobbleProjectileEntity entity, CobbleProjectileRenderState state, float tickProgress) {
        super.updateRenderState(entity, state, tickProgress);
    }

    @Override
    public void render(CobbleProjectileRenderState renderState, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        super.render(renderState, matrices, queue, cameraState);
    }
}
