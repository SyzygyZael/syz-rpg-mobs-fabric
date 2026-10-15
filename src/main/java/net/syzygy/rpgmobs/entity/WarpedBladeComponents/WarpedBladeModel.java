package net.syzygy.rpgmobs.entity.WarpedBladeComponents;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 5.2.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class WarpedBladeModel extends EntityModel<Entity> {
	private final ModelPart warped_blade;

	public WarpedBladeModel(ModelPart root) {
		this.warped_blade = root.getChild("warped_blade");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData warped_blade = modelPartData.addChild("warped_blade", ModelPartBuilder.create().uv(0, 0).cuboid(-0.0746F, -21.0154F, -1.0F, 0.0F, 17.0F, 2.0F, new Dilation(0.0F))
		.uv(4, 0).cuboid(-0.5497F, -4.9928F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(4, 5).cuboid(-0.5497F, -3.9928F, -1.0F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F))
		.uv(10, 5).cuboid(-0.5497F, -5.9928F, -3.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(10, 9).cuboid(-0.5497F, -5.9928F, 2.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 23.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		warped_blade.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}