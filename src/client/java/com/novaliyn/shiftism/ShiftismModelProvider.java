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
		blockStateModelGenerator.createTrivialCube(ShiftedBlocks.miku_block);
		blockStateModelGenerator.createTrivialCube(ShiftedBlocks.miku_ore);
		blockStateModelGenerator.createTrivialCube(ShiftedBlocks.transgender_flag);
		blockStateModelGenerator.createTrivialCube(ShiftedBlocks.pride_flag);
	}

	@Override
	public void generateItemModels(ItemModelGenerators itemModelGenerator) {
		// Items
		itemModelGenerator.generateFlatItem(ShiftedItems.pure_miku_dust, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.impure_miku_dust, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.miku_ingot, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.miku_nugget, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.miku_bucket, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.miku_bucket_of_milk, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.mystic_apple, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.shrink_device, ModelTemplates.FLAT_ITEM);
		// Tools and armor
		itemModelGenerator.generateFlatItem(ShiftedItems.miku_helmet, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.miku_chestplate, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.miku_leggings, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.miku_boots, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.miku_rod, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.miku_sword, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftedItems.miku_pickaxe, ModelTemplates.FLAT_HANDHELD_ITEM);
	}

	@Override
	public String getName() {
		return "ShiftismModelProvider";
	}
}
