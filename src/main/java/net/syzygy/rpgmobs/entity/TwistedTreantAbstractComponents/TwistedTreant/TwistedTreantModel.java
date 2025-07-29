package net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreant;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class TwistedTreantModel<T extends TwistedTreantEntity> extends SinglePartEntityModel<T> {
	private final ModelPart twisted_treant;
	private final ModelPart main;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart right_arm;
	private final ModelPart right_forearm;
	private final ModelPart right_elbow;
	private final ModelPart right_spike_in_hand;
	private final ModelPart upper_right_arm;
	private final ModelPart right_spike;
	private final ModelPart left_arm;
	private final ModelPart left_forearm;
	private final ModelPart left_elbow;
	private final ModelPart left_spike_in_hand;
	private final ModelPart left_upper_arm;
	private final ModelPart left_spike;
	private final ModelPart torso;
	private final ModelPart waist;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	public float headPitch;
	public float headYaw;

	public TwistedTreantModel(ModelPart root) {
		this.twisted_treant = root.getChild("twisted_treant");
		this.main = this.twisted_treant.getChild("main");
		this.head = this.main.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.right_arm = this.main.getChild("right_arm");
		this.right_forearm = this.right_arm.getChild("right_forearm");
		this.right_elbow = this.right_forearm.getChild("right_elbow");
		this.right_spike_in_hand = this.right_forearm.getChild("right_spike_in_hand");
		this.upper_right_arm = this.right_arm.getChild("upper_right_arm");
		this.right_spike = this.upper_right_arm.getChild("right_spike");
		this.left_arm = this.main.getChild("left_arm");
		this.left_forearm = this.left_arm.getChild("left_forearm");
		this.left_elbow = this.left_forearm.getChild("left_elbow");
		this.left_spike_in_hand = this.left_forearm.getChild("left_spike_in_hand");
		this.left_upper_arm = this.left_arm.getChild("left_upper_arm");
		this.left_spike = this.left_upper_arm.getChild("left_spike");
		this.torso = this.main.getChild("torso");
		this.waist = this.main.getChild("waist");
		this.right_leg = this.main.getChild("right_leg");
		this.left_leg = this.main.getChild("left_leg");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData twisted_treant = modelPartData.addChild("twisted_treant", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData main = twisted_treant.addChild("main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = main.addChild("head", ModelPartBuilder.create().uv(0, 34).cuboid(-4.0F, -6.0F, -4.0F, 8.0F, 7.0F, 7.0F, new Dilation(0.0F))
		.uv(50, 68).cuboid(-4.0F, -6.0F, -4.0F, 8.0F, 5.0F, 7.0F, new Dilation(-0.6F)), ModelTransform.pivot(0.0F, -22.0F, -7.0F));

		ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create().uv(89, 2).cuboid(-4.0F, -2.0F, -5.0F, 8.0F, 2.0F, 7.0F, new Dilation(-0.29F))
		.uv(89, 9).cuboid(-4.0F, -3.0F, -5.0F, 8.0F, 3.0F, 7.0F, new Dilation(-0.3F)), ModelTransform.pivot(0.0F, 1.0F, 1.0F));

		ModelPartData right_arm = main.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(-6.0F, -22.0F, -4.0F));

		ModelPartData right_forearm = right_arm.addChild("right_forearm", ModelPartBuilder.create().uv(52, 40).cuboid(-2.0F, 8.9526F, -4.5671F, 5.0F, 2.0F, 6.0F, new Dilation(-0.01F)), ModelTransform.pivot(-3.0F, 11.0F, -1.0F));

		ModelPartData cube_r1 = right_forearm.addChild("cube_r1", ModelPartBuilder.create().uv(48, 16).cuboid(-3.0F, -0.0474F, -2.5671F, 5.0F, 10.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		ModelPartData right_elbow = right_forearm.addChild("right_elbow", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -3.0F, 8.0F));

		ModelPartData cube_r2 = right_elbow.addChild("cube_r2", ModelPartBuilder.create().uv(38, 61).cuboid(-2.0F, -3.0436F, -2.0009F, 3.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 2.0F, -8.0F, -0.1309F, 0.0F, 0.0F));

		ModelPartData right_spike_in_hand = right_forearm.addChild("right_spike_in_hand", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 9.0F, 0.0F));

		ModelPartData upper_right_arm = right_arm.addChild("upper_right_arm", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r3 = upper_right_arm.addChild("cube_r3", ModelPartBuilder.create().uv(12, 74).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -4.0F, 1.0F, -1.0472F, 0.0F, 0.0F));

		ModelPartData cube_r4 = upper_right_arm.addChild("cube_r4", ModelPartBuilder.create().uv(74, 10).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -2.0F, -1.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData cube_r5 = upper_right_arm.addChild("cube_r5", ModelPartBuilder.create().uv(74, 35).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -3.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		ModelPartData cube_r6 = upper_right_arm.addChild("cube_r6", ModelPartBuilder.create().uv(74, 6).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -4.0F, 2.0F, -1.0472F, 0.0F, 0.0F));

		ModelPartData cube_r7 = upper_right_arm.addChild("cube_r7", ModelPartBuilder.create().uv(8, 73).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -2.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData cube_r8 = upper_right_arm.addChild("cube_r8", ModelPartBuilder.create().uv(74, 32).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -3.0F, 1.0F, -0.829F, 0.0F, 0.0F));

		ModelPartData cube_r9 = upper_right_arm.addChild("cube_r9", ModelPartBuilder.create().uv(0, 48).cuboid(0.0F, -2.0F, -3.0F, 5.0F, 11.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, -1.0F, 0.0F, -0.0436F, 0.0F, 0.0F));

		ModelPartData right_spike = upper_right_arm.addChild("right_spike", ModelPartBuilder.create(), ModelTransform.pivot(-7.0F, 5.0F, 7.0F));

		ModelPartData cube_r10 = right_spike.addChild("cube_r10", ModelPartBuilder.create().uv(36, 29).cuboid(-1.0F, 0.5604F, 0.8558F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -8.0F, 0.0F, -1.5708F, 1.2654F));

		ModelPartData cube_r11 = right_spike.addChild("cube_r11", ModelPartBuilder.create().uv(66, 56).cuboid(-1.0F, -1.2066F, -1.6088F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -8.0F, 0.0F, -1.5708F, 0.6545F));

		ModelPartData cube_r12 = right_spike.addChild("cube_r12", ModelPartBuilder.create().uv(66, 62).cuboid(-1.0F, -1.0326F, -3.6578F, 2.0F, 2.0F, 4.0F, new Dilation(-0.001F)), ModelTransform.of(0.0F, 0.0F, -8.0F, 0.0F, -1.5708F, 0.4363F));

		ModelPartData left_arm = main.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(6.0F, -22.0F, -4.0F));

		ModelPartData left_forearm = left_arm.addChild("left_forearm", ModelPartBuilder.create().uv(52, 32).cuboid(-3.0F, 8.9526F, -4.5671F, 5.0F, 2.0F, 6.0F, new Dilation(-0.01F)), ModelTransform.pivot(3.0F, 11.0F, -1.0F));

		ModelPartData cube_r13 = left_forearm.addChild("cube_r13", ModelPartBuilder.create().uv(48, 0).cuboid(-3.0F, -0.0474F, -2.5671F, 5.0F, 10.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		ModelPartData left_elbow = left_forearm.addChild("left_elbow", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -3.0F, 8.0F));

		ModelPartData cube_r14 = left_elbow.addChild("cube_r14", ModelPartBuilder.create().uv(22, 61).cuboid(-2.0F, -3.0436F, -2.0009F, 3.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, -8.0F, -0.1309F, 0.0F, 0.0F));

		ModelPartData left_spike_in_hand = left_forearm.addChild("left_spike_in_hand", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 9.0F, 2.0F));

		ModelPartData left_upper_arm = left_arm.addChild("left_upper_arm", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r15 = left_upper_arm.addChild("cube_r15", ModelPartBuilder.create().uv(74, 29).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -3.0F, 1.0F, -0.829F, 0.0F, 0.0F));

		ModelPartData cube_r16 = left_upper_arm.addChild("cube_r16", ModelPartBuilder.create().uv(4, 73).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -2.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData cube_r17 = left_upper_arm.addChild("cube_r17", ModelPartBuilder.create().uv(0, 73).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -4.0F, 2.0F, -1.0472F, 0.0F, 0.0F));

		ModelPartData cube_r18 = left_upper_arm.addChild("cube_r18", ModelPartBuilder.create().uv(48, 71).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -4.0F, 1.0F, -1.0472F, 0.0F, 0.0F));

		ModelPartData cube_r19 = left_upper_arm.addChild("cube_r19", ModelPartBuilder.create().uv(74, 26).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -3.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		ModelPartData cube_r20 = left_upper_arm.addChild("cube_r20", ModelPartBuilder.create().uv(44, 71).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -2.0F, -1.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData cube_r21 = left_upper_arm.addChild("cube_r21", ModelPartBuilder.create().uv(30, 34).cuboid(0.0F, -2.0F, -3.0F, 5.0F, 11.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, -0.0436F, 0.0F, 0.0F));

		ModelPartData left_spike = left_upper_arm.addChild("left_spike", ModelPartBuilder.create(), ModelTransform.pivot(6.0F, 5.0F, 8.0F));

		ModelPartData cube_r22 = left_spike.addChild("cube_r22", ModelPartBuilder.create().uv(12, 65).cuboid(0.0F, 1.5142F, 1.1565F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -8.0F, 0.0F, 1.5708F, -1.2654F));

		ModelPartData cube_r23 = left_spike.addChild("cube_r23", ModelPartBuilder.create().uv(40, 74).cuboid(-1.0F, -0.61F, -2.7515F, 2.0F, 2.0F, 4.0F, new Dilation(-0.001F)), ModelTransform.of(0.0F, 0.0F, -8.0F, 0.0F, 1.5708F, -0.4363F));

		ModelPartData cube_r24 = left_spike.addChild("cube_r24", ModelPartBuilder.create().uv(70, 0).cuboid(-1.0F, -0.5979F, -0.8154F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -8.0F, 0.0F, 1.5708F, -0.6545F));

		ModelPartData torso = main.addChild("torso", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -17.0F, 3.0F));

		ModelPartData cube_r25 = torso.addChild("cube_r25", ModelPartBuilder.create().uv(74, 23).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -4.0F, 1.0F, -0.829F, 0.0F, 0.0F));

		ModelPartData cube_r26 = torso.addChild("cube_r26", ModelPartBuilder.create().uv(36, 71).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -3.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData cube_r27 = torso.addChild("cube_r27", ModelPartBuilder.create().uv(40, 71).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -5.0F, 2.0F, -1.0472F, 0.0F, 0.0F));

		ModelPartData cube_r28 = torso.addChild("cube_r28", ModelPartBuilder.create().uv(74, 20).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -4.0F, 2.0F, -0.829F, 0.0F, 0.0F));

		ModelPartData cube_r29 = torso.addChild("cube_r29", ModelPartBuilder.create().uv(28, 71).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -3.0F, 1.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData cube_r30 = torso.addChild("cube_r30", ModelPartBuilder.create().uv(32, 71).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -5.0F, 3.0F, -1.0472F, 0.0F, 0.0F));

		ModelPartData cube_r31 = torso.addChild("cube_r31", ModelPartBuilder.create().uv(74, 17).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.0F, 1.0F, -0.829F, 0.0F, 0.0F));

		ModelPartData cube_r32 = torso.addChild("cube_r32", ModelPartBuilder.create().uv(20, 71).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData cube_r33 = torso.addChild("cube_r33", ModelPartBuilder.create().uv(24, 71).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.0F, 2.0F, -1.0472F, 0.0F, 0.0F));

		ModelPartData cube_r34 = torso.addChild("cube_r34", ModelPartBuilder.create().uv(16, 74).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -6.0F, -2.0F, -0.829F, 0.0F, 0.0F));

		ModelPartData cube_r35 = torso.addChild("cube_r35", ModelPartBuilder.create().uv(58, 70).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -5.0F, -3.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData cube_r36 = torso.addChild("cube_r36", ModelPartBuilder.create().uv(62, 70).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -7.0F, -1.0F, -1.0472F, 0.0F, 0.0F));

		ModelPartData cube_r37 = torso.addChild("cube_r37", ModelPartBuilder.create().uv(74, 14).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -6.0F, -3.0F, -0.829F, 0.0F, 0.0F));

		ModelPartData cube_r38 = torso.addChild("cube_r38", ModelPartBuilder.create().uv(70, 26).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -5.0F, -4.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData cube_r39 = torso.addChild("cube_r39", ModelPartBuilder.create().uv(54, 70).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -7.0F, -2.0F, -1.0472F, 0.0F, 0.0F));

		ModelPartData cube_r40 = torso.addChild("cube_r40", ModelPartBuilder.create().uv(56, 48).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(22, 48).cuboid(9.0F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, -9.0F, -5.0F, -0.829F, 0.0F, 0.0F));

		ModelPartData cube_r41 = torso.addChild("cube_r41", ModelPartBuilder.create().uv(70, 18).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(62, 56).cuboid(9.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, -8.0F, -6.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData cube_r42 = torso.addChild("cube_r42", ModelPartBuilder.create().uv(70, 22).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(70, 6).cuboid(9.0F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, -10.0F, -4.0F, -1.0472F, 0.0F, 0.0F));

		ModelPartData cube_r43 = torso.addChild("cube_r43", ModelPartBuilder.create().uv(52, 48).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(26, 48).cuboid(3.0F, -1.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -9.0F, -4.0F, -0.829F, 0.0F, 0.0F));

		ModelPartData cube_r44 = torso.addChild("cube_r44", ModelPartBuilder.create().uv(70, 14).cuboid(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(70, 10).cuboid(3.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -8.0F, -5.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData cube_r45 = torso.addChild("cube_r45", ModelPartBuilder.create().uv(16, 70).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(12, 70).cuboid(3.0F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -10.0F, -3.0F, -1.0472F, 0.0F, 0.0F));

		ModelPartData cube_r46 = torso.addChild("cube_r46", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -3.7321F, -6.6602F, 12.0F, 8.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, -4.0F, -0.5672F, 0.0F, 0.0F));

		ModelPartData waist = main.addChild("waist", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -17.0F, 2.0F));

		ModelPartData cube_r47 = waist.addChild("cube_r47", ModelPartBuilder.create().uv(0, 20).cuboid(-5.0F, -3.0981F, -4.0263F, 10.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, 4.0F, -0.3927F, 0.0F, 0.0F));

		ModelPartData right_leg = main.addChild("right_leg", ModelPartBuilder.create().uv(22, 51).cuboid(-2.0F, 9.0F, -3.0F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -14.0F, 7.0F));

		ModelPartData cube_r48 = right_leg.addChild("cube_r48", ModelPartBuilder.create().uv(54, 61).cuboid(0.0F, -6.0F, -3.0F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 5.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		ModelPartData cube_r49 = right_leg.addChild("cube_r49", ModelPartBuilder.create().uv(0, 65).cuboid(0.0F, -5.0F, -3.0F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 9.0F, 1.0F, 0.1309F, 0.0F, 0.0F));

		ModelPartData left_leg = main.addChild("left_leg", ModelPartBuilder.create().uv(42, 51).cuboid(-3.0F, 9.0F, -3.0F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -14.0F, 7.0F));

		ModelPartData cube_r50 = left_leg.addChild("cube_r50", ModelPartBuilder.create().uv(36, 20).cuboid(0.0F, -6.0F, -3.0F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 5.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		ModelPartData cube_r51 = left_leg.addChild("cube_r51", ModelPartBuilder.create().uv(62, 48).cuboid(0.0F, -5.0F, -3.0F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 9.0F, 1.0F, 0.1309F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(TwistedTreantEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(entity, netHeadYaw, headPitch, headYaw);

		this.animateMovement(TwistedTreantAnimations.walking_animation, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.standingAnimationState, TwistedTreantAnimations.stand_up_animation, ageInTicks, 1f);
		this.updateAnimation(entity.idleAnimationState, TwistedTreantAnimations.idle_animation, ageInTicks, 1f);
		this.updateAnimation(entity.attack1AnimationState, TwistedTreantAnimations.attack_animation_1, ageInTicks, 1f);
		this.updateAnimation(entity.attack2AnimationState, TwistedTreantAnimations.attack_animation_2, ageInTicks, 1f);
	}

	private void setHeadAngles(TwistedTreantEntity entity, float headYaw, float headPitch, float animationProgress) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
		setHeadYaw(headYaw);
		setHeadPitch(headPitch);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		twisted_treant.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return twisted_treant;
	}

	public float getHeadPitch() {
		return this.headPitch;
	}

	public float getHeadYaw() {
		return this.headYaw;
	}

	public void setHeadPitch(float headPitch) {
		this.headPitch = headPitch;
	}

	public void setHeadYaw(float headYaw) {
		this.headYaw = headYaw;
	}
}