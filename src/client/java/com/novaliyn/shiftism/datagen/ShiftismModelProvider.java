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
		itemModelGenerator.generateFlatItem(ShiftismItems.PURE_SHIFTED_DUST, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.IMPURE_SHIFTED_DUST, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_INGOT, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_NUGGET, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_BUCKET, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_BUCKET_OF_MILK, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.MYSTIC_APPLE, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHRINK_DEVICE, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_GEM, ModelTemplates.FLAT_ITEM);
		// Tools and armor
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_HELMET, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_CHESTPLATE, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_LEGGINGS, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_BOOTS, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_ROD, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
	}

	@Override
	public String getName() {
		return "ShiftismModelProvider";
	}
}
