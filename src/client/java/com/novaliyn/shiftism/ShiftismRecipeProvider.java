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
				shaped(RecipeCategory.MISC, ShiftedItems.shifted_ingot, 1).pattern("iii").pattern("iii").pattern("iii").define('i', ShiftedItems.shifted_nugget).unlockedBy(getHasName(ShiftedItems.shifted_nugget), (has(ShiftedItems.shifted_nugget))).save(output);
				shaped(RecipeCategory.MISC, ShiftedItems.shifted_rod, 1).pattern("i").pattern("i").define('i', ShiftedItems.shifted_ingot).unlockedBy(getHasName(ShiftedItems.shifted_ingot), (has(ShiftedItems.shifted_ingot))).save(output);
				shaped(RecipeCategory.MISC, ShiftedItems.shifted_bucket, 1).pattern("i i").pattern(" i ").define('i', ShiftedItems.shifted_ingot).unlockedBy(getHasName(ShiftedItems.shifted_ingot), (has(ShiftedItems.shifted_ingot))).save(output);
				shaped(RecipeCategory.MISC, ShiftedItems.mystic_apple, 1).pattern("iii").pattern("iei").pattern("iii").define('i', ShiftedItems.shifted_ingot).define('e', Items.GOLDEN_APPLE).unlockedBy(getHasName(ShiftedItems.shifted_ingot), (has(ShiftedItems.shifted_ingot))).save(output);

				//Blocks
				shaped(RecipeCategory.DECORATIONS, ShiftedBlocks.shifted_block, 1).pattern("iii").pattern("iii").pattern("iii").define('i', ShiftedItems.shifted_ingot).unlockedBy(getHasName(ShiftedItems.shifted_ingot), (has(ShiftedItems.shifted_ingot))).save(output);

				//Armor
				shaped(RecipeCategory.COMBAT, ShiftedItems.shifted_helmet, 1).pattern("iii").pattern("i i").define('i', ShiftedItems.shifted_ingot).unlockedBy(getHasName(ShiftedItems.shifted_ingot), (has(ShiftedItems.shifted_ingot))).save(output);
				shaped(RecipeCategory.COMBAT, ShiftedItems.shifted_chestplate, 1).pattern("i i").pattern("iii").pattern("iii").define('i', ShiftedItems.shifted_ingot).unlockedBy(getHasName(ShiftedItems.shifted_ingot), (has(ShiftedItems.shifted_ingot))).save(output);
				shaped(RecipeCategory.COMBAT, ShiftedItems.shifted_leggings, 1).pattern("iii").pattern("i i").pattern("i i").define('i', ShiftedItems.shifted_ingot).unlockedBy(getHasName(ShiftedItems.shifted_ingot), (has(ShiftedItems.shifted_ingot))).save(output);
				shaped(RecipeCategory.COMBAT, ShiftedItems.shifted_boots, 1).pattern("i i").pattern("i i").define('i', ShiftedItems.shifted_ingot).unlockedBy(getHasName(ShiftedItems.shifted_ingot), (has(ShiftedItems.shifted_ingot))).save(output);
				
				//Tools
				shaped(RecipeCategory.TOOLS, ShiftedItems.shifted_sword, 1).pattern("i").pattern("i").pattern("s").define('i', ShiftedItems.shifted_ingot).define('s', ShiftedItems.shifted_rod).unlockedBy(getHasName(ShiftedItems.shifted_ingot), (has(ShiftedItems.shifted_ingot))).save(output);
				shaped(RecipeCategory.TOOLS, ShiftedItems.shifted_pickaxe, 1).pattern("iii").pattern(" s ").pattern(" s ").define('i', ShiftedItems.shifted_ingot).define('s', ShiftedItems.shifted_rod).unlockedBy(getHasName(ShiftedItems.shifted_ingot), (has(ShiftedItems.shifted_ingot))).save(output);
			
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