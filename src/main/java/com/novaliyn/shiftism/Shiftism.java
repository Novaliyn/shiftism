package com.novaliyn.shiftism;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Shiftism implements ModInitializer {
	public static final String MOD_ID = "shiftism";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ShiftedBlocks.initialize();
		ShiftedItems.initialize();

		LOGGER.info("OMG HAIII! Its me " + MOD_ID + "! I was made by Novaliyn!");
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Decoration.RAW_GENERATION, ShiftismPlacedFeatures.MIKU_ORE_PLACED_KEY);
	}
	
	
}