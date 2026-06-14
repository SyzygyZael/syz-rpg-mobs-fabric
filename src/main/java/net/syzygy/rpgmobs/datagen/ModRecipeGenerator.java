package net.syzygy.rpgmobs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.item.Item;
import net.syzygy.rpgmobs.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeGenerator extends FabricRecipeProvider {

    public ModRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        return new RecipeGenerator(registries, exporter) {
            @Override
            public void generate() {
                RegistryEntryLookup<Item> items = registries.getOrThrow(RegistryKeys.ITEM);

                ShapedRecipeJsonBuilder.create(items, RecipeCategory.MISC, ModItems.CRYSTALLINE_MAGMITE_HELMET)
                        .pattern("SSS")
                        .pattern("SPS")
                        .pattern("   ")
                        .input('S', Items.STONE)
                        .input('P', ModItems.KANDRA_CORE)
                        .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                        .criterion(hasItem(ModItems.KANDRA_CORE), conditionsFromItem(ModItems.KANDRA_CORE))
                        .offerTo(exporter, getRecipeName(ModItems.CRYSTALLINE_MAGMITE_HELMET));

                ShapedRecipeJsonBuilder.create(items, RecipeCategory.MISC, ModItems.CRYSTALLINE_MAGMITE_CHESTPLATE)
                        .pattern("S S")
                        .pattern("SPS")
                        .pattern("SSS")
                        .input('S', Items.STONE)
                        .input('P', ModItems.KANDRA_CORE)
                        .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                        .criterion(hasItem(ModItems.KANDRA_CORE), conditionsFromItem(ModItems.KANDRA_CORE))
                        .offerTo(exporter, getRecipeName(ModItems.CRYSTALLINE_MAGMITE_CHESTPLATE));

                ShapedRecipeJsonBuilder.create(items, RecipeCategory.MISC, ModItems.CRYSTALLINE_MAGMITE_LEGGINGS)
                        .pattern("SPS")
                        .pattern("S S")
                        .pattern("S S")
                        .input('S', Items.STONE)
                        .input('P', ModItems.KANDRA_CORE)
                        .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                        .criterion(hasItem(ModItems.KANDRA_CORE), conditionsFromItem(ModItems.KANDRA_CORE))
                        .offerTo(exporter, getRecipeName(ModItems.CRYSTALLINE_MAGMITE_LEGGINGS));

                ShapedRecipeJsonBuilder.create(items, RecipeCategory.MISC, ModItems.CRYSTALLINE_MAGMITE_BOOTS)
                        .pattern("   ")
                        .pattern("S S")
                        .pattern("S S")
                        .input('S', Items.STONE)
                        .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                        .offerTo(exporter, getRecipeName(ModItems.CRYSTALLINE_MAGMITE_BOOTS));

                ShapedRecipeJsonBuilder.create(items, RecipeCategory.COMBAT, ModItems.SHARD_BLADE)
                        .pattern(" S ")
                        .pattern(" S ")
                        .pattern(" P ")
                        .input('S', ModItems.SHARD_PIECE)
                        .input('P', Items.STICK)
                        .criterion(hasItem(ModItems.SHARD_PIECE), conditionsFromItem(ModItems.SHARD_PIECE))
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(exporter, getRecipeName(ModItems.SHARD_BLADE));

                ShapedRecipeJsonBuilder.create(items, RecipeCategory.COMBAT, ModItems.STAFF_OF_THE_FOREST_MONARCH)
                        .pattern(" SP")
                        .pattern(" SS")
                        .pattern("S  ")
                        .input('S', Items.STICK)
                        .input('P', ModItems.TREANT_ESSENCE_GEM)
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .criterion(hasItem(ModItems.TREANT_ESSENCE_GEM), conditionsFromItem(ModItems.TREANT_ESSENCE_GEM))
                        .offerTo(exporter, getRecipeName(ModItems.STAFF_OF_THE_FOREST_MONARCH));

                ShapedRecipeJsonBuilder.create(items, RecipeCategory.COMBAT, ModItems.DEMONIC_BLADE)
                        .pattern(" S ")
                        .pattern("SSS")
                        .pattern("SPS")
                        .input('S', ModItems.DARK_IRON_INGOT)
                        .input('P', ModItems.CHIMERA_HEART)
                        .criterion(hasItem(ModItems.DARK_IRON_INGOT), conditionsFromItem(ModItems.DARK_IRON_INGOT))
                        .criterion(hasItem(ModItems.CHIMERA_HEART), conditionsFromItem(ModItems.CHIMERA_HEART))
                        .offerTo(exporter, getRecipeName(ModItems.DEMONIC_BLADE));
            }
        };
    }

    @Override
    public String getName() {
        return "RPGMobs Recipes";
    }
}