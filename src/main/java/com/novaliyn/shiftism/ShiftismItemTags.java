package com.novaliyn.shiftism;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ShiftismItemTags {
    private static TagKey<Item> of(Identifier id) {
        return TagKey.create(Registries.ITEM, id);
    }

    private static TagKey<Item> of(String path) {
        return of(Shiftism.id(path));
    }
    
}
