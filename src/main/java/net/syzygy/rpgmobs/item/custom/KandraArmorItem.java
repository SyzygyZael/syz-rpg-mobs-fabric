package net.syzygy.rpgmobs.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KandraArmorItem extends ArmorItem {
    public KandraArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.rpgmobs.kandra_armor.tooltip_line1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.rpgmobs.kandra_armor.tooltip_line2").formatted(Formatting.GRAY));
    }
}
