package net.syzygy.rpgmobs.item;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.util.ModTags;

import java.util.EnumMap;

public class ModArmorMaterials {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> CRYSTALLINE_MAGMITE_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(RPGMobs.MOD_ID, "crystalline_magmite"));

    public static final ArmorMaterial CRYSTALLINE_MAGMITE_ARMOR_MATERIAL = new ArmorMaterial(500, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 3);
        map.put(EquipmentType.LEGGINGS, 6);
        map.put(EquipmentType.CHESTPLATE, 7);
        map.put(EquipmentType.HELMET, 3);
    }), 19, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0, 0, ModTags.Items.SHARD_REPAIR, CRYSTALLINE_MAGMITE_KEY);
}