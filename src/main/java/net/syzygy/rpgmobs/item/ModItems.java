package net.syzygy.rpgmobs.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.config.ModConfig;
import net.syzygy.rpgmobs.item.custom.*;


public class ModItems {
    public static final Item KANDRA_CORE = registerItem("kandra_core",
            new KandraCoreItem(new FabricItemSettings().group(ModItemGroups.RPG_MOBS_GROUP)));
    public static final Item SHARD_PIECE = registerItem("shard_piece",
            new ShardPieceItem(new FabricItemSettings().group(ModItemGroups.RPG_MOBS_GROUP)));
    public static final Item TREANT_ESSENCE_GEM = registerItem("treant_essence_gem",
            new TreantEssenceGemItem(new FabricItemSettings().group(ModItemGroups.RPG_MOBS_GROUP)));

    public static final Item SHARD_BLADE = registerItem("shard_blade",
            new ShardBladeItem(ModToolMaterial.SHARD, ModConfig.shardBladeDamage - 6, -2.2f, new FabricItemSettings().group(ModItemGroups.RPG_MOBS_GROUP)));
    public static final Item STAFF_OF_THE_FOREST_MONARCH = registerItem("staff_of_the_forest_monarch",
            new StaffOfTheForestMonarchItem(ToolMaterials.STONE, 1, 1.0f, new FabricItemSettings().group(ModItemGroups.RPG_MOBS_GROUP)));

    public static final Item CRYSTALLINE_MAGMITE_HELMET = registerItem("crystalline_magmite_helmet",
            new KandraArmorItem(ModArmorMaterials.CRYSTALLINE_MAGMITE, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroups.RPG_MOBS_GROUP)));
    public static final Item CRYSTALLINE_MAGMITE_CHESTPLATE = registerItem("crystalline_magmite_chestplate",
            new KandraArmorItem(ModArmorMaterials.CRYSTALLINE_MAGMITE, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroups.RPG_MOBS_GROUP)));
    public static final Item CRYSTALLINE_MAGMITE_LEGGINGS = registerItem("crystalline_magmite_leggings",
            new KandraArmorItem(ModArmorMaterials.CRYSTALLINE_MAGMITE, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroups.RPG_MOBS_GROUP)));
    public static final Item CRYSTALLINE_MAGMITE_BOOTS = registerItem("crystalline_magmite_boots",
            new KandraArmorItem(ModArmorMaterials.CRYSTALLINE_MAGMITE, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroups.RPG_MOBS_GROUP)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(RPGMobs.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RPGMobs.LOGGER.info("Registering Mod Items for " + RPGMobs.MOD_ID);
    }
}
