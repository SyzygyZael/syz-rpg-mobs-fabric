package net.syzygy.rpgmobs.item;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;

import java.util.Map;

public class ModArmorMaterials {

    public static final RegistryKey<EquipmentAsset> CRYSTALLINE_MAGMITE_KEY = RegistryKey.of(
            EquipmentAssetKeys.REGISTRY_KEY,
            Identifier.of(RPGMobs.MOD_ID, "crystalline_magmite")
    );

    public static final ArmorMaterial CRYSTALLINE_MAGMITE = new ArmorMaterial(
            20 * 25,  // base durability (multiplier * base)
            Map.of(
                    EquipmentType.HELMET,     3,
                    EquipmentType.CHESTPLATE, 7,
                    EquipmentType.LEGGINGS,   6,
                    EquipmentType.BOOTS,      3
            ),
            19,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            1.5f,
            0.1f,
            ModToolMaterials.KANDRA_CORE_TAG,
            CRYSTALLINE_MAGMITE_KEY
    );
}