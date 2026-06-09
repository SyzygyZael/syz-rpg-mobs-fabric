package net.syzygy.rpgmobs.entity.ArchangelComponents;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
@Environment(EnvType.CLIENT)
public class ArchangelModel extends EntityModel<ArchangelRenderState> {
	private final ModelPart archangel;
	private final ModelPart right_air;
	private final ModelPart left_air;
	private final ModelPart main;
	private final ModelPart head;
	private final ModelPart right_arm;
	private final ModelPart sword;
	private final ModelPart left_arm;
	private final ModelPart right_wing;
	private final ModelPart left_wing;
	private final ModelPart torso;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	private final Animation idleAnimation;
	private final Animation attack1Animation;
	private final Animation attack2Animation;
	private final Animation airAttakAnimation;

	public float headYaw;
	public float headPitch;

	public ArchangelModel(ModelPart root) {
        super(root);

        this.archangel = root.getChild("archangel");
		this.right_air = this.archangel.getChild("right_air");
		this.left_air = this.archangel.getChild("left_air");
		this.main = this.archangel.getChild("main");
		this.head = this.main.getChild("head");
		this.right_arm = this.main.getChild("right_arm");
		this.sword = this.right_arm.getChild("sword");
		this.left_arm = this.main.getChild("left_arm");
		this.right_wing = this.main.getChild("right_wing");
		this.left_wing = this.main.getChild("left_wing");
		this.torso = this.main.getChild("torso");
		this.right_leg = this.main.getChild("right_leg");
		this.left_leg = this.main.getChild("left_leg");

		this.idleAnimation = ArchangelAnimations.idle_animation.createAnimation(root);
		this.attack1Animation = ArchangelAnimations.normal_attack_animation.createAnimation(root);
		this.attack2Animation = ArchangelAnimations.second_attack_animation.createAnimation(root);
		this.airAttakAnimation = ArchangelAnimations.air_attack_animation.createAnimation(root);
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData archangel = modelPartData.addChild("archangel", ModelPartBuilder.create(), ModelTransform.of(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData right_air = archangel.addChild("right_air", ModelPartBuilder.create().uv(0, 77).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 18.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData left_air = archangel.addChild("left_air", ModelPartBuilder.create().uv(	8, 77).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 18.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData main = archangel.addChild("main", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData head = main.addChild("head", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 32).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.of(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData right_arm = main.addChild("right_arm", ModelPartBuilder.create().uv(32, 45).cuboid(-5.0F, -3.0F, -3.0F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F))
		.uv(56, 50).cuboid(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 5.0F, new Dilation(-0.01F)), ModelTransform.of(-4.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData sword = right_arm.addChild("sword", ModelPartBuilder.create().uv(76, 25).cuboid(0.0F, -1.0F, -4.0F, 1.0F, 1.0F, 8.0F, new Dilation(0.0F))
		.uv(51, 58).cuboid(0.0F, -1.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.5F))
		.uv(46, 58).cuboid(0.0F, -1.0F, 5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(63, 2).cuboid(0.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(67, 2).cuboid(0.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(75, 0).cuboid(0.0F, 1.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(59, 2).cuboid(0.0F, 2.0F, -6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(74, 4).cuboid(0.0F, -4.0F, -6.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(64, 55).cuboid(0.0F, -1.0F, -29.0F, 1.0F, 1.0F, 13.0F, new Dilation(0.0F))
		.uv(25, 63).cuboid(0.0F, -2.0F, -27.0F, 1.0F, 1.0F, 11.0F, new Dilation(0.0F))
		.uv(51, 68).cuboid(0.0F, 0.0F, -27.0F, 1.0F, 1.0F, 11.0F, new Dilation(0.0F))
		.uv(67, 6).cuboid(0.0F, -3.0F, -5.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(102, 10).cuboid(0.0F, -2.0F, -16.0F, 1.0F, 3.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 9.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData left_arm = main.addChild("left_arm", ModelPartBuilder.create().uv(32, 33).cuboid(0.0F, -3.0F, -3.0F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F))
		.uv(18, 57).cuboid(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 5.0F, new Dilation(-0.01F)), ModelTransform.of(4.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData right_wing = main.addChild("right_wing", ModelPartBuilder.create().uv(0, 10).cuboid(5.0F, 1.0F, 1.0F, 24.0F, 6.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 2).cuboid(-1.0F, -1.0F, 1.0F, 30.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(48, 8).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.001F)), ModelTransform.of(1.0F, -6.0F, 4.0F, 0.0F, 0.0F, -0.48F));

		ModelPartData left_wing = main.addChild("left_wing", ModelPartBuilder.create().uv(48, 4).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.001F))
		.uv(0, 0).cuboid(-29.0F, -1.0F, 1.0F, 30.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 4).cuboid(-29.0F, 1.0F, 1.0F, 24.0F, 6.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -6.0F, 4.0F, 0.0F, 0.0F, 0.48F));

		ModelPartData torso = main.addChild("torso", ModelPartBuilder.create().uv(32, 16).cuboid(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 5.0F, new Dilation(0.0F))
		.uv(58, 16).cuboid(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 5.0F, new Dilation(-0.3F)), ModelTransform.of(0.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData right_leg = main.addChild("right_leg", ModelPartBuilder.create().uv(0, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData left_leg = main.addChild("left_leg", ModelPartBuilder.create().uv(56, 33).cuboid(-1.0F, 0.0F, -2.0F, 4.0F, 12.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(ArchangelRenderState state) {
		super.setAngles(state);
		this.setHeadAngles(state.netHeadYaw, state.headPitch);

		this.idleAnimation.apply(state.idleAnimationState, state.age);
		this.attack1Animation.apply(state.attack1AnimationState, state.age);
		this.attack2Animation.apply(state.attack2AnimationState, state.age);
		this.airAttakAnimation.apply(state.airAttackAnimationState, state.age);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw	= MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
		setHeadYaw(headYaw);
		setHeadPitch(headPitch);
	}

	public void setHeadYaw(float headYaw) {
		this.headYaw = headYaw;
	}

	public void setHeadPitch(float headPitch) {
		this.headPitch = headPitch;
	}
}