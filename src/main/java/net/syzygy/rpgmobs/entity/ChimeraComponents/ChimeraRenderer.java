package net.syzygy.rpgmobs.entity.ChimeraComponents;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.client.RPGMobsEntityModelLayers;
import org.lwjgl.opengl.GLXEXTVisualInfo;

public class ChimeraRenderer extends MobEntityRenderer<ChimeraEntity, ChimeraRenderState, ChimeraModel> {
    private static final Identifier TEXTURE = Identifier.of(RPGMobs.MOD_ID, "textures/entity/chimera.png");

    public ChimeraRenderer(EntityRendererFactory.Context context) {
        super(context, new ChimeraModel(context.getPart(RPGMobsEntityModelLayers.CHIMERA)), 0.0F);
    }

    @Override
    public Identifier getTexture(ChimeraRenderState state) {
        return TEXTURE;
    }

    @Override
    public ChimeraRenderState createRenderState() {
        return new ChimeraRenderState();
    }

    @Override
    public void updateRenderState(ChimeraEntity livingEntity, ChimeraRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);

        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
        livingEntityRenderState.fireBreathAnimationState.copyFrom(livingEntity.fireBreathAnimationState);
        livingEntityRenderState.flyingAnimationState.copyFrom(livingEntity.flyingAnimationState);
        livingEntityRenderState.slamAnimationState.copyFrom(livingEntity.slamAnimationState);
        livingEntityRenderState.attack1AnimationState.copyFrom(livingEntity.attack1AnimationState);
        livingEntityRenderState.attack2AnimationState.copyFrom(livingEntity.attack2AnimationState);
    }
}