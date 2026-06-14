package net.syzygy.rpgmobs.item;

import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.config.ModConfig;
import net.syzygy.rpgmobs.item.custom.*;

public class ModItems {
    public static final Item KANDRA_CORE = registerItem("kandra_core",
            new KandraCoreItem(new Item.Settings()));
    public static final Item SHARD_PIECE = registerItem("shard_piece",
            new ShardPieceItem(new Item.Settings()));
    public static final Item TREANT_ESSENCE_GEM = registerItem("treant_essence_gem",
            new TreantEssenceGemItem(new Item.Settings()));
    public static final Item CHIMERA_HEART = registerItem("chimera_heart",
            new ChimeraHeartItem(new Item.Settings()));
    public static final Item DARK_IRON_FRAGMENT = registerItem("dark_iron_fragment",
            new DarkIronFragmentItem(new Item.Settings()));
    public static final Item DARK_IRON_INGOT = registerItem("dark_iron_ingot",
            new DarkIronIngotItem(new Item.Settings()));

    public static final Item ORCHID_BULB = registerItem("orchid_bulb",
            new OrchidBulbItem(new Item.Settings().food(ModFoodComponents.ORCHID_BULB, ModFoodComponents.ORCHID_BULB_EFFECTS)));
    public static final Item COOKED_ORCHID_BULB = registerItem("cooked_orchid_bulb",
            new Item(new Item.Settings().food(ModFoodComponents.COOKED_ORCHID_BULB, ModFoodComponents.ORCHID_BULB_COOKED_EFFECTS)));

    public static final Item SHARD_BLADE = registerItem("shard_blade",
            new ShardBladeItem(new Item.Settings().sword(ModToolMaterials.SHARD, ModConfig.shardBladeDamage - 6, -2.2f)));
    public static final Item STAFF_OF_THE_FOREST_MONARCH = registerItem("staff_of_the_forest_monarch",
            new StaffOfTheForestMonarchItem(new Item.Settings()));
    public static final Item DEMONIC_BLADE = registerItem("demonic_blade",
            new DemonicBladeItem(new Item.Settings().sword(ModToolMaterials.DEMONIC,  ModConfig.demonicBladeDamage - 6, -2.6f)));

    public static final Item CRYSTALLINE_MAGMITE_HELMET = registerItem("crystalline_magmite_helmet",
            new KandraArmorItem(new Item.Settings().armor(ModArmorMaterials.CRYSTALLINE_MAGMITE, EquipmentType.HELMET)));
    public static final Item CRYSTALLINE_MAGMITE_CHESTPLATE = registerItem("crystalline_magmite_chestplate",
            new KandraArmorItem(new Item.Settings().armor(ModArmorMaterials.CRYSTALLINE_MAGMITE, EquipmentType.CHESTPLATE)));
    public static final Item CRYSTALLINE_MAGMITE_LEGGINGS = registerItem("crystalline_magmite_leggings",
            new KandraArmorItem(new Item.Settings().armor(ModArmorMaterials.CRYSTALLINE_MAGMITE, EquipmentType.LEGGINGS)));
    public static final Item CRYSTALLINE_MAGMITE_BOOTS = registerItem("crystalline_magmite_boots",
            new KandraArmorItem(new Item.Settings().armor(ModArmorMaterials.CRYSTALLINE_MAGMITE, EquipmentType.BOOTS)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(RPGMobs.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RPGMobs.LOGGER.info("Registering Mod Items for " + RPGMobs.MOD_ID);
    }
}
