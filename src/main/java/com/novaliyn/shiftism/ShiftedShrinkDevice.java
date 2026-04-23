package com.novaliyn.shiftism;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ShiftedShrinkDevice extends Item {
    public ShiftedShrinkDevice(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide()) {
            var scaleAttribute = player.getAttribute(Attributes.SCALE);
            if (scaleAttribute != null) {
                double currentScale = scaleAttribute.getBaseValue();
                double newScale = (currentScale > 0.5) ? 0.25 : 1.0;
                scaleAttribute.setBaseValue(newScale);
            }
        }
        if (itemStack.getCount() > 1) {
            if (!player.isCreative()) {
                itemStack.shrink(1);
            }
        } else if (itemStack.getCount() == 1) {
            if (!player.isCreative()) {
                player.setItemInHand(hand, ItemStack.EMPTY);
            }
        }

        return InteractionResult.SUCCESS.heldItemTransformedTo(player.getItemInHand(hand));
    }
}