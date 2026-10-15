package net.syzygy.rpgmobs.entity.MaleficSorceressComponents;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.syzygy.rpgmobs.entity.ChimeraComponents.ChimeraEntity;

// Made with Blockbench 5.2.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class MaleficSorceressModel<T extends MaleficSorceressEntity> extends SinglePartEntityModel<T> {
	private final ModelPart malefic_witch;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart torso;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart right_leg;
	private final ModelPart left_leg;
	private final ModelPart right_sword;
	private final ModelPart left_sword;

	public float headYaw;
	public float headPitch;

	public MaleficSorceressModel(ModelPart root) {
		this.malefic_witch = root.getChild("malefic_witch");
		this.body = this.malefic_witch.getChild("body");
		this.head = this.body.getChild("head");
		this.torso = this.body.getChild("torso");
		this.right_arm = this.body.getChild("right_arm");
		this.left_arm = this.body.getChild("left_arm");
		this.right_leg = this.body.getChild("right_leg");
		this.left_leg = this.body.getChild("left_leg");
		this.right_sword = this.malefic_witch.getChild("right_sword");
		this.left_sword = this.malefic_witch.getChild("left_sword");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData malefic_witch = modelPartData.addChild("malefic_witch", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = malefic_witch.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(44, 36).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-3.0F, -4.0F, -3.0F, 6.0F, 5.0F, 6.0F, new Dilation(-0.3F))
		.uv(0, 11).cuboid(-3.0F, -4.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F))
		.uv(12, 46).cuboid(-5.0F, -4.0F, 3.0F, 10.0F, 17.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -22.0F, -1.0F));

		ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(16, 24).cuboid(-3.0F, -8.0F, -3.0F, 6.0F, 8.0F, 4.0F, new Dilation(-0.002F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

		ModelPartData cube_r1 = torso.addChild("cube_r1", ModelPartBuilder.create().uv(0, 44).cuboid(-1.0616F, -1.1449F, -0.5072F, 3.0F, 3.0F, 2.0F, new Dilation(-0.1F)), ModelTransform.of(1.0F, -7.0F, -3.0F, -0.6719F, -0.0335F, -0.0045F));

		ModelPartData cube_r2 = torso.addChild("cube_r2", ModelPartBuilder.create().uv(40, 16).cuboid(-1.9384F, -1.1449F, -0.5072F, 3.0F, 3.0F, 2.0F, new Dilation(-0.1F)), ModelTransform.of(-1.0F, -7.0F, -3.0F, -0.6719F, 0.0335F, 0.0045F));

		ModelPartData cube_r3 = torso.addChild("cube_r3", ModelPartBuilder.create().uv(40, 8).cuboid(0.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(-0.0011F)), ModelTransform.of(4.0F, 1.0F, -1.0F, -3.1416F, 0.0F, 2.8362F));

		ModelPartData cube_r4 = torso.addChild("cube_r4", ModelPartBuilder.create().uv(40, 0).cuboid(0.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new Dilation(-0.001F)), ModelTransform.of(-4.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

		ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, -20.0F, -1.0F));

		ModelPartData cube_r5 = right_arm.addChild("cube_r5", ModelPartBuilder.create().uv(32, 36).cuboid(-2.0F, 0.0F, -3.0F, 2.0F, 10.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, -20.0F, -1.0F));

		ModelPartData cube_r6 = left_arm.addChild("cube_r6", ModelPartBuilder.create().uv(36, 22).cuboid(0.0F, 0.0F, -3.0F, 2.0F, 10.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -0.1745F));

		ModelPartData right_leg = body.addChild("right_leg", ModelPartBuilder.create().uv(24, 11).cuboid(-2.0F, 4.0F, -2.0F, 4.0F, 7.0F, 4.0F, new Dilation(-0.4F))
		.uv(0, 28).cuboid(-2.0F, 9.0F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(-0.42F))
		.uv(16, 36).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(-0.2F)), ModelTransform.of(-2.0F, -11.0F, -1.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData left_leg = body.addChild("left_leg", ModelPartBuilder.create().uv(24, 0).cuboid(-2.0F, 4.0F, -3.0F, 4.0F, 7.0F, 4.0F, new Dilation(-0.4F))
		.uv(0, 28).cuboid(-2.0F, 9.0F, -3.0F, 4.0F, 1.0F, 4.0F, new Dilation(-0.42F))
		.uv(0, 34).cuboid(-2.0F, -1.0F, -3.0F, 4.0F, 6.0F, 4.0F, new Dilation(-0.2F)), ModelTransform.pivot(2.0F, -11.0F, 0.0F));

		ModelPartData right_sword = malefic_witch.addChild("right_sword", ModelPartBuilder.create().uv(60, 45).cuboid(-0.0746F, -21.0154F, -1.0F, 0.0F, 17.0F, 2.0F, new Dilation(0.0F))
		.uv(48, 54).cuboid(-0.5497F, -4.9928F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(44, 58).cuboid(-0.5497F, -3.9928F, -1.0F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(50, 60).cuboid(-0.5497F, -5.9928F, -3.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(56, 60).cuboid(-0.5497F, -5.9928F, 2.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-10.0F, -13.0F, 4.0F));

		ModelPartData left_sword = malefic_witch.addChild("left_sword", ModelPartBuilder.create().uv(60, 45).cuboid(0.0248F, -21.0154F, -1.0F, 0.0F, 17.0F, 2.0F, new Dilation(0.0F))
		.uv(48, 54).cuboid(-0.4503F, -4.9928F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(44, 58).cuboid(-0.4503F, -3.9928F, -1.0F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(50, 60).cuboid(-0.4503F, -5.9928F, -3.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(56, 60).cuboid(-0.4503F, -5.9928F, 2.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(10.0F, -13.0F, 4.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(MaleficSorceressEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

		this.animateMovement(MaleficSorceressAnimations.walk_animation, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, MaleficSorceressAnimations.idle_animation, ageInTicks, 1f);
		this.updateAnimation(entity.attack1AnimationState, MaleficSorceressAnimations.attack1_animation, ageInTicks, 1f);
		this.updateAnimation(entity.attack2AnimationState, MaleficSorceressAnimations.attack2_animation, ageInTicks, 1f);
		this.updateAnimation(entity.attack3AnimationState, MaleficSorceressAnimations.attack3_animation, ageInTicks, 1f);
		this.updateAnimation(entity.blockAnimationState, MaleficSorceressAnimations.block_animation, ageInTicks, 1f);
	}

	private void setHeadAngles(MaleficSorceressEntity entity, float headYaw, float headPitch, float animationProgress){
		headYaw	= MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
		setHeadYaw(headYaw);
		setHeadPitch(headPitch);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		malefic_witch.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return malefic_witch;
	}

	public void setHeadYaw(float headYaw) {
		this.headYaw = headYaw;
	}

	public void setHeadPitch(float headPitch) {
		this.headPitch = headPitch;
	}
}