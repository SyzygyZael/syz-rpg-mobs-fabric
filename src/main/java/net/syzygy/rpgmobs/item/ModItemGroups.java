package net.syzygy.rpgmobs.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;

public class ModItemGroups {
    public static final ItemGroup RPG_MOBS_GROUP = FabricItemGroupBuilder.create(
                    new Identifier(RPGMobs.MOD_ID, "rpg_mobs_group"))
            .icon(() -> new ItemStack(ModItems.CRYSTALLINE_MAGMITE_HELMET))
            .build();

    public static void registerItemGroups() {
        RPGMobs.LOGGER.info("Registering Item Groups for " + RPGMobs.MOD_ID);
    }
}
