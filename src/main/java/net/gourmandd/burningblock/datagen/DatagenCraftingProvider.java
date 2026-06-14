package net.gourmandd.burningblock.datagen;

import net.gourmandd.burningblock.BBTags;
import net.gourmandd.burningblock.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

public class DatagenCraftingProvider extends RecipeProvider
{

    public DatagenCraftingProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput out) {

        new ShapelessRecipeBuilder(RecipeCategory.REDSTONE, new ItemStack(ModItems.BURNT_BUTTON_ITEM.asItem()))
                .requires(ModItems.BURNT_PLANKS_ITEM)
                .group("wooden_button")
                .unlockedBy("has_item", has(ModItems.BURNT_PLANKS_ITEM))
                .save(out);

        new ShapelessRecipeBuilder(RecipeCategory.BUILDING_BLOCKS, new ItemStack(ModItems.BURNT_PLANKS_ITEM.asItem(), 4))
                .requires(BBTags.BURNT_LOGS)
                .group("planks")
                .unlockedBy("has_item", has(BBTags.BURNT_LOGS))
                .save(out);

        new ShapedRecipeBuilder(RecipeCategory.BUILDING_BLOCKS, new ItemStack(ModItems.BURNT_STRIPPED_WOOD_ITEM.asItem(), 3))
                .define('#', Ingredient.of(ModItems.BURNT_STRIPPED_LOG_ITEM.asItem()))
                .pattern("##")
                .pattern("##")
                .group("bark")
                .unlockedBy("has_item", has(ModItems.BURNT_PLANKS_ITEM))
                .save(out);

        new ShapedRecipeBuilder(RecipeCategory.BUILDING_BLOCKS, new ItemStack(ModItems.BURNT_WOOD_ITEM.asItem(), 3))
                .define('#', Ingredient.of(ModItems.BURNT_LOG_ITEM.asItem()))
                .pattern("##")
                .pattern("##")
                .group("bark")
                .unlockedBy("has_item", has(ModItems.BURNT_PLANKS_ITEM))
                .save(out);

        new ShapedRecipeBuilder(RecipeCategory.BUILDING_BLOCKS, new ItemStack(ModItems.BURNT_TRAPDOOR_ITEM.asItem(), 2))
                .define('#', Ingredient.of(ModItems.BURNT_PLANKS_ITEM.asItem()))
                .pattern("###")
                .pattern("###")
                .group("wooden_trapdoors")
                .unlockedBy("has_item", has(ModItems.BURNT_PLANKS_ITEM))
                .save(out);

        new ShapedRecipeBuilder(RecipeCategory.BUILDING_BLOCKS, new ItemStack(ModItems.BURNT_STAIRS_ITEM.asItem(), 4))
                .define('#', Ingredient.of(ModItems.BURNT_PLANKS_ITEM.asItem()))
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .group("wooden_stairs")
                .unlockedBy("has_item", has(ModItems.BURNT_PLANKS_ITEM))
                .save(out);

        new ShapedRecipeBuilder(RecipeCategory.BUILDING_BLOCKS, new ItemStack(ModItems.BURNT_SLAB_ITEM.asItem(), 6))
                .define('#', Ingredient.of(ModItems.BURNT_PLANKS_ITEM.asItem()))
                .pattern("###")
                .group("wooden_slab")
                .unlockedBy("has_item", has(ModItems.BURNT_PLANKS_ITEM))
                .save(out);

        new ShapedRecipeBuilder(RecipeCategory.REDSTONE, new ItemStack(ModItems.BURNT_PRESSURE_PLATE_ITEM.asItem()))
                .define('#', Ingredient.of(ModItems.BURNT_PLANKS_ITEM.asItem()))
                .pattern("##")
                .group("wooden_pressure_plate")
                .unlockedBy("has_item", has(ModItems.BURNT_PLANKS_ITEM))
                .save(out);

        new ShapedRecipeBuilder(RecipeCategory.REDSTONE, new ItemStack(ModItems.BURNT_FENCE_GATE_ITEM.asItem()))
                .define('#', Ingredient.of(ModItems.BURNT_PLANKS_ITEM.asItem()))
                .define('S', Ingredient.of(Items.STICK))
                .pattern("S#S")
                .pattern("S#S")
                .group("wooden_fence_gate")
                .unlockedBy("has_item", has(ModItems.BURNT_PLANKS_ITEM))
                .save(out);

        new ShapedRecipeBuilder(RecipeCategory.MISC, new ItemStack(ModItems.BURNT_FENCE_ITEM.asItem()))
                .define('#', Ingredient.of(ModItems.BURNT_PLANKS_ITEM.asItem()))
                .define('S', Ingredient.of(Items.STICK))
                .pattern("#S#")
                .pattern("#S#")
                .group("wooden_fence")
                .unlockedBy("has_item", has(ModItems.BURNT_PLANKS_ITEM))
                .save(out);

        new ShapedRecipeBuilder(RecipeCategory.REDSTONE, new ItemStack(ModItems.BURNT_DOOR_ITEM.asItem()))
                .define('#', Ingredient.of(ModItems.BURNT_PLANKS_ITEM.asItem()))
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .group("wooden_door")
                .unlockedBy("has_item", has(ModItems.BURNT_PLANKS_ITEM))
                .save(out);
    }
}
