package com.novaliyn.shiftism.items.nebulite;

import org.jspecify.annotations.Nullable;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Antimatter extends Item {
    public Antimatter(Properties settings) {
        super(settings);
    }
    
    @Override
	public void inventoryTick(final ItemStack itemStack, final ServerLevel level, final Entity owner, final @Nullable EquipmentSlot slot) {
	    if (!level.isClientSide()) {
            if (owner instanceof Player) {
                Player player = (Player) owner;
                player.hurtServer(level, player.damageSources().fellOutOfWorld(), 2f);
            }
        }
    }
}
