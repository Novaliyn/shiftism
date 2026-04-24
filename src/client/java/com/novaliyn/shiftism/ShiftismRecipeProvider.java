package com.novaliyn.shiftism;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

public class ShiftismRecipeProvider extends FabricRecipeProvider {
	public ShiftismRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
		return new RecipeProvider(registryLookup, exporter) {
			@Override
			public void buildRecipes() {
				HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);
				//Crafting
				//items
				shapeless(RecipeCategory.MISC, ShiftedItems.shifted_nugget, 9).requires(ShiftedItems.shifted_ingot).unlockedBy(getHasName(ShiftedItems.shifted_ingot), has(ShiftedItems.shifted_ingot)).save(output, "shifted_nuggets_from_ingot");
				shapeless(RecipeCategory.MISC, ShiftedItems.shifted_ingot, 9).requires(ShiftedBlocks.shifted_block).unlockedBy(getHasName(ShiftedBlocks.shifted_block), has(ShiftedBlocks.shifted_block)).save(output, "shifted_ingots_from_block");
				shaped(RecipeCategory.MISC, ShiftedItems.shifted_ingot, 1).pattern("iii").pattern("iii").pattern("iii").define('i', ShiftedItems.shifted_nugget).unlockedBy(getHasName(ShiftedItems.shifted_nugget), (has(ShiftedItems.shifted_nugget))).save(output);
				shaped(RecipeCategory.MISC, ShiftedItems.shifted_rod, 1).pattern("i").pattern("i").define('i', ShiftedItems.shifted_ingot).unlockedBy(getHasName(ShiftedItems.shifted_ingot), (has(ShiftedItems.shifted_ingot))).save(output);
				shaped(RecipeCategory.FOOD, ShiftedItems.mystic_apple, 1).pattern("ini").pattern("nen").pattern("ini").define('n', ShiftedItems.shifted_nugget).define('i', ShiftedItems.shifted_ingot).define('e', Items.GOLDEN_APPLE).unlockedBy(getHasName(ShiftedItems.shifted_ingot), (has(ShiftedItems.shifted_ingot))).save(output);
				shaped(RecipeCategory.MISC, ShiftedItems.shifted_gem, 1).pattern(" i ").pattern("iei").pattern(" i ").define('i', ShiftedItems.shifted_ingot).define('e', Items.DIAMOND_BLOCK).unlockedBy(getHasName(ShiftedItems.shifted_ingot), (has(ShiftedItems.shifted_ingot))).save(output);

				//Blocks
				shaped(RecipeCategory.DECORATIONS, ShiftedBlocks.shifted_block, 1).pattern("iii").pattern("iii").pattern("iii").define('i', ShiftedItems.shifted_ingot).unlockedBy(getHasName(ShiftedItems.shifted_ingot), (has(ShiftedItems.shifted_ingot))).save(output);
				shapeless(RecipeCategory.DECORATIONS, ShiftedBlocks.transgender_flag, 1).requires(ShiftedItems.shifted_nugget).requires(Items.BLUE_DYE).requires(Items.PINK_DYE).unlockedBy(getHasName(ShiftedItems.shifted_nugget), (has(ShiftedItems.shifted_nugget))).save(output);
				shapeless(RecipeCategory.DECORATIONS, ShiftedBlocks.pride_flag, 1).requires(ShiftedItems.shifted_nugget).requires(Items.RED_DYE).requires(Items.GREEN_DYE).unlockedBy(getHasName(ShiftedItems.shifted_nugget), (has(ShiftedItems.shifted_nugget))).save(output);

				//Armor
				shaped(RecipeCategory.COMBAT, ShiftedItems.shifted_helmet, 1).pattern("igi").pattern("i i").define('g', ShiftedItems.shifted_gem).define('i', ShiftedItems.shifted_ingot).unlockedBy(getHasName(ShiftedItems.shifted_gem), (has(ShiftedItems.shifted_gem))).save(output);
				shaped(RecipeCategory.COMBAT, ShiftedItems.shifted_chestplate, 1).pattern("i i").pattern("igi").pattern("iii").define('g', ShiftedItems.shifted_gem).define('i', ShiftedItems.shifted_ingot).unlockedBy(getHasName(ShiftedItems.shifted_gem), (has(ShiftedItems.shifted_gem))).save(output);
				shaped(RecipeCategory.COMBAT, ShiftedItems.shifted_leggings, 1).pattern("igi").pattern("i i").pattern("i i").define('g', ShiftedItems.shifted_gem).define('i', ShiftedItems.shifted_ingot).unlockedBy(getHasName(ShiftedItems.shifted_gem), (has(ShiftedItems.shifted_gem))).save(output);
				shaped(RecipeCategory.COMBAT, ShiftedItems.shifted_boots, 1).pattern("i i").pattern("i g").define('g', ShiftedItems.shifted_gem).define('i', ShiftedItems.shifted_ingot).unlockedBy(getHasName(ShiftedItems.shifted_gem), (has(ShiftedItems.shifted_gem))).save(output);
				
				//Tools
				shaped(RecipeCategory.TOOLS, ShiftedItems.shifted_sword, 1).pattern("i").pattern("g").pattern("s").define('g', ShiftedItems.shifted_gem).define('i', ShiftedItems.shifted_ingot).define('s', ShiftedItems.shifted_rod).unlockedBy(getHasName(ShiftedItems.shifted_gem), (has(ShiftedItems.shifted_gem))).save(output);
				shaped(RecipeCategory.TOOLS, ShiftedItems.shifted_pickaxe, 1).pattern("iii").pattern(" g ").pattern(" s ").define('g', ShiftedItems.shifted_gem).define('i', ShiftedItems.shifted_ingot).define('s', ShiftedItems.shifted_rod).unlockedBy(getHasName(ShiftedItems.shifted_gem), (has(ShiftedItems.shifted_gem))).save(output);
				shaped(RecipeCategory.TOOLS, ShiftedItems.shifted_bucket, 1).pattern("i i").pattern(" i ").define('i', ShiftedItems.shifted_ingot).unlockedBy(getHasName(ShiftedItems.shifted_gem), (has(ShiftedItems.shifted_gem))).save(output);
				shaped(RecipeCategory.TOOLS, ShiftedItems.shrink_device, 1).pattern("g g").pattern(" g ").pattern("g g").define('g', ShiftedItems.shifted_gem).unlockedBy(getHasName(ShiftedItems.shifted_gem), (has(ShiftedItems.shifted_gem))).save(output);

				//Smelting
				oreSmelting(List.of(ShiftedItems.pure_shifted_dust), RecipeCategory.MISC, CookingBookCategory.MISC, ShiftedItems.shifted_nugget, 0.7f, 200, "dust_to_ingot");
			}
		};
	}

	@Override
	public String getName() {
		return "ShiftismRecipeProvider";
	}
}