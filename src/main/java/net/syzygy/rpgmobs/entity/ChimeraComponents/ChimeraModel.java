package net.syzygy.rpgmobs.entity.ChimeraComponents;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 5.0.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class ChimeraModel<T extends ChimeraEntity> extends SinglePartEntityModel<T> {
	private final ModelPart chimera;
	private final ModelPart main;
	private final ModelPart left_leg;
	private final ModelPart left_knee;
	private final ModelPart left_above_knee;
	private final ModelPart right_leg;
	private final ModelPart right_knee;
	private final ModelPart right_above_knee;
	private final ModelPart waist;
	private final ModelPart torso;
	private final ModelPart left_wing;
	private final ModelPart right_wing;
	private final ModelPart left_arm;
	private final ModelPart left_wrist;
	private final ModelPart right_arm;
	private final ModelPart right_wrist;
	private final ModelPart head;
	private final ModelPart lower_jaw;
	private final ModelPart upper_jaw;
	private final ModelPart upper_jaw2;
	private final ModelPart air;

    public float headPitch;
    public float headYaw;

	public ChimeraModel(ModelPart root) {
		this.chimera = root.getChild("chimera");
		this.main = this.chimera.getChild("main");
		this.left_leg = this.main.getChild("left_leg");
		this.left_knee = this.left_leg.getChild("left_knee");
		this.left_above_knee = this.left_leg.getChild("left_above_knee");
		this.right_leg = this.main.getChild("right_leg");
		this.right_knee = this.right_leg.getChild("right_knee");
		this.right_above_knee = this.right_leg.getChild("right_above_knee");
		this.waist = this.main.getChild("waist");
		this.torso = this.main.getChild("torso");
		this.left_wing = this.torso.getChild("left_wing");
		this.right_wing = this.torso.getChild("right_wing");
		this.left_arm = this.main.getChild("left_arm");
		this.left_wrist = this.left_arm.getChild("left_wrist");
		this.right_arm = this.main.getChild("right_arm");
		this.right_wrist = this.right_arm.getChild("right_wrist");
		this.head = this.main.getChild("head");
		this.lower_jaw = this.head.getChild("lower_jaw");
		this.upper_jaw = this.head.getChild("upper_jaw");
		this.upper_jaw2 = this.head.getChild("upper_jaw2");
		this.air = this.chimera.getChild("air");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData chimera = modelPartData.addChild("chimera", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData main = chimera.addChild("main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData left_leg = main.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, -19.0F, 1.0F));

		ModelPartData left_knee = left_leg.addChild("left_knee", ModelPartBuilder.create().uv(26, 83).cuboid(-4.0F, 7.0F, -6.0F, 8.0F, 2.0F, 9.0F, new Dilation(0.0F))
		.uv(0, 103).cuboid(-2.0F, 5.0F, -5.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(110, 90).cuboid(2.0F, 5.0F, -5.0F, 1.0F, 2.0F, 7.0F, new Dilation(0.0F))
		.uv(110, 81).cuboid(-3.0F, 5.0F, -5.0F, 1.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 10.0F, 1.0F));

		ModelPartData cube_r1 = left_knee.addChild("cube_r1", ModelPartBuilder.create().uv(112, 40).cuboid(-3.0F, -2.0F, -3.0F, 6.0F, 2.0F, 3.0F, new Dilation(-0.001F)), ModelTransform.of(0.0F, -2.0F, 1.0F, -0.3054F, 0.0F, 0.0F));

		ModelPartData cube_r2 = left_knee.addChild("cube_r2", ModelPartBuilder.create().uv(110, 60).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 3.0F, 4.0F, new Dilation(-0.001F)), ModelTransform.of(0.0F, 1.0F, 1.0F, -0.3054F, 0.0F, 0.0F));

		ModelPartData cube_r3 = left_knee.addChild("cube_r3", ModelPartBuilder.create().uv(28, 107).cuboid(-2.0F, -8.0F, -2.0F, 4.0F, 8.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 7.0F, -3.0F, -0.3054F, 0.0F, 0.0F));

		ModelPartData left_above_knee = left_leg.addChild("left_above_knee", ModelPartBuilder.create().uv(56, 104).cuboid(0.0F, 3.0F, -2.0F, 6.0F, 7.0F, 5.0F, new Dilation(0.0F))
		.uv(12, 103).cuboid(1.0F, 10.0F, 0.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.3F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		ModelPartData cube_r4 = left_above_knee.addChild("cube_r4", ModelPartBuilder.create().uv(26, 77).cuboid(-1.0F, 1.0F, -3.0F, 4.0F, 1.0F, 5.0F, new Dilation(0.0F))
		.uv(110, 73).cuboid(0.0F, -1.0F, -3.0F, 3.0F, 2.0F, 6.0F, new Dilation(0.0F))
		.uv(110, 67).cuboid(-2.0F, 2.0F, -3.0F, 5.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData right_leg = main.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot(-4.0F, -19.0F, 1.0F));

		ModelPartData right_knee = right_leg.addChild("right_knee", ModelPartBuilder.create().uv(26, 83).cuboid(-4.0F, 7.0F, -6.0F, 8.0F, 2.0F, 9.0F, new Dilation(0.0F))
		.uv(0, 103).cuboid(-2.0F, 5.0F, -5.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(110, 90).cuboid(-3.0F, 5.0F, -5.0F, 1.0F, 2.0F, 7.0F, new Dilation(0.0F))
		.uv(112, 31).cuboid(2.0F, 5.0F, -5.0F, 1.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 10.0F, 1.0F));

		ModelPartData cube_r5 = right_knee.addChild("cube_r5", ModelPartBuilder.create().uv(112, 40).cuboid(-3.0F, -2.0F, -3.0F, 6.0F, 2.0F, 3.0F, new Dilation(-0.001F)), ModelTransform.of(0.0F, -2.0F, 1.0F, -0.3054F, 0.0F, 0.0F));

		ModelPartData cube_r6 = right_knee.addChild("cube_r6", ModelPartBuilder.create().uv(110, 60).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 3.0F, 4.0F, new Dilation(-0.001F)), ModelTransform.of(0.0F, 1.0F, 1.0F, -0.3054F, 0.0F, 0.0F));

		ModelPartData cube_r7 = right_knee.addChild("cube_r7", ModelPartBuilder.create().uv(28, 107).cuboid(-2.0F, -8.0F, -2.0F, 4.0F, 8.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 7.0F, -3.0F, -0.3054F, 0.0F, 0.0F));

		ModelPartData right_above_knee = right_leg.addChild("right_above_knee", ModelPartBuilder.create().uv(56, 104).cuboid(-6.0F, 3.0F, -2.0F, 6.0F, 7.0F, 5.0F, new Dilation(0.0F))
		.uv(12, 103).cuboid(-5.0F, 10.0F, 0.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.3F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		ModelPartData cube_r8 = right_above_knee.addChild("cube_r8", ModelPartBuilder.create().uv(26, 77).cuboid(-3.0F, 1.0F, -3.0F, 4.0F, 1.0F, 5.0F, new Dilation(0.0F))
		.uv(110, 73).cuboid(-3.0F, -1.0F, -3.0F, 3.0F, 2.0F, 6.0F, new Dilation(0.0F))
		.uv(110, 67).cuboid(-3.0F, 2.0F, -3.0F, 5.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 0.0F, 0.0F, 0.0F, -3.1416F, 0.0F));

		ModelPartData waist = main.addChild("waist", ModelPartBuilder.create().uv(0, 107).cuboid(-4.0F, 0.0F, -3.0F, 8.0F, 2.0F, 6.0F, new Dilation(-0.001F))
		.uv(78, 109).cuboid(-4.0F, 0.0F, -3.0F, 8.0F, 13.0F, 0.0F, new Dilation(0.0F))
		.uv(78, 113).cuboid(-4.0F, 0.0F, 3.0F, 8.0F, 9.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -20.0F, 1.0F));

		ModelPartData cube_r9 = waist.addChild("cube_r9", ModelPartBuilder.create().uv(36, 120).cuboid(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 3.0F, new Dilation(0.25F)), ModelTransform.of(0.0F, 6.0F, 21.0F, 0.2618F, 0.0F, 0.0F));

		ModelPartData cube_r10 = waist.addChild("cube_r10", ModelPartBuilder.create().uv(112, 52).cuboid(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 5.0F, new Dilation(-0.003F)), ModelTransform.of(0.0F, 7.0F, 17.0F, 0.2618F, 0.0F, 0.0F));

		ModelPartData cube_r11 = waist.addChild("cube_r11", ModelPartBuilder.create().uv(112, 45).cuboid(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 5.0F, new Dilation(-0.002F)), ModelTransform.of(0.0F, 8.0F, 12.0F, -0.1745F, 0.0F, 0.0F));

		ModelPartData cube_r12 = waist.addChild("cube_r12", ModelPartBuilder.create().uv(46, 107).cuboid(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 3.0F, new Dilation(-0.002F)), ModelTransform.of(0.0F, 7.0F, 8.0F, -0.5236F, 0.0F, 0.0F));

		ModelPartData cube_r13 = waist.addChild("cube_r13", ModelPartBuilder.create().uv(94, 109).cuboid(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 7.0F, new Dilation(-0.001F)), ModelTransform.of(0.0F, 4.0F, 4.0F, -0.6981F, 0.0F, 0.0F));

		ModelPartData torso = main.addChild("torso", ModelPartBuilder.create().uv(0, 63).cuboid(-7.0F, -6.0F, -4.0F, 14.0F, 6.0F, 8.0F, new Dilation(0.0F))
		.uv(48, 17).cuboid(-9.0F, -12.0F, -5.0F, 18.0F, 6.0F, 9.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-11.0F, -19.0F, -6.0F, 22.0F, 7.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -20.0F, 1.0F, 0.3054F, 0.0F, 0.0F));

		ModelPartData left_wing = torso.addChild("left_wing", ModelPartBuilder.create(), ModelTransform.of(3.0F, -12.4965F, 4.7686F, -0.3549F, -0.2947F, -0.2739F));

		ModelPartData cube_r14 = left_wing.addChild("cube_r14", ModelPartBuilder.create().uv(51, 206).mirrored().cuboid(-1.0F, -23.0F, 0.0F, 9.0F, 50.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
		.uv(74, 60).cuboid(-3.0F, -4.0F, -1.0F, 2.0F, 5.0F, 1.0F, new Dilation(-0.001F)), ModelTransform.of(2.0F, 1.0F, 1.0F, 0.3054F, 0.0F, 0.0F));

		ModelPartData cube_r15 = left_wing.addChild("cube_r15", ModelPartBuilder.create().uv(0, 137).mirrored().cuboid(0.0F, -26.0F, 0.0F, 13.0F, 56.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(10.0F, 1.0F, 1.0F, 0.3193F, 0.2909F, 0.0945F));

		ModelPartData cube_r16 = left_wing.addChild("cube_r16", ModelPartBuilder.create().uv(204, 93).mirrored().cuboid(0.0F, -28.0F, 0.0F, 22.0F, 61.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(22.0F, 1.0F, -3.0F, 0.4194F, 0.7401F, 0.2921F));

		ModelPartData right_wing = torso.addChild("right_wing", ModelPartBuilder.create(), ModelTransform.of(-3.0F, -12.4965F, 4.7686F, -0.3549F, 0.2947F, 0.2739F));

		ModelPartData cube_r17 = right_wing.addChild("cube_r17", ModelPartBuilder.create().uv(204, 93).cuboid(-22.0F, -28.0F, 0.0F, 22.0F, 61.0F, 0.0F, new Dilation(0.0F))
		.uv(205, 162).cuboid(-22.0F, -28.0F, 0.0F, 22.0F, 61.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-22.0F, 1.0F, -3.0F, 0.4194F, -0.7401F, -0.2921F));

		ModelPartData cube_r18 = right_wing.addChild("cube_r18", ModelPartBuilder.create().uv(202, 8).cuboid(-13.0F, -26.0F, 0.0F, 13.0F, 56.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-10.0F, 1.0F, 1.0F, 0.3193F, -0.2909F, -0.0945F));

		ModelPartData cube_r19 = right_wing.addChild("cube_r19", ModelPartBuilder.create().uv(129, 181).cuboid(-8.0F, -23.0F, 0.0F, 9.0F, 50.0F, 0.0F, new Dilation(0.0F))
		.uv(74, 60).cuboid(1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 1.0F, new Dilation(-0.001F)), ModelTransform.of(-2.0F, 1.0F, 1.0F, 0.3054F, 0.0F, 0.0F));

		ModelPartData left_arm = main.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(11.0F, -36.0F, -5.0F));

		ModelPartData cube_r20 = left_arm.addChild("cube_r20", ModelPartBuilder.create().uv(44, 66).mirrored().cuboid(3.0F, -7.0F, -6.0F, 8.0F, 7.0F, 10.0F, new Dilation(0.0F)).mirrored(false)
		.uv(80, 80).mirrored().cuboid(4.0F, 0.0F, -5.0F, 7.0F, 12.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(11.0F, 4.0F, -1.0F, 0.0F, -3.1416F, 0.0F));

		ModelPartData left_wrist = left_arm.addChild("left_wrist", ModelPartBuilder.create().uv(26, 94).cuboid(-4.0F, 4.0F, -4.0F, 7.0F, 5.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, 16.0F, 0.0F));

		ModelPartData cube_r21 = left_wrist.addChild("cube_r21", ModelPartBuilder.create().uv(74, 46).mirrored().cuboid(3.0F, -4.0F, -6.0F, 9.0F, 4.0F, 10.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(7.0F, 4.0F, -1.0F, 0.0F, -3.1416F, 0.0F));

		ModelPartData right_arm = main.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(-11.0F, -36.0F, -5.0F));

		ModelPartData cube_r22 = right_arm.addChild("cube_r22", ModelPartBuilder.create().uv(80, 80).cuboid(-3.0F, -7.0F, -4.0F, 7.0F, 12.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 11.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData cube_r23 = right_arm.addChild("cube_r23", ModelPartBuilder.create().uv(44, 66).cuboid(-4.0F, -4.0F, -5.0F, 8.0F, 7.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 1.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData right_wrist = right_arm.addChild("right_wrist", ModelPartBuilder.create().uv(74, 46).cuboid(-4.0F, 0.0F, -5.0F, 9.0F, 4.0F, 10.0F, new Dilation(0.0F))
		.uv(26, 94).mirrored().cuboid(-3.0F, 4.0F, -4.0F, 7.0F, 5.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-4.0F, 16.0F, 0.0F));

		ModelPartData head = main.addChild("head", ModelPartBuilder.create().uv(0, 40).cuboid(-6.0F, -9.0F, -6.0F, 12.0F, 11.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -38.0F, -6.0F));

		ModelPartData cube_r24 = head.addChild("cube_r24", ModelPartBuilder.create().uv(0, 5).cuboid(-2.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, 0.0F, -12.0F, -0.0436F, 0.0F, 0.0F));

		ModelPartData cube_r25 = head.addChild("cube_r25", ModelPartBuilder.create().uv(48, 117).mirrored().cuboid(-0.6844F, -2.2859F, -1.3444F, 2.0F, 3.0F, 2.0F, new Dilation(-0.45F)).mirrored(false), ModelTransform.of(-6.0F, -15.0F, -15.0F, 1.0788F, 0.1536F, -0.1555F));

		ModelPartData cube_r26 = head.addChild("cube_r26", ModelPartBuilder.create().uv(112, 109).cuboid(-2.0F, -3.0F, -1.0F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -8.0F, -6.0F, 1.0788F, -0.1536F, 0.1555F));

		ModelPartData cube_r27 = head.addChild("cube_r27", ModelPartBuilder.create().uv(58, 116).cuboid(-2.0F, -1.0F, -1.0F, 3.0F, 4.0F, 3.0F, new Dilation(-0.1F)), ModelTransform.of(5.0F, -11.0F, -10.0F, 0.7298F, -0.1536F, 0.1555F));

		ModelPartData cube_r28 = head.addChild("cube_r28", ModelPartBuilder.create().uv(94, 118).cuboid(-1.4828F, -0.3755F, -1.2992F, 3.0F, 3.0F, 3.0F, new Dilation(-0.25F)), ModelTransform.of(5.0F, -13.0F, -12.0F, 0.9519F, -0.1205F, 0.1268F));

		ModelPartData cube_r29 = head.addChild("cube_r29", ModelPartBuilder.create().uv(12, 115).cuboid(-1.6986F, -3.4884F, -1.8124F, 3.0F, 4.0F, 3.0F, new Dilation(-0.4F)), ModelTransform.of(5.0F, -13.0F, -11.0F, 1.0799F, -0.159F, 0.1476F));

		ModelPartData cube_r30 = head.addChild("cube_r30", ModelPartBuilder.create().uv(48, 117).cuboid(-1.3156F, -2.2859F, -1.3444F, 2.0F, 3.0F, 2.0F, new Dilation(-0.45F))
		.uv(48, 117).cuboid(-1.3156F, -2.2859F, -1.3444F, 2.0F, 3.0F, 2.0F, new Dilation(-0.45F)), ModelTransform.of(6.0F, -15.0F, -15.0F, 1.0788F, -0.1536F, 0.1555F));

		ModelPartData cube_r31 = head.addChild("cube_r31", ModelPartBuilder.create().uv(46, 116).cuboid(-1.2378F, -3.5312F, -1.8124F, 3.0F, 4.0F, 3.0F, new Dilation(-0.6F)), ModelTransform.of(5.0F, -14.0F, -13.0F, 1.0828F, -0.1205F, 0.1268F));

		ModelPartData cube_r32 = head.addChild("cube_r32", ModelPartBuilder.create().uv(46, 116).cuboid(-1.3014F, -3.4884F, -1.8124F, 3.0F, 4.0F, 3.0F, new Dilation(-0.4F))
		.uv(12, 115).cuboid(-1.3014F, -3.4884F, -1.8124F, 3.0F, 4.0F, 3.0F, new Dilation(-0.4F)), ModelTransform.of(-5.0F, -13.0F, -11.0F, 1.0799F, 0.159F, -0.1476F));

		ModelPartData cube_r33 = head.addChild("cube_r33", ModelPartBuilder.create().uv(0, 115).cuboid(-1.0F, -3.0F, -1.0F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -8.0F, -6.0F, 1.0788F, 0.1536F, -0.1555F));

		ModelPartData cube_r34 = head.addChild("cube_r34", ModelPartBuilder.create().uv(94, 118).cuboid(-1.7622F, -3.5312F, -1.8124F, 3.0F, 4.0F, 3.0F, new Dilation(-0.6F)), ModelTransform.of(-5.0F, -14.0F, -13.0F, 1.0828F, 0.1205F, -0.1268F));

		ModelPartData cube_r35 = head.addChild("cube_r35", ModelPartBuilder.create().uv(24, 120).cuboid(-1.5172F, -0.3755F, -1.2992F, 3.0F, 3.0F, 3.0F, new Dilation(-0.25F)), ModelTransform.of(-5.0F, -13.0F, -12.0F, 0.9519F, 0.1205F, -0.1268F));

		ModelPartData cube_r36 = head.addChild("cube_r36", ModelPartBuilder.create().uv(58, 116).cuboid(-1.0F, -1.0F, -1.0F, 3.0F, 4.0F, 3.0F, new Dilation(-0.1F)), ModelTransform.of(-5.0F, -11.0F, -10.0F, 0.7298F, 0.1536F, -0.1555F));

		ModelPartData lower_jaw = head.addChild("lower_jaw", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, -6.0F));

		ModelPartData cube_r37 = lower_jaw.addChild("cube_r37", ModelPartBuilder.create().uv(78, 100).cuboid(-4.0F, -3.0F, -6.0F, 8.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		ModelPartData upper_jaw = head.addChild("upper_jaw", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -4.0F, -6.0F));

		ModelPartData cube_r38 = upper_jaw.addChild("cube_r38", ModelPartBuilder.create().uv(0, 1).mirrored().cuboid(1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.001F)).mirrored(false)
		.uv(5, 5).cuboid(8.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.001F)), ModelTransform.of(-5.0F, 4.0F, -6.0F, -0.0436F, 0.0F, 0.0F));

		ModelPartData cube_r39 = upper_jaw.addChild("cube_r39", ModelPartBuilder.create().uv(102, 13).cuboid(-4.0F, 0.0F, -7.0F, 8.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 1.0F, -0.0436F, 0.0F, 0.0F));

		ModelPartData upper_jaw2 = head.addChild("upper_jaw2", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, -4.0F, -5.0F));

		ModelPartData air = chimera.addChild("air", ModelPartBuilder.create().uv(29, 146).cuboid(-8.0F, -2.0F, -1.0F, 16.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 256, 256);
	}

    @Override
    public void setAngles(ChimeraEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

        this.animateMovement(ChimeraAnimations.idle_animation, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ChimeraAnimations.idle_animation, ageInTicks, 1f);
        this.updateAnimation(entity.attack1AnimationState, ChimeraAnimations.attack1_animation, ageInTicks, 1f);
        this.updateAnimation(entity.attack2AnimationState, ChimeraAnimations.attack2_animation, ageInTicks, 1f);
        this.updateAnimation(entity.flyingAnimationState, ChimeraAnimations.flying_animation, ageInTicks, 1f);
        this.updateAnimation(entity.fireBreathAnimationState, ChimeraAnimations.fire_breath_animation, ageInTicks, 1f);
        this.updateAnimation(entity.slamAnimationState, ChimeraAnimations.slam_animation, ageInTicks, 1f);
    }

    private void setHeadAngles(ChimeraEntity entity, float headYaw, float headPitch, float animationProgress){
        headYaw	= MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
        setHeadYaw(headYaw);
        setHeadPitch(headPitch);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        chimera.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return chimera;
    }

    public void setHeadYaw(float headYaw) {
        this.headYaw = headYaw;
    }

    public void setHeadPitch(float headPitch) {
        this.headPitch = headPitch;
    }
}