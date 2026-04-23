package com.novaliyn.shiftism;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ShiftismModelProvider extends FabricModelProvider {
	public ShiftismModelProvider(FabricPackOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
		blockStateModelGenerator.createTrivialCube(ShiftedBlocks.shifted_block);
		blockStateModelGenerator.createTrivialCube(ShiftedBlocks.shifted_ore);
		blockStateModelGenerator.createTrivialCube(ShiftedBlocks.transgender_flag);
		blockStateModelGenerator.createTrivialCube(ShiftedBlocks.pride_flag);
	}

	@Override
	public void generateItemModels(ItemModelGenerators itemModelGenerator) {
		// Items
		itemModelGenerator.generateFlatItem(ShiftedItems.pure_shifted_dust, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.impure_shifted_dust, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.shifted_ingot, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.shifted_nugget, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.shifted_bucket, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.shifted_bucket_of_milk, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.mystic_apple, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.shrink_device, ModelTemplates.FLAT_ITEM);
		// Tools and armor
		itemModelGenerator.generateFlatItem(ShiftedItems.shifted_helmet, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.shifted_chestplate, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.shifted_leggings, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.shifted_boots, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.shifted_rod, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.shifted_sword, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.shifted_pickaxe, ModelTemplates.FLAT_HANDHELD_ITEM);
	}

	@Override
	public String getName() {
		return "ShiftismModelProvider";
	}
}
