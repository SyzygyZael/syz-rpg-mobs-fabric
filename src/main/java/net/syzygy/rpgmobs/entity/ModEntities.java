package net.syzygy.rpgmobs.entity;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.entity.custom.*;

public class ModEntities {
    private static final RegistryKey<EntityType<?>> CRYSTALLINE_MAGMITE_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(RPGMobs.MOD_ID, "crystalline_magmite"));
    private static final RegistryKey<EntityType<?>> COBBLE_PROJECTILE_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(RPGMobs.MOD_ID, "cobble_projectile"));
    private static final RegistryKey<EntityType<?>> ARCHANGEL_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(RPGMobs.MOD_ID, "archangel"));
    private static final RegistryKey<EntityType<?>> TWISTED_TREANT_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(RPGMobs.MOD_ID, "twisted_treant"));
    private static final RegistryKey<EntityType<?>> TWISTED_TREANT_STANDING_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(RPGMobs.MOD_ID, "twisted_treant_standing"));


    public static final EntityType<CrystallineMagmiteEntity> CRYSTALLINE_MAGMITE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(RPGMobs.MOD_ID, "crystalline_magmite"),
            EntityType.Builder.create(CrystallineMagmiteEntity::new, SpawnGroup.MONSTER)
                    .dimensions(1.5f, 3f).build(CRYSTALLINE_MAGMITE_KEY));

    public static final EntityType<CobbleProjectileEntity> COBBLE_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(RPGMobs.MOD_ID, "cobble_projectile"),
            EntityType.Builder.<CobbleProjectileEntity>create(CobbleProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(1f, 1f).build(COBBLE_PROJECTILE_KEY));

    public static final EntityType<ArchangelEntity> ARCHANGEL = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(RPGMobs.MOD_ID, "archangel"),
            EntityType.Builder.create(ArchangelEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.8f, 2.0f).build(ARCHANGEL_KEY));

    public static final EntityType<TwistedTreantEntity> TWISTED_TREANT = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(RPGMobs.MOD_ID, "twisted_treant"),
            EntityType.Builder.create(TwistedTreantEntity::new, SpawnGroup.MONSTER)
                    .dimensions(1.4f, 2.4f).build(TWISTED_TREANT_KEY));

    public static final EntityType<TwistedTreantStandingEntity> TWISTED_TREANT_STANDING = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(RPGMobs.MOD_ID, "twisted_treant_standing"),
            EntityType.Builder.create(TwistedTreantStandingEntity::new, SpawnGroup.MONSTER)
                    .dimensions(1.4f, 2.4f).build(TWISTED_TREANT_STANDING_KEY));

    public static void registerModEntites() {
        RPGMobs.LOGGER.info("Registering ModEntities for " + RPGMobs.MOD_ID);
    }
}
