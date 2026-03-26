package com.novaliyn.shiftism;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMikuBucket extends Item {
    
    @Override
    public boolean itemInteractionForEntity(ItemStack stacky, EntityPlayer foxy, EntityLivingBase supertarget) {
        if (!foxy.worldObj.isRemote) {
            if (supertarget instanceof EntityCow) {
               if (!foxy.capabilities.isCreativeMode) {
                    stacky.stackSize--;
               }
               foxy.inventory.addItemStackToInventory(new ItemStack(Shiftism.miku_milk));
               return true;
            }
            return false;
        }
        return false;
    }
}
