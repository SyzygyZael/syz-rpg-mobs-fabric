package net.syzygy.rpgmobs.entity.client.TwistedTreantComponents.TwistedTreant;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

public class TwistedTreantRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attack1AnimationState = new AnimationState();
    public final AnimationState attack2AnimationState = new AnimationState();
    public final AnimationState standUpAnimationState = new AnimationState();
}
