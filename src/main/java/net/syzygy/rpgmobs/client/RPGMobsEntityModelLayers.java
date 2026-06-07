package net.syzygy.rpgmobs.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.entity.ArchangelComponents.ArchangelModel;
import net.syzygy.rpgmobs.entity.ChimeraComponents.ChimeraModel;
import net.syzygy.rpgmobs.entity.CobbleProjectileComponents.CobbleProjectileModel;
import net.syzygy.rpgmobs.entity.CrystillineMagmiteComponents.CrystallineMagmiteModel;
import net.syzygy.rpgmobs.entity.OrchidManeaterAbstractComponents.OrchidManeater.OrchidManeaterModel;
import net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreant.TwistedTreantModel;
import net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreantStanding.TwistedTreantStandingModel;
import net.syzygy.rpgmobs.event.RegisterEntityLayersEvent;

import javax.swing.text.html.parser.Entity;

@Environment(EnvType.CLIENT)
public final class RPGMobsEntityModelLayers {
    public static final EntityModelLayer ARCHANGEL = new EntityModelLayer(RPGMobs.makeID("archangel"), "main");
    public static final EntityModelLayer CHIMERA = new EntityModelLayer(RPGMobs.makeID("chimera"), "main");
    public static final EntityModelLayer COBBLE_PROJECTILE = new EntityModelLayer(RPGMobs.makeID("cobble_projectile"), "main");
    public static final EntityModelLayer CRYSTALLINE_MAGMITE = new EntityModelLayer(RPGMobs.makeID("crystalline_magmite"), "main");
    public static final EntityModelLayer ORCHID_MANEATER = new EntityModelLayer(RPGMobs.makeID("orchid_maneater"), "main");
    public static final EntityModelLayer TWISTED_TREANT = new EntityModelLayer(RPGMobs.makeID("twisted_treant"), "main");
    public static final EntityModelLayer TWISTED_TREANT_STANDING = new EntityModelLayer(RPGMobs.makeID("twisted_treant_standing"), "main");

    public static void registerEntityLayers(RegisterEntityLayersEvent event) {
        event.register(ARCHANGEL, ArchangelModel::getTexturedModelData);
        event.register(CHIMERA, ChimeraModel::getTexturedModelData);
        event.register(COBBLE_PROJECTILE, CobbleProjectileModel::getTexturedModelData);
        event.register(CRYSTALLINE_MAGMITE, CrystallineMagmiteModel::getTexturedModelData);
        event.register(ORCHID_MANEATER, OrchidManeaterModel::getTexturedModelData);
        event.register(TWISTED_TREANT, TwistedTreantModel::getTexturedModelData);
        event.register(TWISTED_TREANT_STANDING, TwistedTreantStandingModel::getTexturedModelData);
    }
}
