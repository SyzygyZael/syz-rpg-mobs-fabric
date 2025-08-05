package net.syzygy.rpgmobs.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;

public class ModItemGroups {
    public static final ItemGroup RPG_MOBS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RPGMobs.MOD_ID, "rpg_mobs_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rpg_mobs_group"))
                    .icon(() -> new ItemStack(ModItems.CRYSTALLINE_MAGMITE_HELMET)).entries((displayContext, entries) -> {
                        entries.add(ModItems.KANDRA_CORE);
                        entries.add(ModItems.CRYSTALLINE_MAGMITE_HELMET);
                        entries.add(ModItems.CRYSTALLINE_MAGMITE_CHESTPLATE);
                        entries.add(ModItems.CRYSTALLINE_MAGMITE_LEGGINGS);
                        entries.add(ModItems.CRYSTALLINE_MAGMITE_BOOTS);
                        entries.add(ModItems.SHARD_PIECE);
                        entries.add(ModItems.SHARD_BLADE);
                        entries.add(ModItems.STAFF_OF_THE_FOREST_MONARCH);
                        entries.add(ModItems.TREANT_ESSENCE_GEM);
                    }).build());

    public static void registerItemGroups() {
        RPGMobs.LOGGER.info("Registering Item Groups for " + RPGMobs.MOD_ID);
    }
}
