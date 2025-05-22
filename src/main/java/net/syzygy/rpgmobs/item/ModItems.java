package net.syzygy.rpgmobs.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;

import java.security.PublicKey;

public class ModItems {
    public static final Item KANDRA_CORE = registerItem("kandra_core",
            new Item(new FabricItemSettings()));

    public static final Item CRYSTALLINE_MAGMITE_HELMET = registerItem("crystalline_magmite_helmet",
            new ArmorItem(ModArmorMaterials.CRYSTALLINE_MAGMITE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item CRYSTALLINE_MAGMITE_CHESTPLATE = registerItem("crystalline_magmite_chestplate",
            new ArmorItem(ModArmorMaterials.CRYSTALLINE_MAGMITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item CRYSTALLINE_MAGMITE_LEGGINGS = registerItem("crystalline_magmite_leggings",
            new ArmorItem(ModArmorMaterials.CRYSTALLINE_MAGMITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item CRYSTALLINE_MAGMITE_BOOTS = registerItem("crystalline_magmite_boots",
            new ArmorItem(ModArmorMaterials.CRYSTALLINE_MAGMITE, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RPGMobs.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RPGMobs.LOGGER.info("Registering Mod Items for " + RPGMobs.MOD_ID);
    }
}
