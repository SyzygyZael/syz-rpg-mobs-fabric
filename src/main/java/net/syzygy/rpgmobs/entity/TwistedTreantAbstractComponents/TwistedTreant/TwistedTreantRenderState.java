package net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreant;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

public class TwistedTreantRenderState extends LivingEntityRenderState {
    public  TwistedTreantRenderState() {

    }

    public float netHeadYaw;
    public float headPitch;

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkingAnimationState = new AnimationState();
    public final AnimationState attack1AnimationState = new AnimationState();
    public final AnimationState standUpAnimationState = new AnimationState();
    public final AnimationState attack2AnimationState = new AnimationState();
}
