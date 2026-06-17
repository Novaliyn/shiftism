package com.novaliyn.shiftism.blocks;

import com.novaliyn.shiftism.Shiftism;

import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;

public class ShiftismBlockItemIds {
    private static BlockItemId register(String name) {
		Identifier id = Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, name);
		return BlockItemId.create(id, id);
	}

    public static final BlockItemId SHIFTED_ORE = register("shifted_ore");
    public static final BlockItemId SHIFTED_BLOCK = register("shifted_block");
    public static final BlockItemId PRIDE_FLAG = register("pride_flag");
    public static final BlockItemId TRANSGENDER_FLAG = register("transgender_flag");
    public static final BlockItemId SHIFTED_PEG = register("shifted_peg");
}