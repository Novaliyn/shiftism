package com.novaliyn.shiftism;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMikuMilk extends Item {
    
    @Override
    public ItemStack onItemRightClick(ItemStack interesingLiquid, World sekai, EntityPlayer miku) {
        miku.setItemInUse(interesingLiquid, this.getMaxItemUseDuration(interesingLiquid));
        return interesingLiquid;
    }

    @Override
    public ItemStack onEaten(ItemStack chewy, World evilSekai, EntityPlayer yandreMiku) {
        return new ItemStack(Shiftism.miku_bucket);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack mikuAndCheese) {
        return 32;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack freshMikuMilk) {
        return EnumAction.drink;
    }

    public ItemMikuMilk() {
        this.setMaxStackSize(1);
    }

}
