// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.syzygy.rpgmobs.entity.OrchidManeaterAbstractComponents.OrchidManeaterFlower;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class OrchidManeaterFlowerModel<T extends OrchidManeaterFlowerEntity> extends SinglePartEntityModel<T> {
    private final ModelPart orchid_maneater_flower;
    private final ModelPart part1;
    private final ModelPart part2;
    public OrchidManeaterFlowerModel(ModelPart root) {
        this.orchid_maneater_flower = root.getChild("orchid_maneater_flower");
        this.part1 = this.orchid_maneater_flower.getChild("part1");
        this.part2 = this.orchid_maneater_flower.getChild("part2");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData orchid_maneater_flower = modelPartData.addChild("orchid_maneater_flower", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData part1 = orchid_maneater_flower.addChild("part1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -10.0F, -4.0F, 0.0F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 0.0F, 0.0F));

        ModelPartData part2 = orchid_maneater_flower.addChild("part2", ModelPartBuilder.create().uv(16, 0).cuboid(-4.0F, -10.0F, 0.0F, 8.0F, 10.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(OrchidManeaterFlowerEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        orchid_maneater_flower.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return orchid_maneater_flower;
    }
}