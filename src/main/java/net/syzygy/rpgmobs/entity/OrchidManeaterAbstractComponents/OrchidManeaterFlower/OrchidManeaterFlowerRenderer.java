package net.syzygy.rpgmobs.entity.OrchidManeaterAbstractComponents.OrchidManeaterFlower;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.client.RPGMobsEntityModelLayers;

public class OrchidManeaterFlowerRenderer extends MobEntityRenderer<OrchidManeaterFlowerEntity, OrchidManeaterFlowerRenderState, OrchidManeaterFlowerModel> {
    private static final Identifier TEXTURE = Identifier.of(RPGMobs.MOD_ID, "textures/entity/orchid_maneater_flower.png");

    public OrchidManeaterFlowerRenderer(EntityRendererFactory.Context context) {
        super(context, new OrchidManeaterFlowerModel(context.getPart(RPGMobsEntityModelLayers.ORCHID_MANEATER_FLOWER)), 0.0F);
    }

    @Override
    public Identifier getTexture(OrchidManeaterFlowerRenderState state) {
        return TEXTURE;
    }

    @Override
    public OrchidManeaterFlowerRenderState createRenderState() {
        return new OrchidManeaterFlowerRenderState();
    }

    @Override
    public void updateRenderState(OrchidManeaterFlowerEntity livingEntity, OrchidManeaterFlowerRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
    }
}