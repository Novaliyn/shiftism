package com.novaliyn.shiftism.datagen;

import com.novaliyn.shiftism.blocks.ShiftismBlocks;
import com.novaliyn.shiftism.items.ShiftismItems;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.BlockModelGenerators.PlantType;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;

public class ShiftismModelProvider extends FabricModelProvider {
	public ShiftismModelProvider(FabricPackOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
		blockStateModelGenerator.createTrivialCube(ShiftismBlocks.SHIFTED_BLOCK);
		blockStateModelGenerator.createTrivialCube(ShiftismBlocks.SHIFTED_ORE);
		blockStateModelGenerator.createTrivialCube(ShiftismBlocks.TRANSGENDER_FLAG);
		blockStateModelGenerator.createTrivialCube(ShiftismBlocks.PRIDE_FLAG);
		blockStateModelGenerator.createRotatableColumn(ShiftismBlocks.SHIFTED_PEG);
		blockStateModelGenerator.createCrossBlockWithDefaultItem(ShiftismBlocks.NEBULITE_WEB, PlantType.NOT_TINTED);
	}

	@Override
	public void generateItemModels(ItemModelGenerators itemModelGenerator) {
		// Shifted
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_HELMET, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_CHESTPLATE, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_LEGGINGS, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_BOOTS, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.PURE_SHIFTED_DUST, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.IMPURE_SHIFTED_DUST, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_INGOT, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_NUGGET, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_BUCKET, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_BUCKET_OF_MILK, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.MYSTIC_APPLE, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHRINK_DEVICE, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_GEM, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.SHIFTED_ROD, ModelTemplates.FLAT_HANDHELD_ROD_ITEM);

		//Nebulite 
		itemModelGenerator.generateFlatItem(ShiftismItems.NEBULITE_VISOR, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.NEBULITE_CROP_TOP, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.NEBULITE_SKIRT, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.NEBULITE_PAWS, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.NEBULITE_ANNIHILATOR, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.NEBULITE_DECONSTRUCTOR, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.NEBULITE_TRUNCATER, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.NEBULITE_SPOON, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.NEBULITE_HARVESTER, ModelTemplates.FLAT_HANDHELD_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.NEBULITE_CHUNK, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ShiftismItems.NEBULITE_THREAD, ModelTemplates.FLAT_ITEM);
	}

	@Override
	public String getName() {
		return "ShiftismModelProvider";
	}
}
