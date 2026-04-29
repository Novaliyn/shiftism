package com.novaliyn.shiftism;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Blocks;

public class ShiftedDust extends Item {
    public ShiftedDust(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!context.getLevel().isClientSide()) {
            if (context.getLevel().getBlockState(context.getClickedPos()).getBlock() == Blocks.GLOWSTONE) {
                context.getLevel().destroyBlock(context.getClickedPos(), false, context.getPlayer());
                ItemStack heldStack = context.getItemInHand();
                if (!context.getPlayer().isCreative()) {
                    heldStack.setCount(heldStack.getCount() - 1);
                }
                context.getLevel().addFreshEntity(new ItemEntity(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), new ItemStack(ShiftedItems.pure_shifted_dust)));
            }
        }
        return super.useOn(context);
    }

}
