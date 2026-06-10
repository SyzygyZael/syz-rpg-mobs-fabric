package net.syzygy.rpgmobs.entity.OrchidManeaterAbstractComponents.OrchidManeater;

import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

@Environment(net.fabricmc.api.EnvType.CLIENT)
public class OrchidManeaterRenderState extends LivingEntityRenderState {
    public float headYaw;
    public float headPitch;

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkingAnimationState = new AnimationState();
    public final AnimationState attack1AnimationState = new AnimationState();

    public OrchidManeaterRenderState() {

    }
}
