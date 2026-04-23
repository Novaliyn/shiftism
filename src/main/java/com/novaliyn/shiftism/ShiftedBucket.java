package com.novaliyn.shiftism;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.cow.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

public class ShiftedBucket extends Item {

    public ShiftedBucket(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if (entity instanceof Cow cow && !cow.isBaby()) {
            player.level().playSound(player, player.getX(), player.getY(), player.getZ(), 
                SoundEvents.COW_MILK, SoundSource.PLAYERS, 1.0F, 1.0F);

            ItemStack milkStack = new ItemStack(ShiftedItems.shifted_bucket_of_milk);

            if (stack.getCount() > 1) {
                ItemStack resultStack = ItemUtils.createFilledResult(stack, player, milkStack);
                if (!player.level().isClientSide()) {
                    player.setItemInHand(hand, resultStack);
                    System.out.println(resultStack);
                    }
                } else if (stack.getCount() == 1) {
                    if (!player.isCreative()) {
                        player.setItemInHand(hand, milkStack);
                    } else {
                        player.addItem(milkStack);
                    }
                }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}