package com.novaliyn.shiftism;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class ShiftedEvents {

    @SubscribeEvent
    public void onItemCrafted(ItemCraftedEvent event) {
        if (event.crafting.getItem() == Shiftism.miku_rod) {
            if (event.player.worldObj.rand.nextInt(5) == 0) {
                event.player.worldObj.createExplosion(event.player, event.player.posX, event.player.posY, event.player.posZ, 5.0f, true);
            }
        }
    }


}
