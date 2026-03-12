package com.novaliyn.shiftism;

import net.minecraft.core.Registry; 
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;

public class ShiftedBlocks {
	public static <T extends Block> T register(String name, Function<Block.Properties, T> blockFactory, Block.Properties settings) {
		// Create the block key.
		ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, name));
		// Create the block instance.
		T block = blockFactory.apply(settings.setId(blockKey));
		// Register the block.
		Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
		return block;
	}
}
