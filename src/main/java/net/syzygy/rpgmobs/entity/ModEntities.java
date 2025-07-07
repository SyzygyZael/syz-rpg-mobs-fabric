package net.syzygy.rpgmobs.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.entity.ArchangelComponents.ArchangelEntity;
import net.syzygy.rpgmobs.entity.CobbleProjectileComponents.CobbleProjectileEntity;
import net.syzygy.rpgmobs.entity.CrystillineMagmiteComponents.CrystallineMagmiteEntity;

public class ModEntities {

    public static final EntityType<CrystallineMagmiteEntity> CRYSTALLINE_MAGMITE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RPGMobs.MOD_ID, "crystalline_magmite"),
            FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, CrystallineMagmiteEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 3f)).build());

    public static final EntityType<CobbleProjectileEntity> COBBLE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RPGMobs.MOD_ID, "cobble_projectile"),
            FabricEntityTypeBuilder.<CobbleProjectileEntity>create(SpawnGroup.MISC, CobbleProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());

    public static final EntityType<ArchangelEntity> ARCHANGEL = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(RPGMobs.MOD_ID, "archangel"),
            FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, ArchangelEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 2.0f)).build());

    public static void registerModEntites() {
        RPGMobs.LOGGER.info("Registering ModEntities for " + RPGMobs.MOD_ID);
    }
}
