package net.syzygy.rpgmobs.item.custom;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.function.Consumer;

public class DarkIronFragmentItem extends Item {
    public DarkIronFragmentItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable("item.rpgmobs.dark_iron_fragment.tooltip_line1").formatted(Formatting.GRAY));
        textConsumer.accept(Text.translatable("item.rpgmobs.dark_iron_fragment.tooltip_line2").formatted(Formatting.GRAY));
        textConsumer.accept(Text.translatable("item.rpgmobs.dark_iron_fragment.tooltip_line3").formatted(Formatting.GRAY));
    }
}