package net.syzygy.rpgmobs.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.syzygy.rpgmobs.item.ModArmorMaterials;
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
        itemModelGenerator.register(ModItems.TREANT_ESSENCE_GEM, Models.GENERATED);

        itemModelGenerator.registerArmor(ModItems.CRYSTALLINE_MAGMITE_HELMET, ModArmorMaterials.CRYSTALLINE_MAGMITE_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.CRYSTALLINE_MAGMITE_CHESTPLATE, ModArmorMaterials.CRYSTALLINE_MAGMITE_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.CRYSTALLINE_MAGMITE_LEGGINGS, ModArmorMaterials.CRYSTALLINE_MAGMITE_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX,false);
        itemModelGenerator.registerArmor(ModItems.CRYSTALLINE_MAGMITE_BOOTS, ModArmorMaterials.CRYSTALLINE_MAGMITE_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
    }
}
