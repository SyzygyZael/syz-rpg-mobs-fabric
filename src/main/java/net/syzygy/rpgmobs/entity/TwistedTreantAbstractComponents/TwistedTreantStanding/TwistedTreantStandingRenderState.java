package net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreantStanding;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

@Environment(EnvType.CLIENT)
public class TwistedTreantStandingRenderState extends LivingEntityRenderState {
    public TwistedTreantStandingRenderState() {}

    public float netHeadYaw;
    public float headPitch;
    public float limbFrequency;
    public float limbAmplitudeMultiplier;

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkingAnimationState = new AnimationState();
    public final AnimationState attack1AnimationState = new AnimationState();
    public final AnimationState attack2AnimationState = new AnimationState();
}
