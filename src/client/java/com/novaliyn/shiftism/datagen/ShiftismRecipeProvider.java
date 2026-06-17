package com.novaliyn.shiftism.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.novaliyn.shiftism.blocks.ShiftismBlocks;
import com.novaliyn.shiftism.items.ShiftismItems;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
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
				HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);
				//Crafting
				//items
				shapeless(RecipeCategory.MISC, ShiftismItems.SHIFTED_NUGGET, 9).requires(ShiftismItems.SHIFTED_INGOT).unlockedBy(getHasName(ShiftismItems.SHIFTED_INGOT), has(ShiftismItems.SHIFTED_INGOT)).save(output, "shifted_nuggets_from_ingot");
				shapeless(RecipeCategory.MISC, ShiftismItems.SHIFTED_INGOT, 9).requires(ShiftismBlocks.SHIFTED_BLOCK).unlockedBy(getHasName(ShiftismBlocks.SHIFTED_BLOCK), has(ShiftismBlocks.SHIFTED_BLOCK)).save(output, "shifted_ingots_from_block");
				shaped(RecipeCategory.MISC, ShiftismItems.SHIFTED_INGOT, 1).pattern("iii").pattern("iii").pattern("iii").define('i', ShiftismItems.SHIFTED_NUGGET).unlockedBy(getHasName(ShiftismItems.SHIFTED_NUGGET), (has(ShiftismItems.SHIFTED_NUGGET))).save(output);
				shaped(RecipeCategory.MISC, ShiftismItems.SHIFTED_ROD, 1).pattern("i").pattern("i").define('i', ShiftismItems.SHIFTED_INGOT).unlockedBy(getHasName(ShiftismItems.SHIFTED_INGOT), (has(ShiftismItems.SHIFTED_INGOT))).save(output);
				shaped(RecipeCategory.FOOD, ShiftismItems.MYSTIC_APPLE, 1).pattern("ini").pattern("nen").pattern("ini").define('n', ShiftismItems.SHIFTED_NUGGET).define('i', ShiftismItems.SHIFTED_INGOT).define('e', Items.ENCHANTED_GOLDEN_APPLE).unlockedBy(getHasName(ShiftismItems.SHIFTED_INGOT), (has(ShiftismItems.SHIFTED_INGOT))).save(output);
				shaped(RecipeCategory.MISC, ShiftismItems.SHIFTED_GEM, 1).pattern(" i ").pattern("iei").pattern(" i ").define('i', ShiftismItems.SHIFTED_INGOT).define('e', Items.DIAMOND_BLOCK).unlockedBy(getHasName(ShiftismItems.SHIFTED_INGOT), (has(ShiftismItems.SHIFTED_INGOT))).save(output);

				//Blocks
				shaped(RecipeCategory.DECORATIONS, ShiftismBlocks.SHIFTED_BLOCK, 1).pattern("iii").pattern("iii").pattern("iii").define('i', ShiftismItems.SHIFTED_INGOT).unlockedBy(getHasName(ShiftismItems.SHIFTED_INGOT), (has(ShiftismItems.SHIFTED_INGOT))).save(output);
				shapeless(RecipeCategory.DECORATIONS, ShiftismBlocks.TRANSGENDER_FLAG, 1).requires(ShiftismItems.SHIFTED_NUGGET).requires(Items.WOOL.lightBlue()).requires(Items.WOOL.pink()).unlockedBy(getHasName(ShiftismItems.SHIFTED_NUGGET), (has(ShiftismItems.SHIFTED_NUGGET))).save(output);
				shapeless(RecipeCategory.DECORATIONS, ShiftismBlocks.PRIDE_FLAG, 1).requires(ShiftismItems.SHIFTED_NUGGET).requires(Items.WOOL.red()).requires(Items.WOOL.green()).unlockedBy(getHasName(ShiftismItems.SHIFTED_NUGGET), (has(ShiftismItems.SHIFTED_NUGGET))).save(output);

				//Armor
				shaped(RecipeCategory.COMBAT, ShiftismItems.SHIFTED_HELMET, 1).pattern("igi").pattern("i i").define('g', ShiftismItems.SHIFTED_GEM).define('i', ShiftismItems.SHIFTED_INGOT).unlockedBy(getHasName(ShiftismItems.SHIFTED_GEM), (has(ShiftismItems.SHIFTED_GEM))).save(output);
				shaped(RecipeCategory.COMBAT, ShiftismItems.SHIFTED_CHESTPLATE, 1).pattern("i i").pattern("igi").pattern("iii").define('g', ShiftismItems.SHIFTED_GEM).define('i', ShiftismItems.SHIFTED_INGOT).unlockedBy(getHasName(ShiftismItems.SHIFTED_GEM), (has(ShiftismItems.SHIFTED_GEM))).save(output);
				shaped(RecipeCategory.COMBAT, ShiftismItems.SHIFTED_LEGGINGS, 1).pattern("igi").pattern("i i").pattern("i i").define('g', ShiftismItems.SHIFTED_GEM).define('i', ShiftismItems.SHIFTED_INGOT).unlockedBy(getHasName(ShiftismItems.SHIFTED_GEM), (has(ShiftismItems.SHIFTED_GEM))).save(output);
				shaped(RecipeCategory.COMBAT, ShiftismItems.SHIFTED_BOOTS, 1).pattern("i i").pattern("i g").define('g', ShiftismItems.SHIFTED_GEM).define('i', ShiftismItems.SHIFTED_INGOT).unlockedBy(getHasName(ShiftismItems.SHIFTED_GEM), (has(ShiftismItems.SHIFTED_GEM))).save(output);
				
				//Tools
				shaped(RecipeCategory.TOOLS, ShiftismItems.SHIFTED_SWORD, 1).pattern("i").pattern("g").pattern("s").define('g', ShiftismItems.SHIFTED_GEM).define('i', ShiftismItems.SHIFTED_INGOT).define('s', ShiftismItems.SHIFTED_ROD).unlockedBy(getHasName(ShiftismItems.SHIFTED_GEM), (has(ShiftismItems.SHIFTED_GEM))).save(output);
				shaped(RecipeCategory.TOOLS, ShiftismItems.SHIFTED_PICKAXE, 1).pattern("iii").pattern(" g ").pattern(" s ").define('g', ShiftismItems.SHIFTED_GEM).define('i', ShiftismItems.SHIFTED_INGOT).define('s', ShiftismItems.SHIFTED_ROD).unlockedBy(getHasName(ShiftismItems.SHIFTED_GEM), (has(ShiftismItems.SHIFTED_GEM))).save(output);
				shaped(RecipeCategory.TOOLS, ShiftismItems.SHIFTED_AXE, 1).pattern(" ii").pattern(" gi").pattern(" s ").define('g', ShiftismItems.SHIFTED_GEM).define('i', ShiftismItems.SHIFTED_INGOT).define('s', ShiftismItems.SHIFTED_ROD).unlockedBy(getHasName(ShiftismItems.SHIFTED_GEM), (has(ShiftismItems.SHIFTED_GEM))).save(output);
				shaped(RecipeCategory.TOOLS, ShiftismItems.SHIFTED_SHOVEL, 1).pattern(" g ").pattern(" s ").pattern(" s ").define('g', ShiftismItems.SHIFTED_GEM).define('s', ShiftismItems.SHIFTED_ROD).unlockedBy(getHasName(ShiftismItems.SHIFTED_GEM), (has(ShiftismItems.SHIFTED_GEM))).save(output);
				shaped(RecipeCategory.TOOLS, ShiftismItems.SHIFTED_HOE, 1).pattern("ii ").pattern(" g ").pattern(" s ").define('g', ShiftismItems.SHIFTED_GEM).define('i', ShiftismItems.SHIFTED_INGOT).define('s', ShiftismItems.SHIFTED_ROD).unlockedBy(getHasName(ShiftismItems.SHIFTED_GEM), (has(ShiftismItems.SHIFTED_GEM))).save(output);
				shaped(RecipeCategory.TOOLS, ShiftismItems.SHIFTED_BUCKET, 1).pattern("i i").pattern(" i ").define('i', ShiftismItems.SHIFTED_INGOT).unlockedBy(getHasName(ShiftismItems.SHIFTED_GEM), (has(ShiftismItems.SHIFTED_GEM))).save(output);
				shaped(RecipeCategory.TOOLS, ShiftismItems.SHRINK_DEVICE, 1).pattern("g g").pattern(" g ").pattern("g g").define('g', ShiftismItems.SHIFTED_GEM).unlockedBy(getHasName(ShiftismItems.SHIFTED_GEM), (has(ShiftismItems.SHIFTED_GEM))).save(output);

				//Smelting
				oreSmelting(List.of(ShiftismItems.PURE_SHIFTED_DUST), RecipeCategory.MISC, CookingBookCategory.MISC, ShiftismItems.SHIFTED_NUGGET, 0.7f, 200, "dust_to_ingot");
			}
		};
	}

	@Override
	public String getName() {
		return "ShiftismRecipeProvider";
	}
}