package net.syzygy.rpgmobs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.syzygy.rpgmobs.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {

    public ModRecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(ModItems.CRYSTALLINE_MAGMITE_HELMET, 1)
                .pattern("SSS")
                .pattern("SPS")
                .pattern("   ")
                .input('S', Items.STONE)
                .input('P', ModItems.KANDRA_CORE)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.KANDRA_CORE), conditionsFromItem(ModItems.KANDRA_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRYSTALLINE_MAGMITE_HELMET)));

        ShapedRecipeJsonBuilder.create(ModItems.CRYSTALLINE_MAGMITE_CHESTPLATE, 1)
                .pattern("S S")
                .pattern("SPS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('P', ModItems.KANDRA_CORE)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.KANDRA_CORE), conditionsFromItem(ModItems.KANDRA_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRYSTALLINE_MAGMITE_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(ModItems.CRYSTALLINE_MAGMITE_LEGGINGS, 1)
                .pattern("SPS")
                .pattern("S S")
                .pattern("S S")
                .input('S', Items.STONE)
                .input('P', ModItems.KANDRA_CORE)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.KANDRA_CORE), conditionsFromItem(ModItems.KANDRA_CORE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRYSTALLINE_MAGMITE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(ModItems.CRYSTALLINE_MAGMITE_BOOTS, 1)
                .pattern("   ")
                .pattern("S S")
                .pattern("S S")
                .input('S', Items.STONE)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.CRYSTALLINE_MAGMITE_BOOTS)));

        ShapedRecipeJsonBuilder.create(ModItems.SHARD_BLADE, 1)
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" P ")
                .input('S', ModItems.SHARD_PIECE)
                .input('P', Items.STICK)
                .criterion(hasItem(ModItems.SHARD_PIECE), conditionsFromItem(ModItems.SHARD_PIECE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SHARD_BLADE)));

        ShapedRecipeJsonBuilder.create(ModItems.STAFF_OF_THE_FOREST_MONARCH, 1)
                .pattern(" SP")
                .pattern(" SS")
                .pattern("S  ")
                .input('S', Items.STICK)
                .input('P', ModItems.TREANT_ESSENCE_GEM)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.TREANT_ESSENCE_GEM), conditionsFromItem(ModItems.TREANT_ESSENCE_GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STAFF_OF_THE_FOREST_MONARCH)));
    }
}
