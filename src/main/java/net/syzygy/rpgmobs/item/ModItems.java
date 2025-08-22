package net.syzygy.rpgmobs.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.item.custom.*;

import java.util.function.Function;

public class ModItems {
    public static final Item KANDRA_CORE = registerItem("kandra_core", Item::new);
    public static final Item SHARD_PIECE = registerItem("shard_piece", Item::new);
    public static final Item TREANT_ESSENCE_GEM = registerItem("treant_essence_gem", Item::new);

    public static final Item SHARD_BLADE = registerItem("shard_blade",
            setting -> new Item(setting.sword(ModToolMaterial.SHARD, 6, -2.4f)));
    public static final Item STAFF_OF_THE_FOREST_MONARCH = registerItem("staff_of_the_forest_monarch",
            setting -> new StaffOfTheForestMonarchItem(setting.sword(ToolMaterial.STONE, 1, 1.0f)));

    public static final Item CRYSTALLINE_MAGMITE_HELMET = registerItem("crystalline_magmite_helmet",
            setting -> new Item(setting.armor(ModArmorMaterials.CRYSTALLINE_MAGMITE_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item CRYSTALLINE_MAGMITE_CHESTPLATE = registerItem("crystalline_magmite_chestplate",
            setting -> new Item(setting.armor(ModArmorMaterials.CRYSTALLINE_MAGMITE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item CRYSTALLINE_MAGMITE_LEGGINGS = registerItem("crystalline_magmite_leggings",
            setting -> new Item(setting.armor(ModArmorMaterials.CRYSTALLINE_MAGMITE_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item CRYSTALLINE_MAGMITE_BOOTS = registerItem("crystalline_magmite_boots",
            setting -> new Item(setting.armor(ModArmorMaterials.CRYSTALLINE_MAGMITE_ARMOR_MATERIAL, EquipmentType.BOOTS)));


    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(RPGMobs.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RPGMobs.MOD_ID, name)))));
    }

    public static void registerModItems() {
        RPGMobs.LOGGER.info("Registering Mod Items for " + RPGMobs.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(KANDRA_CORE);
            entries.add(TREANT_ESSENCE_GEM);
            entries.add(SHARD_PIECE);
        });
    }
}
