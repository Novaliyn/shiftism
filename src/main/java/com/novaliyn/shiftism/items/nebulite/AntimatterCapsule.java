package com.novaliyn.shiftism.items.nebulite;

import org.jspecify.annotations.Nullable;

import com.novaliyn.shiftism.items.ShiftismItems;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class AntimatterCapsule extends Item {
    public AntimatterCapsule(Properties settings) {
        super(settings);
    }

    @Override
	public void inventoryTick(final ItemStack itemStack, final ServerLevel level, final Entity owner, final @Nullable EquipmentSlot slot) {
	    if (!level.isClientSide()) {
            if (owner instanceof Player) {
                Player player = (Player) owner;
                if (player.tickCount % 20 == 0) {
                    itemStack.setDamageValue(itemStack.getDamageValue() +1);
                    if (itemStack.getDamageValue() >= 12) {
                        player.playSound(SoundEvents.PLAYER_DEATH, 1.0f, 2.0f);
                        int slotIndex = player.getInventory().findSlotMatchingItem(itemStack);
                            if (slotIndex != -1) {
                                player.getInventory().setItem(slotIndex, new ItemStack(ShiftismItems.NEBULITE_CHUNK));
                                }
                            
                    }
                }
            }
        }
    }

}
