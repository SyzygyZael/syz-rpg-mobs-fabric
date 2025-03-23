package net.syzygy.rpgmobs.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;

public class ModItemGroups {
    public static final ItemGroup RPG_MOBS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RPGMobs.MOD_ID, "rpg_mobs_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rpg_mobs_group"))
                    .icon(() -> new ItemStack(Items.ITEM_FRAME)).entries((displayContext, entries) -> {

                    }).build());

    public static void registerItemGroups() {
        RPGMobs.LOGGER.info("Registering Item Groups for " + RPGMobs.MOD_ID);
    }
}
