package com.novaliyn.shiftism.datagen;

import com.novaliyn.shiftism.ShiftismBlocks;
import com.novaliyn.shiftism.ShiftismItems;

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
		blockStateModelGenerator.createTrivialCube(ShiftismBlocks.shifted_block);
		blockStateModelGenerator.createTrivialCube(ShiftismBlocks.shifted_ore);
		blockStateModelGenerator.createTrivialCube(ShiftismBlocks.transgender_flag);
		blockStateModelGenerator.createTrivialCube(ShiftismBlocks.pride_flag);
		blockStateModelGenerator.createTrivialCube(ShiftismBlocks.shifted_peg);
	}

	@Override
	public void generateItemModels(ItemModelGenerators itemModelGenerator) {
		// Items
		itemModelGenerator.generateFlatItem(ShiftismItems.pure_shifted_dust, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.impure_shifted_dust, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.shifted_ingot, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.shifted_nugget, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.shifted_bucket, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.shifted_bucket_of_milk, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.mystic_apple, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.shrink_device, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.shifted_gem, ModelTemplates.FLAT_ITEM);
		// Tools and armor
		itemModelGenerator.generateFlatItem(ShiftismItems.shifted_helmet, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.shifted_chestplate, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.shifted_leggings, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.shifted_boots, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.shifted_rod, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.shifted_sword, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.shifted_pickaxe, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.shifted_axe, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.shifted_shovel, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.shifted_hoe, ModelTemplates.FLAT_HANDHELD_ITEM);
	}

	@Override
	public String getName() {
		return "ShiftismModelProvider";
	}
}
