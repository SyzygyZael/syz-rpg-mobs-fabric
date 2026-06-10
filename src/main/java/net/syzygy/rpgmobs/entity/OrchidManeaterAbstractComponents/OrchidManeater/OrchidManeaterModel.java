// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.syzygy.rpgmobs.entity.OrchidManeaterAbstractComponents.OrchidManeater;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.syzygy.rpgmobs.entity.ArchangelComponents.ArchangelAnimations;

public class OrchidManeaterModel extends EntityModel<OrchidManeaterRenderState> {
    private final ModelPart orchid_maneater;
    private final ModelPart stem;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart top_half;
    private final ModelPart top_teeth;
    private final ModelPart leaves;
    private final ModelPart bottom_half;
    private final ModelPart bottom_teeth;
    private final ModelPart left_leaf;
    private final ModelPart right_leaf;
    private final ModelPart leg_1;
    private final ModelPart leg1;
    private final ModelPart leg_2;
    private final ModelPart leg2;
    private final ModelPart leg_3;
    private final ModelPart leg3;
    private final ModelPart leg_4;
    private final ModelPart leg4;

    private final Animation idleAnimation;
    private final Animation walkingAnimation;
    private final Animation attack1Animation;

    public float headYaw;
    public float headPitch;

    public OrchidManeaterModel (ModelPart root) {
        super(root);

        this.orchid_maneater = root.getChild("orchid_maneater");
        this.stem = this.orchid_maneater.getChild("stem");
        this.leg_1 = this.orchid_maneater.getChild("leg_1");
        this.leg1 = this.leg_1.getChild("leg1");
        this.leg_2 = this.orchid_maneater.getChild("leg_2");
        this.leg2 = this.leg_2.getChild("leg2");
        this.leg_3 = this.orchid_maneater.getChild("leg_3");
        this.leg3 = this.leg_3.getChild("leg3");
        this.leg_4 = this.orchid_maneater.getChild("leg_4");
        this.leg4 = this.leg_4.getChild("leg4");
        this.neck = this.stem.getChild("neck");
        this.left_leaf = this.stem.getChild("left_leaf");
        this.right_leaf = this.stem.getChild("right_leaf");
        this.head = this.neck.getChild("head");
        this.top_half = this.head.getChild("top_half");
        this.top_teeth = this.top_half.getChild("top_teeth");
        this.bottom_half = this.head.getChild("bottom_half");
        this.bottom_teeth = this.bottom_half.getChild("bottom_teeth");
        this.leaves = this.head.getChild("leaves");

        this.idleAnimation = OrchidManeaterAnimations.idle_animation.createAnimation(root);
        this.walkingAnimation = OrchidManeaterAnimations.walking_animation.createAnimation(root);
        this.attack1Animation = OrchidManeaterAnimations.attack_animation.createAnimation(root);
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData orchid_maneater = modelPartData.addChild("orchid_maneater", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData stem = orchid_maneater.addChild("stem", ModelPartBuilder.create().uv(48, 28).cuboid(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = stem.addChild("cube_r1", ModelPartBuilder.create().uv(8, 66).cuboid(-1.0F, -4.4024F, -0.7604F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -22.0F, 8.0F, -0.3927F, 0.0F, 0.0F));

        ModelPartData cube_r2 = stem.addChild("cube_r2", ModelPartBuilder.create().uv(0, 66).cuboid(-1.0F, -4.4024F, -0.7604F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -16.0F, 4.0F, -0.7418F, 0.0F, 0.0F));

        ModelPartData cube_r3 = stem.addChild("cube_r3", ModelPartBuilder.create().uv(58, 56).cuboid(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

        ModelPartData neck = stem.addChild("neck", ModelPartBuilder.create(), ModelTransform.of(0.0F, -25.0F, 10.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r4 = neck.addChild("cube_r4", ModelPartBuilder.create().uv(66, 47).cuboid(-1.0F, -4.4024F, -0.7604F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -8.0F, -7.0F, 1.2217F, 0.0F, 0.0F));

        ModelPartData cube_r5 = neck.addChild("cube_r5", ModelPartBuilder.create().uv(16, 66).cuboid(-1.0F, -4.4024F, -0.7604F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, -2.0F, 0.5236F, 0.0F, 0.0F));

        ModelPartData head = neck.addChild("head", ModelPartBuilder.create(), ModelTransform.of(0.0F, -6.0F, -10.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData top_half = head.addChild("top_half", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -4.9128F, -13.9962F, 10.0F, 5.0F, 14.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

        ModelPartData top_teeth = top_half.addChild("top_teeth", ModelPartBuilder.create().uv(1, 1).cuboid(5.0F, -3.0F, -14.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(5.0F, -3.0F, -12.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(5.0F, -3.0F, -10.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(5.0F, -3.0F, -8.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(5.0F, -3.0F, -6.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(5.0F, -3.0F, -4.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(5.0F, -3.0F, -2.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(-5.0F, -3.0F, -2.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(-5.0F, -3.0F, -4.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(-5.0F, -3.0F, -6.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(-5.0F, -3.0F, -8.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(-5.0F, -3.0F, -10.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(-5.0F, -3.0F, -12.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(-5.0F, -3.0F, -14.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r6 = top_teeth.addChild("cube_r6", ModelPartBuilder.create().uv(1, 1).cuboid(-1.0F, -2.0F, 0.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -1.0F, -13.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData cube_r7 = top_teeth.addChild("cube_r7", ModelPartBuilder.create().uv(1, 1).cuboid(-1.0F, -2.0F, 0.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -1.0F, -13.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData cube_r8 = top_teeth.addChild("cube_r8", ModelPartBuilder.create().uv(1, 1).cuboid(-1.0F, -2.0F, 0.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -1.0F, -13.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData cube_r9 = top_teeth.addChild("cube_r9", ModelPartBuilder.create().uv(1, 1).cuboid(-1.0F, -2.0F, 0.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -1.0F, -13.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData leaves = head.addChild("leaves", ModelPartBuilder.create(), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

        ModelPartData cube_r10 = leaves.addChild("cube_r10", ModelPartBuilder.create().uv(48, 0).cuboid(-15.2929F, -4.2929F, 1.0F, 15.0F, 9.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.3562F));

        ModelPartData cube_r11 = leaves.addChild("cube_r11", ModelPartBuilder.create().uv(48, 0).cuboid(-15.2929F, -4.2929F, 1.0F, 15.0F, 9.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        ModelPartData cube_r12 = leaves.addChild("cube_r12", ModelPartBuilder.create().uv(48, 0).cuboid(-15.2929F, -4.2929F, 1.0F, 15.0F, 9.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        ModelPartData cube_r13 = leaves.addChild("cube_r13", ModelPartBuilder.create().uv(48, 0).cuboid(-15.2929F, -4.2929F, 1.0F, 15.0F, 9.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.3562F));

        ModelPartData bottom_half = head.addChild("bottom_half", ModelPartBuilder.create().uv(0, 19).cuboid(-5.0F, -0.5577F, -13.9099F, 10.0F, 4.0F, 14.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.48F, 0.0F, 0.0F));

        ModelPartData bottom_teeth = bottom_half.addChild("bottom_teeth", ModelPartBuilder.create().uv(1, 1).cuboid(-5.0F, -6.0F, -13.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(-5.0F, -6.0F, -11.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(-5.0F, -6.0F, -9.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(-5.0F, -6.0F, -7.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(-5.0F, -6.0F, -5.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(-5.0F, -6.0F, -3.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(5.0F, -6.0F, -3.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(5.0F, -6.0F, -5.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(5.0F, -6.0F, -7.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(5.0F, -6.0F, -9.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(5.0F, -6.0F, -11.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(5.0F, -6.0F, -13.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.5845F, 0.3888F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r14 = bottom_teeth.addChild("cube_r14", ModelPartBuilder.create().uv(1, 1).cuboid(-1.0F, -2.0F, 0.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, -4.0F, -15.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData cube_r15 = bottom_teeth.addChild("cube_r15", ModelPartBuilder.create().uv(1, 1).cuboid(-1.0F, -2.0F, 0.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, -15.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData cube_r16 = bottom_teeth.addChild("cube_r16", ModelPartBuilder.create().uv(1, 1).cuboid(-1.0F, -2.0F, 0.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -4.0F, -15.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData cube_r17 = bottom_teeth.addChild("cube_r17", ModelPartBuilder.create().uv(1, 1).cuboid(-1.0F, -2.0F, 0.0F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -4.0F, -15.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData left_leaf = stem.addChild("left_leaf", ModelPartBuilder.create(), ModelTransform.of(0.0F, -15.0F, 7.0F, 0.1745F, 0.0F, 0.0F));

        ModelPartData cube_r18 = left_leaf.addChild("cube_r18", ModelPartBuilder.create().uv(0, 37).cuboid(1.2539F, -3.0272F, -3.7057F, 11.0F, 0.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 1.0F, -2.0F, 0.4068F, 0.1624F, -0.3591F));

        ModelPartData cube_r19 = left_leaf.addChild("cube_r19", ModelPartBuilder.create().uv(48, 18).cuboid(-1.0F, -3.2766F, -3.7057F, 3.0F, 0.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 1.0F, -2.0F, 0.4363F, 0.0F, 0.0F));

        ModelPartData right_leaf = stem.addChild("right_leaf", ModelPartBuilder.create(), ModelTransform.of(0.0F, -15.0F, 8.0F, 2.0944F, 0.0F, 3.1416F));

        ModelPartData cube_r20 = right_leaf.addChild("cube_r20", ModelPartBuilder.create().uv(42, 37).cuboid(1.2539F, -3.0272F, -8.2943F, 11.0F, 0.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -2.4214F, 4.3372F, 0.4068F, 0.1624F, -0.3591F));

        ModelPartData cube_r21 = right_leaf.addChild("cube_r21", ModelPartBuilder.create().uv(0, 56).cuboid(-1.0F, -3.2766F, -8.2943F, 3.0F, 0.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -2.4214F, 4.3372F, 0.4363F, 0.0F, 0.0F));

        ModelPartData leg_1 = orchid_maneater.addChild("leg_1", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData leg1 = leg_1.addChild("leg1", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.2618F));

        ModelPartData cube_r22 = leg1.addChild("cube_r22", ModelPartBuilder.create().uv(30, 56).cuboid(-0.8818F, -17.0598F, -0.388F, 1.0F, 20.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(9.0F, -17.0F, 9.0F, -2.2291F, 0.8638F, 0.2939F));

        ModelPartData cube_r23 = leg1.addChild("cube_r23", ModelPartBuilder.create().uv(56, 28).cuboid(-0.7274F, -4.4907F, -0.1295F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(6.0F, -17.0F, 5.0F, -0.7854F, 0.0902F, 0.7854F));

        ModelPartData cube_r24 = leg1.addChild("cube_r24", ModelPartBuilder.create().uv(42, 56).cuboid(0.0F, -16.0F, -1.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -4.0F, -1.0F, -0.4363F, 0.0F, 0.4363F));

        ModelPartData leg_2 = orchid_maneater.addChild("leg_2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData leg2 = leg_2.addChild("leg2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 2.0F, -0.2378F, -1.4824F, 0.0242F));

        ModelPartData cube_r25 = leg2.addChild("cube_r25", ModelPartBuilder.create().uv(34, 56).cuboid(-1.6345F, -14.0208F, -2.8775F, 1.0F, 20.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(8.1144F, -13.0F, 10.1293F, -2.2291F, 0.8638F, 0.2939F));

        ModelPartData cube_r26 = leg2.addChild("cube_r26", ModelPartBuilder.create().uv(60, 47).cuboid(-3.5443F, -6.3105F, -2.3097F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.1144F, -13.0F, 6.1293F, -0.7854F, 0.0902F, 0.7854F));

        ModelPartData cube_r27 = leg2.addChild("cube_r27", ModelPartBuilder.create().uv(46, 56).cuboid(-1.6905F, -19.2856F, -2.5321F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.8856F, 0.0F, 0.1293F, -0.4363F, 0.0F, 0.4363F));

        ModelPartData leg_3 = orchid_maneater.addChild("leg_3", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData leg3 = leg_3.addChild("leg3", ModelPartBuilder.create(), ModelTransform.of(-1.0F, 0.0F, 0.0F, 2.971F, -0.0948F, 3.0984F));

        ModelPartData cube_r28 = leg3.addChild("cube_r28", ModelPartBuilder.create().uv(50, 56).cuboid(-1.6905F, -19.2856F, -2.5321F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.4363F));

        ModelPartData cube_r29 = leg3.addChild("cube_r29", ModelPartBuilder.create().uv(64, 28).cuboid(-3.5443F, -6.3105F, -2.3097F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(6.0F, -13.0F, 6.0F, -0.7854F, 0.0902F, 0.7854F));

        ModelPartData cube_r30 = leg3.addChild("cube_r30", ModelPartBuilder.create().uv(38, 56).cuboid(-1.6345F, -14.0208F, -2.8776F, 1.0F, 20.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(9.0F, -13.0F, 10.0F, -2.2291F, 0.8638F, 0.2939F));

        ModelPartData leg_4 = orchid_maneater.addChild("leg_4", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData leg4 = leg_4.addChild("leg4", ModelPartBuilder.create(), ModelTransform.of(1.0F, 0.0F, 0.0F, 1.9636F, 1.3837F, 2.0213F));

        ModelPartData cube_r31 = leg4.addChild("cube_r31", ModelPartBuilder.create().uv(54, 56).cuboid(-1.6905F, -19.2856F, -2.5321F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.4363F));

        ModelPartData cube_r32 = leg4.addChild("cube_r32", ModelPartBuilder.create().uv(60, 28).cuboid(-3.5443F, -6.3105F, -2.3097F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(6.0F, -13.0F, 6.0F, -0.7854F, 0.0902F, 0.7854F));

        ModelPartData cube_r33 = leg4.addChild("cube_r33", ModelPartBuilder.create().uv(26, 56).cuboid(-1.6345F, -14.0208F, -2.8776F, 1.0F, 20.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(9.0F, -13.0F, 10.0F, -2.2291F, 0.8638F, 0.2939F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(OrchidManeaterRenderState state) {
        super.setAngles(state);
        this.setHeadAngles(state.headYaw, state.headPitch);

        this.idleAnimation.apply(state.idleAnimationState, state.age);
        this.walkingAnimation.apply(state.walkingAnimationState, state.age);
        this.attack1Animation.apply(state.attack1AnimationState, state.age);
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