package net.syzygy.rpgmobs.entity.CrystillineMagmiteComponents;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.client.RPGMobsEntityModelLayers;

public class CrystallineMagmiteRenderer extends MobEntityRenderer<CrystallineMagmiteEntity, CrystallineMagmiteRenderState, CrystallineMagmiteModel> {
    private static final Identifier TEXTURE = Identifier.of(RPGMobs.MOD_ID, "textures/entity/crystalline_magmite.png");

    public CrystallineMagmiteRenderer(EntityRendererFactory.Context context) {
        super(context, new CrystallineMagmiteModel(context.getPart(RPGMobsEntityModelLayers.CRYSTALLINE_MAGMITE)), 0.0F);
    }

    @Override
    public Identifier getTexture(CrystallineMagmiteRenderState state) {
        return TEXTURE;
    }

    @Override
    public CrystallineMagmiteRenderState createRenderState() {
        return new CrystallineMagmiteRenderState();
    }

    @Override
    public void updateRenderState(CrystallineMagmiteEntity livingEntity, CrystallineMagmiteRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);

        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
        livingEntityRenderState.attack1AnimationState.copyFrom(livingEntity.attack1AnimationState);
        livingEntityRenderState.attack2AnimationState.copyFrom(livingEntity.attack2AnimationState);
    }
}
