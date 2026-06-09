package net.syzygy.rpgmobs.entity.CrystillineMagmiteComponents;

import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

@Environment(net.fabricmc.api.EnvType.CLIENT)
public class CrystallineMagmiteRenderState extends LivingEntityRenderState {
    public float netHeadYaw;
    public float netHeadPitch;

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState attack1AnimationState = new AnimationState();
    public final AnimationState attack2AnimationState = new AnimationState();

    public CrystallineMagmiteRenderState() {

    }
}
