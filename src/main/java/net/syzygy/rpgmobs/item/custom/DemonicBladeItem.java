package net.syzygy.rpgmobs.item.custom;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import javax.swing.*;
import java.util.function.Consumer;

public class DemonicBladeItem extends Item {
    public DemonicBladeItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable("item.rpgmobs.demonic_blade.tooltip_line1").formatted(Formatting.GRAY));
        textConsumer.accept(Text.translatable("item.rpgmobs.demonic_blade.tooltip_line2").formatted(Formatting.GRAY));
        textConsumer.accept(Text.translatable("item.rpgmobs.demonic_blade.tooltip_line3").formatted(Formatting.GRAY));
    }
}