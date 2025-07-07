package net.syzygy.rpgmobs.entity.ArchangelComponents;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class ArchangelModel<T extends ArchangelEntity> extends SinglePartEntityModel<T> {
	private final ModelPart archangel;
	private final ModelPart head;
	private final ModelPart right_arm;
	private final ModelPart sword;
	private final ModelPart left_arm;
	private final ModelPart right_wing;
	private final ModelPart left_wing;
	private final ModelPart torso;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	public float headYaw;
	public float headPitch;

	public ArchangelModel(ModelPart root) {
		this.archangel = root.getChild("archangel");
		this.head = this.archangel.getChild("head");
		this.right_arm = this.archangel.getChild("right_arm");
		this.sword = this.right_arm.getChild("sword");
		this.left_arm = this.archangel.getChild("left_arm");
		this.right_wing = this.archangel.getChild("right_wing");
		this.left_wing = this.archangel.getChild("left_wing");
		this.torso = this.archangel.getChild("torso");
		this.right_leg = this.archangel.getChild("right_leg");
		this.left_leg = this.archangel.getChild("left_leg");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData archangel = modelPartData.addChild("archangel", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 8.0F, 0.0F));

		ModelPartData head = archangel.addChild("head", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 32).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, -8.0F, 0.0F));

		ModelPartData right_arm = archangel.addChild("right_arm", ModelPartBuilder.create().uv(32, 45).cuboid(-5.0F, -3.0F, -3.0F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F))
		.uv(56, 50).cuboid(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 5.0F, new Dilation(-0.01F)), ModelTransform.pivot(-4.0F, -6.0F, 0.0F));

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
		.uv(102, 10).cuboid(0.0F, -2.0F, -16.0F, 1.0F, 3.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 9.0F, 0.0F));

		ModelPartData left_arm = archangel.addChild("left_arm", ModelPartBuilder.create().uv(32, 33).cuboid(0.0F, -3.0F, -3.0F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F))
		.uv(18, 57).cuboid(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 5.0F, new Dilation(-0.01F)), ModelTransform.pivot(4.0F, -6.0F, 0.0F));

		ModelPartData right_wing = archangel.addChild("right_wing", ModelPartBuilder.create().uv(0, 10).cuboid(5.0F, 1.0F, 1.0F, 24.0F, 6.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 2).cuboid(-1.0F, -1.0F, 1.0F, 30.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(48, 8).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.001F)), ModelTransform.of(1.0F, -6.0F, 4.0F, 0.0F, 0.0F, -0.48F));

		ModelPartData left_wing = archangel.addChild("left_wing", ModelPartBuilder.create().uv(48, 4).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(-0.001F))
		.uv(0, 0).cuboid(-29.0F, -1.0F, 1.0F, 30.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 4).cuboid(-29.0F, 1.0F, 1.0F, 24.0F, 6.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -6.0F, 4.0F, 0.0F, 0.0F, 0.48F));

		ModelPartData torso = archangel.addChild("torso", ModelPartBuilder.create().uv(32, 16).cuboid(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 5.0F, new Dilation(0.0F))
		.uv(58, 16).cuboid(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 5.0F, new Dilation(-0.3F)), ModelTransform.pivot(0.0F, 4.0F, 0.0F));

		ModelPartData right_leg = archangel.addChild("right_leg", ModelPartBuilder.create().uv(0, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 4.0F, 0.0F));

		ModelPartData left_leg = archangel.addChild("left_leg", ModelPartBuilder.create().uv(56, 33).cuboid(-1.0F, 0.0F, -2.0F, 4.0F, 12.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 4.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(ArchangelEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

		this.animateMovement(ArchangelAnimations.idle_animation, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ArchangelAnimations.idle_animation, ageInTicks, 1f);
		this.updateAnimation(entity.attack1AnimationState, ArchangelAnimations.normal_attack_animation, ageInTicks, 1f);
		this.updateAnimation(entity.attack2AnimationState, ArchangelAnimations.second_attack_animation, ageInTicks, 1f);
		this.updateAnimation(entity.airAttackAnimationState, ArchangelAnimations.air_attack_animation, ageInTicks, 1f);
	}

	private void setHeadAngles(ArchangelEntity entity, float headYaw, float headPitch, float animationProgress){
		headYaw	= MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
		setHeadYaw(headYaw);
		setHeadPitch(headPitch);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		archangel.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return archangel;
	}

	public float getHeadYaw() {
		return this.headYaw;
	}

	public float getHeadPitch() {
		return this.headPitch;
	}

	public void setHeadYaw(float headYaw) {
		this.headYaw = headYaw;
	}

	public void setHeadPitch(float headPitch) {
		this.headPitch = headPitch;
	}
}