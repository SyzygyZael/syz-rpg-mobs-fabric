package net.syzygy.rpgmobs.entity;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.entity.ArchangelComponents.ArchangelEntity;
import net.syzygy.rpgmobs.entity.ChimeraComponents.ChimeraEntity;
import net.syzygy.rpgmobs.entity.CobbleProjectileComponents.CobbleProjectileEntity;
import net.syzygy.rpgmobs.entity.CrystillineMagmiteComponents.CrystallineMagmiteEntity;
import net.syzygy.rpgmobs.entity.OrchidManeaterAbstractComponents.OrchidManeater.OrchidManeaterEntity;
import net.syzygy.rpgmobs.entity.OrchidManeaterAbstractComponents.OrchidManeaterFlower.OrchidManeaterFlowerEntity;
import net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreant.TwistedTreantEntity;
import net.syzygy.rpgmobs.entity.TwistedTreantAbstractComponents.TwistedTreantStanding.TwistedTreantStandingEntity;

public class ModEntities {

    public static final EntityType<CrystallineMagmiteEntity> CRYSTALLINE_MAGMITE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RPGMobs.MOD_ID, "crystalline_magmite"),
            EntityType.Builder.create(CrystallineMagmiteEntity::new, SpawnGroup.MONSTER)
                    .setDimensions(1.5f, 3f).build());

    public static final EntityType<CobbleProjectileEntity> COBBLE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RPGMobs.MOD_ID, "cobble_projectile"),
            EntityType.Builder.<CobbleProjectileEntity>create(CobbleProjectileEntity::new, SpawnGroup.MISC)
                    .setDimensions(1f, 1f)
                    .build());

    public static final EntityType<ArchangelEntity> ARCHANGEL = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RPGMobs.MOD_ID, "archangel"),
            EntityType.Builder.create(ArchangelEntity::new, SpawnGroup.MONSTER)
                    .setDimensions(0.8f, 2.0f).build());

    public static final EntityType<TwistedTreantEntity> TWISTED_TREANT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RPGMobs.MOD_ID, "twisted_treant"),
            EntityType.Builder.create(TwistedTreantEntity::new, SpawnGroup.MONSTER)
                    .setDimensions(1.4f, 2.4f).build());

    public static final EntityType<TwistedTreantStandingEntity> TWISTED_TREANT_STANDING = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RPGMobs.MOD_ID, "twisted_treant_standing"),
            EntityType.Builder.create(TwistedTreantStandingEntity::new, SpawnGroup.MONSTER)
                    .setDimensions(1.4f, 2.4f).build());

    public static final EntityType<ChimeraEntity> CHIMERA = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RPGMobs.MOD_ID, "chimera"),
            EntityType.Builder.create(ChimeraEntity::new, SpawnGroup.MONSTER)
                    .setDimensions(1.4f, 2.4f).build());

    public static final EntityType<OrchidManeaterEntity> ORCHID_MANEATER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RPGMobs.MOD_ID, "orchid_maneater"),
            EntityType.Builder.create(OrchidManeaterEntity::new, SpawnGroup.MONSTER)
                    .setDimensions(2.3f, 2.8f).build());

    public static final EntityType<OrchidManeaterFlowerEntity> ORCHID_MANEATER_FLOWER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RPGMobs.MOD_ID, "orchid_maneater_flower"),
            EntityType.Builder.create(OrchidManeaterFlowerEntity::new, SpawnGroup.MONSTER)
                    .setDimensions(0.3f, 0.3f).build());

    public static void registerModEntites() {
        RPGMobs.LOGGER.info("Registering ModEntities for " + RPGMobs.MOD_ID);
    }
}
