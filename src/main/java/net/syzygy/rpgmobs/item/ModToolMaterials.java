package net.syzygy.rpgmobs.item;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;

public class ModToolMaterials {
    public static final TagKey<Item> CHIMERA_HEART_TAG = TagKey.of(RegistryKeys.ITEM,
            Identifier.of(RPGMobs.MOD_ID, "chimera_heart_repair"));
    public static final TagKey<Item> SHARD_TOOL_TAG = TagKey.of(RegistryKeys.ITEM,
            Identifier.of(RPGMobs.MOD_ID, "shard_blade_repair"));
    public static final TagKey<Item> KANDRA_CORE_TAG = TagKey.of(RegistryKeys.ITEM,
            Identifier.of(RPGMobs.MOD_ID, "kandra_core_repair"));

    public static final ToolMaterial DEMONIC = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            6064,
            7.5F,
            6.0F,
            15,
            CHIMERA_HEART_TAG
    );

    public static final ToolMaterial SHARD = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            5038,
            9.0F,
            5.0F,
            15,
            SHARD_TOOL_TAG
    );
}
