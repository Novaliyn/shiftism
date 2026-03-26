package com.novaliyn.shiftism;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.block.material.Material;

public class BlockMikuOre extends Block{
    public BlockMikuOre(Material m) {
        super(m);
        this.setHardness(5l);
        this.setResistance(5l);
        this.setHarvestLevel("pickaxe", 3);
    }

    @Override
    public Item getItemDropped(int crazy, Random cool, int bitch) {
        return Shiftism.impure_miku_dust;
    }

    @Override
    public int quantityDropped(Random pneumonoultramicroscopicsilicovolcanoconiosis) {
        return 1;
    }

}
