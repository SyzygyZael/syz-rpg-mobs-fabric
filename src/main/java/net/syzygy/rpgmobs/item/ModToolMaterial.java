package net.syzygy.rpgmobs.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Lazy;
import net.syzygy.rpgmobs.util.ModTags;

import javax.swing.text.html.HTML;
import javax.tools.Tool;
import java.util.function.Supplier;

public class ModToolMaterial {
    // SHARD(5, 5038, 9.0F, 5.0F, 15, () -> Ingredient.ofItems(ModItems.SHARD_PIECE));

    public static ToolMaterial SHARD = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_SHARD_TOOL,
            5038, 1.8f, 5, 15, ModTags.Items.SHARD_REPAIR);
}
