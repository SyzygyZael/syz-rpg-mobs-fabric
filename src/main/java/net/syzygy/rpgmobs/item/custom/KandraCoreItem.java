package net.syzygy.rpgmobs.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KandraCoreItem extends Item {
    public KandraCoreItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.rpgmobs.kandra_core.tooltip_line1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.rpgmobs.kandra_core.tooltip_line2").formatted(Formatting.GRAY));
    }
}
