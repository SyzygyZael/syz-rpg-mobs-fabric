package net.syzygy.rpgmobs.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.RPGMobs;
import net.syzygy.rpgmobs.item.ModArmorMaterials;
import net.syzygy.rpgmobs.item.ModItems;
import org.jspecify.annotations.NonNull;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.KANDRA_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHARD_PIECE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TREANT_ESSENCE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHIMERA_HEART, Models.GENERATED);
        itemModelGenerator.register(ModItems.DARK_IRON_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DARK_IRON_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORCHID_BULB, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_ORCHID_BULB, Models.GENERATED);

        itemModelGenerator.registerArmor(ModItems.CRYSTALLINE_MAGMITE_HELMET, ModArmorMaterials.CRYSTALLINE_MAGMITE_KEY, Identifier.of(RPGMobs.MOD_ID, "crystalline_magmite"), false);
        itemModelGenerator.registerArmor(ModItems.CRYSTALLINE_MAGMITE_CHESTPLATE, ModArmorMaterials.CRYSTALLINE_MAGMITE_KEY, Identifier.of(RPGMobs.MOD_ID, "crystalline_magmite"), false);
        itemModelGenerator.registerArmor(ModItems.CRYSTALLINE_MAGMITE_LEGGINGS, ModArmorMaterials.CRYSTALLINE_MAGMITE_KEY, Identifier.of(RPGMobs.MOD_ID, "crystalline_magmite"), false);
        itemModelGenerator.registerArmor(ModItems.CRYSTALLINE_MAGMITE_BOOTS, ModArmorMaterials.CRYSTALLINE_MAGMITE_KEY, Identifier.of(RPGMobs.MOD_ID, "crystalline_magmite"), false);
    }
}
