package com.novaliyn.shiftism.blocks;

import net.minecraft.core.Registry; 
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;


import java.util.function.Function;

import com.novaliyn.shiftism.Shiftism;

public class ShiftismBlocks {
	private static Block register(ResourceKey<Block> id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
		// Create the block instance
		Block block = blockFactory.apply(properties.setId(id));
		return Registry.register(BuiltInRegistries.BLOCK, id, block);
	}

	private static Block register(BlockItemId id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
		// Create the block instance
		Block block = register(id.block(), blockFactory, properties);

		// Create the block item instance
		BlockItem blockItem = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(id.item()));
		Registry.register(BuiltInRegistries.ITEM, id.item(), blockItem);

		return block;
	}

	// Create Blocks
	public static final Block SHIFTED_ORE = register(ShiftismBlockItemIds.SHIFTED_ORE, Block::new, BlockBehaviour.Properties.of().strength(39, 12));
	public static final Block SHIFTED_BLOCK = register(ShiftismBlockItemIds.SHIFTED_BLOCK, Block::new, BlockBehaviour.Properties.of().strength(15, 12));
	public static final Block PRIDE_FLAG = register(ShiftismBlockItemIds.PRIDE_FLAG, Block::new, BlockBehaviour.Properties.of().strength(8, 8));
	public static final Block TRANSGENDER_FLAG = register(ShiftismBlockItemIds.TRANSGENDER_FLAG, Block::new, BlockBehaviour.Properties.of().strength(8, 8));
	public static final Block SHIFTED_PEG =  register(ShiftismBlockItemIds.SHIFTED_PEG, ShiftedPeg::new, BlockBehaviour.Properties.of().strength(9, 9).lightLevel(statex -> 14).noOcclusion());
	public static final Block NEBULITE_WEB = register(ShiftismBlockItemIds.NEBULITE_WEB, NebuliteWeb::new, BlockBehaviour.Properties.of().strength(20,12).forceSolidOn().noCollision());
	// Initialize and Register
	public static void initialize() {

	}
}