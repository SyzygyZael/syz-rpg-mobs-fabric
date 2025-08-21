package net.syzygy.rpgmobs.entity.client.CobbleProjectileComponents;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;

public class CobbleProjectileModel extends EntityModel<CobbleProjectileRenderState> {
    private final ModelPart bb_main;

    public CobbleProjectileModel(ModelPart root) {
        super(root);
        this.bb_main = root.getChild("bb_main");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 4).cuboid(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 24.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(CobbleProjectileRenderState state) {
        super.setAngles(state);
    }
}
