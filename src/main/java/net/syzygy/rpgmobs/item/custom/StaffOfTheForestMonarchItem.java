package net.syzygy.rpgmobs.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StaffOfTheForestMonarchItem extends SwordItem {
    public StaffOfTheForestMonarchItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.rpgmobs.staff_of_the_forest_monarch.tooltip_line1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.rpgmobs.staff_of_the_forest_monarch.tooltip_line2").formatted(Formatting.GRAY));
    }
}
