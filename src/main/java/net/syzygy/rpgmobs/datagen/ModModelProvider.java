package net.syzygy.rpgmobs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.syzygy.rpgmobs.item.ModItemGroups;
import net.syzygy.rpgmobs.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.KANDRA_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHARD_PIECE, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CRYSTALLINE_MAGMITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CRYSTALLINE_MAGMITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CRYSTALLINE_MAGMITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.CRYSTALLINE_MAGMITE_BOOTS));
    }
}
