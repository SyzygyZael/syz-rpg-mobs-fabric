package net.syzygy.rpgmobs.entity.client.CrystillineMagmiteComponents;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.syzygy.rpgmobs.entity.custom.CrystallineMagmiteEntity;

// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class CrystallineMagmiteModel extends EntityModel<CrystallineMagmiteRenderState> {
	private final ModelPart crystalline_magmite;
	private final ModelPart head;
	private final ModelPart torso;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart waist;

	private final Animation idleAnimation;
    private final Animation walkingAnimation;
    private final Animation attack1Animation;
    private final Animation attack2Animation;

	public CrystallineMagmiteModel(ModelPart root) {
        super(root);
		this.crystalline_magmite = root.getChild("crystalline_magmite");
		this.head = this.crystalline_magmite.getChild("head");
		this.torso = this.crystalline_magmite.getChild("torso");
		this.left_arm = this.crystalline_magmite.getChild("left_arm");
		this.right_arm = this.crystalline_magmite.getChild("right_arm");
		this.left_leg = this.crystalline_magmite.getChild("left_leg");
		this.right_leg = this.crystalline_magmite.getChild("right_leg");
		this.waist = this.crystalline_magmite.getChild("waist");

        this.idleAnimation = CrystallineMagmiteAnimations.crystilline_magmite_idle.createAnimation(root);
        this.walkingAnimation = CrystallineMagmiteAnimations.crystilline_magmite_walk.createAnimation(root);
        this.attack1Animation = CrystallineMagmiteAnimations.crystilline_magmite_attack1.createAnimation(root);
        this.attack2Animation = CrystallineMagmiteAnimations.crystilline_magmite_attack2.createAnimation(root);
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData crystalline_magmite = modelPartData.addChild("crystalline_magmite", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 24.0F, 0.0F));

		ModelPartData head = crystalline_magmite.addChild("head", ModelPartBuilder.create().uv(64, 45).cuboid(-4.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, -45.0F, 0.0F));

		ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(50, 14).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, -6.0F, 0.0F, -3.1416F, 0.0F, -2.1817F));

		ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(60, 12).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -5.0F, 0.0F, 3.1416F, 0.0F, -2.618F));

		ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(50, 12).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -6.0F, 0.0F, 0.0F, 0.0F, -0.9599F));

		ModelPartData cube_r4 = head.addChild("cube_r4", ModelPartBuilder.create().uv(56, 14).cuboid(-0.5774F, -0.0937F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -7.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		ModelPartData cube_r5 = head.addChild("cube_r5", ModelPartBuilder.create().uv(56, 12).cuboid(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -5.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		ModelPartData torso = crystalline_magmite.addChild("torso", ModelPartBuilder.create().uv(0, 82).cuboid(-4.0F, -6.0F, -2.0F, 7.0F, 2.0F, 6.0F, new Dilation(0.0F))
				.uv(50, 0).cuboid(-6.0F, -11.0F, -3.0F, 11.0F, 5.0F, 7.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-9.0F, -19.0F, -4.0F, 17.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, -26.0F, 0.0F));

		ModelPartData left_arm = crystalline_magmite.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.rotation(-1.0F, -42.0F, 0.0F));

		ModelPartData cube_r6 = left_arm.addChild("cube_r6", ModelPartBuilder.create().uv(88, 45).cuboid(-6.0F, 5.0F, -3.0F, 6.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(15.0F, -11.0F, -4.0F, 0.3927F, 0.0F, -0.1309F));

		ModelPartData cube_r7 = left_arm.addChild("cube_r7", ModelPartBuilder.create().uv(32, 50).cuboid(-1.0F, -3.0F, -4.0F, 8.0F, 11.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(10.0F, -1.0F, 0.0F, 0.3927F, 0.0F, -0.1309F));

		ModelPartData cube_r8 = left_arm.addChild("cube_r8", ModelPartBuilder.create().uv(32, 16).cuboid(-7.0F, -3.0F, -4.0F, 8.0F, 26.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(18.0F, 14.0F, 2.0F, -0.48F, 0.0F, -0.1309F));

		ModelPartData right_arm = crystalline_magmite.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.rotation(-1.0F, -41.0F, -2.0F));

		ModelPartData cube_r9 = right_arm.addChild("cube_r9", ModelPartBuilder.create().uv(0, 16).cuboid(-7.0F, -3.0F, -4.0F, 8.0F, 26.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-11.0F, 11.8529F, 2.6383F, -0.48F, 0.0227F, 0.1289F));

		ModelPartData cube_r10 = right_arm.addChild("cube_r10", ModelPartBuilder.create().uv(86, 0).cuboid(-6.0F, 5.0F, -3.0F, 6.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -13.1472F, -2.3617F, 0.3927F, 0.0F, 0.1309F));

		ModelPartData cube_r11 = right_arm.addChild("cube_r11", ModelPartBuilder.create().uv(0, 50).cuboid(-7.0F, -3.0F, -4.0F, 8.0F, 11.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-9.0F, -3.1472F, 1.6383F, 0.3927F, 0.0F, 0.1309F));

		ModelPartData left_leg = crystalline_magmite.addChild("left_leg", ModelPartBuilder.create().uv(64, 12).cuboid(-5.8871F, 21.0F, -8.2902F, 8.0F, 3.0F, 9.0F, new Dilation(0.0F))
				.uv(64, 57).cuboid(-4.8871F, 16.0F, -6.2902F, 6.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, -24.0F, 1.0F, 0.0F, 0.1745F, 0.0F));

		ModelPartData cube_r12 = left_leg.addChild("cube_r12", ModelPartBuilder.create().uv(44, 69).cuboid(-1.0F, -4.0F, -5.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-2.8871F, 7.0F, 1.7098F, -0.2618F, 0.0F, 0.0F));

		ModelPartData cube_r13 = left_leg.addChild("cube_r13", ModelPartBuilder.create().uv(64, 68).cuboid(-2.0F, -5.0F, -6.0F, 6.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-2.8871F, 14.0F, -0.2902F, -0.2618F, 0.0F, 0.0F));

		ModelPartData right_leg = crystalline_magmite.addChild("right_leg", ModelPartBuilder.create().uv(68, 79).cuboid(-1.1716F, 15.0F, -7.899F, 6.0F, 5.0F, 6.0F, new Dilation(0.0F))
				.uv(64, 24).cuboid(-2.1716F, 20.0F, -9.899F, 8.0F, 3.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -23.0F, 1.0F, 0.0F, -0.2618F, 0.0F));

		ModelPartData cube_r14 = right_leg.addChild("cube_r14", ModelPartBuilder.create().uv(26, 82).cuboid(-1.0F, -4.0F, -5.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.8284F, 6.0F, 0.101F, -0.2618F, 0.0F, 0.0F));

		ModelPartData cube_r15 = right_leg.addChild("cube_r15", ModelPartBuilder.create().uv(44, 79).cuboid(-2.0F, -5.0F, -6.0F, 6.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.8284F, 13.0F, -1.899F, -0.2618F, 0.0F, 0.0F));

		ModelPartData waist = crystalline_magmite.addChild("waist", ModelPartBuilder.create().uv(64, 36).cuboid(-4.0F, -3.0F, -2.0F, 9.0F, 4.0F, 5.0F, new Dilation(0.0F))
				.uv(88, 64).cuboid(-3.0F, 1.0F, -2.0F, 7.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.rotation(-1.0F, -23.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}

    @Override
    public void setAngles(CrystallineMagmiteRenderState state) {
        super.setAngles(state);
        this.setHeadAngles(state.relativeHeadYaw, state.pitch);

        this.idleAnimation.apply(state.idleAnimationState, state.age, 1f);
        this.walkingAnimation.applyWalking(state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f);
        this.attack1Animation.apply(state.attack1AnimationState, state.age, 1f);
        this.attack2Animation.apply(state.attack2AnimationState, state.age, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
	}
}