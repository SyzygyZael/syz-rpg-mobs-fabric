package net.syzygy.rpgmobs.entity.ArchangelComponents;

import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

@Environment(net.fabricmc.api.EnvType.CLIENT)
public class ArchangelRenderState extends LivingEntityRenderState {
    public float limbSwing;
    public float limbSwingAmount;
    public float ageInTicks;
    public float netHeadYaw;
    public float headPitch;

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attack1AnimationState = new AnimationState();
    public final AnimationState attack2AnimationState = new AnimationState();
    public final AnimationState airAttackAnimationState = new AnimationState();

    public ArchangelRenderState() {

    }
}
