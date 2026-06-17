package com.novaliyn.shiftism.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.novaliyn.shiftism.ShiftismBlocks;
import com.novaliyn.shiftism.ShiftismItems;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;

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
				//Crafting
				//items
				shapeless(RecipeCategory.MISC, ShiftismItems.shifted_nugget, 9).requires(ShiftismItems.shifted_ingot).unlockedBy(getHasName(ShiftismItems.shifted_ingot), has(ShiftismItems.shifted_ingot)).save(output, "shifted_nuggets_from_ingot");
				shapeless(RecipeCategory.MISC, ShiftismItems.shifted_ingot, 9).requires(ShiftismBlocks.shifted_block).unlockedBy(getHasName(ShiftismBlocks.shifted_block), has(ShiftismBlocks.shifted_block)).save(output, "shifted_ingots_from_block");
				shaped(RecipeCategory.MISC, ShiftismItems.shifted_ingot, 1).pattern("iii").pattern("iii").pattern("iii").define('i', ShiftismItems.shifted_nugget).unlockedBy(getHasName(ShiftismItems.shifted_nugget), (has(ShiftismItems.shifted_nugget))).save(output);
				shaped(RecipeCategory.MISC, ShiftismItems.shifted_rod, 1).pattern("i").pattern("i").define('i', ShiftismItems.shifted_ingot).unlockedBy(getHasName(ShiftismItems.shifted_ingot), (has(ShiftismItems.shifted_ingot))).save(output);
				shaped(RecipeCategory.FOOD, ShiftismItems.mystic_apple, 1).pattern("ini").pattern("nen").pattern("ini").define('n', ShiftismItems.shifted_nugget).define('i', ShiftismItems.shifted_ingot).define('e', Items.ENCHANTED_GOLDEN_APPLE).unlockedBy(getHasName(ShiftismItems.shifted_ingot), (has(ShiftismItems.shifted_ingot))).save(output);
				shaped(RecipeCategory.MISC, ShiftismItems.shifted_gem, 1).pattern(" i ").pattern("iei").pattern(" i ").define('i', ShiftismItems.shifted_ingot).define('e', Items.DIAMOND_BLOCK).unlockedBy(getHasName(ShiftismItems.shifted_ingot), (has(ShiftismItems.shifted_ingot))).save(output);

				//Blocks
				shaped(RecipeCategory.DECORATIONS, ShiftismBlocks.shifted_block, 1).pattern("iii").pattern("iii").pattern("iii").define('i', ShiftismItems.shifted_ingot).unlockedBy(getHasName(ShiftismItems.shifted_ingot), (has(ShiftismItems.shifted_ingot))).save(output);
				shapeless(RecipeCategory.DECORATIONS, ShiftismBlocks.transgender_flag, 1).requires(ShiftismItems.shifted_nugget).requires(Items.WOOL.lightBlue()).requires(Items.WOOL.pink()).unlockedBy(getHasName(ShiftismItems.shifted_nugget), (has(ShiftismItems.shifted_nugget))).save(output);
				shapeless(RecipeCategory.DECORATIONS, ShiftismBlocks.pride_flag, 1).requires(ShiftismItems.shifted_nugget).requires(Items.WOOL.red()).requires(Items.WOOL.green()).unlockedBy(getHasName(ShiftismItems.shifted_nugget), (has(ShiftismItems.shifted_nugget))).save(output);

				//Armor
				shaped(RecipeCategory.COMBAT, ShiftismItems.shifted_helmet, 1).pattern("igi").pattern("i i").define('g', ShiftismItems.shifted_gem).define('i', ShiftismItems.shifted_ingot).unlockedBy(getHasName(ShiftismItems.shifted_gem), (has(ShiftismItems.shifted_gem))).save(output);
				shaped(RecipeCategory.COMBAT, ShiftismItems.shifted_chestplate, 1).pattern("i i").pattern("igi").pattern("iii").define('g', ShiftismItems.shifted_gem).define('i', ShiftismItems.shifted_ingot).unlockedBy(getHasName(ShiftismItems.shifted_gem), (has(ShiftismItems.shifted_gem))).save(output);
				shaped(RecipeCategory.COMBAT, ShiftismItems.shifted_leggings, 1).pattern("igi").pattern("i i").pattern("i i").define('g', ShiftismItems.shifted_gem).define('i', ShiftismItems.shifted_ingot).unlockedBy(getHasName(ShiftismItems.shifted_gem), (has(ShiftismItems.shifted_gem))).save(output);
				shaped(RecipeCategory.COMBAT, ShiftismItems.shifted_boots, 1).pattern("i i").pattern("i g").define('g', ShiftismItems.shifted_gem).define('i', ShiftismItems.shifted_ingot).unlockedBy(getHasName(ShiftismItems.shifted_gem), (has(ShiftismItems.shifted_gem))).save(output);
				
				//Tools
				shaped(RecipeCategory.TOOLS, ShiftismItems.shifted_sword, 1).pattern("i").pattern("g").pattern("s").define('g', ShiftismItems.shifted_gem).define('i', ShiftismItems.shifted_ingot).define('s', ShiftismItems.shifted_rod).unlockedBy(getHasName(ShiftismItems.shifted_gem), (has(ShiftismItems.shifted_gem))).save(output);
				shaped(RecipeCategory.TOOLS, ShiftismItems.shifted_pickaxe, 1).pattern("iii").pattern(" g ").pattern(" s ").define('g', ShiftismItems.shifted_gem).define('i', ShiftismItems.shifted_ingot).define('s', ShiftismItems.shifted_rod).unlockedBy(getHasName(ShiftismItems.shifted_gem), (has(ShiftismItems.shifted_gem))).save(output);
				shaped(RecipeCategory.TOOLS, ShiftismItems.shifted_axe, 1).pattern(" ii").pattern(" gi").pattern(" s ").define('g', ShiftismItems.shifted_gem).define('i', ShiftismItems.shifted_ingot).define('s', ShiftismItems.shifted_rod).unlockedBy(getHasName(ShiftismItems.shifted_gem), (has(ShiftismItems.shifted_gem))).save(output);
				shaped(RecipeCategory.TOOLS, ShiftismItems.shifted_shovel, 1).pattern(" g ").pattern(" s ").pattern(" s ").define('g', ShiftismItems.shifted_gem).define('s', ShiftismItems.shifted_rod).unlockedBy(getHasName(ShiftismItems.shifted_gem), (has(ShiftismItems.shifted_gem))).save(output);
				shaped(RecipeCategory.TOOLS, ShiftismItems.shifted_hoe, 1).pattern("ii ").pattern(" g ").pattern(" s ").define('g', ShiftismItems.shifted_gem).define('i', ShiftismItems.shifted_ingot).define('s', ShiftismItems.shifted_rod).unlockedBy(getHasName(ShiftismItems.shifted_gem), (has(ShiftismItems.shifted_gem))).save(output);
				shaped(RecipeCategory.TOOLS, ShiftismItems.shifted_bucket, 1).pattern("i i").pattern(" i ").define('i', ShiftismItems.shifted_ingot).unlockedBy(getHasName(ShiftismItems.shifted_gem), (has(ShiftismItems.shifted_gem))).save(output);
				shaped(RecipeCategory.TOOLS, ShiftismItems.shrink_device, 1).pattern("g g").pattern(" g ").pattern("g g").define('g', ShiftismItems.shifted_gem).unlockedBy(getHasName(ShiftismItems.shifted_gem), (has(ShiftismItems.shifted_gem))).save(output);

				//Smelting
				oreSmelting(List.of(ShiftismItems.pure_shifted_dust), RecipeCategory.MISC, CookingBookCategory.MISC, ShiftismItems.shifted_nugget, 0.7f, 200, "dust_to_ingot");
			}
		};
	}

	@Override
	public String getName() {
		return "ShiftismRecipeProvider";
	}
}