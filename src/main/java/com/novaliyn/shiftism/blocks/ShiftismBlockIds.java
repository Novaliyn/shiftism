package com.novaliyn.shiftism.blocks;

import com.novaliyn.shiftism.Shiftism;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

public class ShiftismBlockIds {
	private static ResourceKey<Block> register(String name) {
		Identifier id = Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, name);
		return ResourceKey.create(Registries.BLOCK, id);
	}
}
