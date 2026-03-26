package com.novaliyn.shiftism;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMikuDust extends ItemShiftism {

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float dx, float dy, float dz) {
    if (!world.isRemote) {
        if (world.getBlock(x, y, z) == Blocks.glowstone) {
            world.func_147480_a(x, y, z, false);
              world.spawnEntityInWorld(new EntityItem(world, x + 0.5, y, z + 0.5, new ItemStack(Shiftism.pure_miku_dust)));
               if (!player.capabilities.isCreativeMode) {
                    stack.stackSize--;
               }
               return true;
            }
            return false;
        }
        return false;
    }
}
