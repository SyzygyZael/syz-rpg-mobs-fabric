package net.syzygy.rpgmobs.item;

import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.config.ModConfig;
import net.syzygy.rpgmobs.item.custom.*;

public class ModItems {
    public static final Item KANDRA_CORE = registerItem("kandra_core", KandraArmorItem::new);
    public static final Item SHARD_PIECE = registerItem("shard_piece", ShardPieceItem::new);
    public static final Item TREANT_ESSENCE_GEM = registerItem("treant_essence_gem", TreantEssenceGemItem::new);
    public static final Item CHIMERA_HEART = registerItem("chimera_heart", ChimeraHeartItem::new);
    public static final Item DARK_IRON_FRAGMENT = registerItem("dark_iron_fragment", DarkIronFragmentItem::new);
    public static final Item DARK_IRON_INGOT = registerItem("dark_iron_ingot",  DarkIronIngotItem::new);

    public static final Item ORCHID_BULB = registerItem("orchid_bulb",
            settings -> new OrchidBulbItem(settings.food(ModFoodComponents.ORCHID_BULB, ModFoodComponents.ORCHID_BULB_EFFECTS)));
    public static final Item COOKED_ORCHID_BULB = registerItem("cooked_orchid_bulb",
            settings -> new Item(settings.food(ModFoodComponents.COOKED_ORCHID_BULB, ModFoodComponents.ORCHID_BULB_COOKED_EFFECTS)));

    public static final Item SHARD_BLADE = registerItem("shard_blade",
            settings -> new ShardBladeItem(settings.sword(ModToolMaterials.SHARD, ModConfig.shardBladeDamage - 6, -2.2f)));
    public static final Item STAFF_OF_THE_FOREST_MONARCH = registerItem("staff_of_the_forest_monarch", StaffOfTheForestMonarchItem::new);
    public static final Item DEMONIC_BLADE = registerItem("demonic_blade",
            settings -> new DemonicBladeItem(settings.sword(ModToolMaterials.DEMONIC,  ModConfig.demonicBladeDamage - 6, -2.6f)));

    public static final Item CRYSTALLINE_MAGMITE_HELMET = registerItem("crystalline_magmite_helmet",
            settings -> new KandraArmorItem(settings.armor(ModArmorMaterials.CRYSTALLINE_MAGMITE, EquipmentType.HELMET)));
    public static final Item CRYSTALLINE_MAGMITE_CHESTPLATE = registerItem("crystalline_magmite_chestplate",
            settings -> new KandraArmorItem(settings.armor(ModArmorMaterials.CRYSTALLINE_MAGMITE, EquipmentType.CHESTPLATE)));
    public static final Item CRYSTALLINE_MAGMITE_LEGGINGS = registerItem("crystalline_magmite_leggings",
            settings -> new KandraArmorItem(settings.armor(ModArmorMaterials.CRYSTALLINE_MAGMITE, EquipmentType.LEGGINGS)));
    public static final Item CRYSTALLINE_MAGMITE_BOOTS = registerItem("crystalline_magmite_boots",
            settings -> new KandraArmorItem(settings.armor(ModArmorMaterials.CRYSTALLINE_MAGMITE, EquipmentType.BOOTS)));


    private static <T extends Item> T registerItem(String name, java.util.function.Function<Item.Settings, T> factory) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RPGMobs.MOD_ID, name));
        T item = factory.apply(new Item.Settings().registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModItems() {
        RPGMobs.LOGGER.info("Registering Mod Items for " + RPGMobs.MOD_ID);
    }
}
