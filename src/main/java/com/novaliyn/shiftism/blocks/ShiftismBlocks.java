package com.novaliyn.shiftism.blocks;

import net.minecraft.core.Registry; 
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;


import java.util.function.Function;

import com.novaliyn.shiftism.Shiftism;

public class ShiftismBlocks {
	private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
		// Create a registry key for the block
		ResourceKey<Block> blockKey = keyOfBlock(name);
		// Create the block instance
		Block block = blockFactory.apply(settings.setId(blockKey));

		// Sometimes, you may not want to register an item for the block.
		// Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
		if (shouldRegisterItem) {
			// Items need to be registered with a different type of registry key, but the ID
			// can be the same.
			ResourceKey<Item> itemKey = keyOfItem(name);

			BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
			Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
		}

		return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
	}

	private static ResourceKey<Block> keyOfBlock(String name) {
		return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, name));
	}

	private static ResourceKey<Item> keyOfItem(String name) {
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, name));
	}

	// Create Blocks
	public static Block SHIFTED_ORE;
	public static Block SHIFTED_BLOCK;
	public static Block PRIDE_FLAG;
	public static Block TRANSGENDER_FLAG;
	public static Block SHIFTED_PEG;

	// Initialize and Register
	public static void initialize() {
		SHIFTED_ORE = register("shifted_ore", Block::new, BlockBehaviour.Properties.of().strength(39, 1200), true);
		SHIFTED_BLOCK = register("shifted_block", Block::new, BlockBehaviour.Properties.of(), true);
		PRIDE_FLAG = register("pride_flag", Block::new, BlockBehaviour.Properties.of(), true);
		TRANSGENDER_FLAG = register("transgender_flag", Block::new, BlockBehaviour.Properties.of(), true);
		SHIFTED_PEG = register("shifted_peg", ShiftedPeg::new, BlockBehaviour.Properties.of(), true);
	}

}