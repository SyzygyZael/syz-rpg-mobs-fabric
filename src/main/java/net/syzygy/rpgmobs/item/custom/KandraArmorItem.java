package net.syzygy.rpgmobs.item.custom;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.function.Consumer;

public class KandraArmorItem extends Item {

    public KandraArmorItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable("item.rpgmobs.kandra_armor.tooltip_line1").formatted(Formatting.GRAY));
        textConsumer.accept(Text.translatable("item.rpgmobs.kandra_armor.tooltip_line2").formatted(Formatting.GRAY));
    }
}
