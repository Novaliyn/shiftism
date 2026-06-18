package com.novaliyn.shiftism.items;

import com.novaliyn.shiftism.Shiftism;

import io.netty.util.ResourceLeakException;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ShiftismItemIds {
    public static ResourceKey<Item> register(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, name));
    }
    public static final TagKey<Item> SHIFTED_REPAIR = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, "shifted_repair"));
    public static final TagKey<Item> NEBULITE_REPAIR = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, "nebulite_repair"));


    //Shifted
    public static final ResourceKey<Item> SHIFTED_HELMET = register("shifted_helmet");
    public static final ResourceKey<Item> SHIFTED_CHESTPLATE = register("shifted_chestplate");
    public static final ResourceKey<Item> SHIFTED_LEGGINGS = register("shifted_leggings");
    public static final ResourceKey<Item> SHIFTED_BOOTS = register("shifted_boots");
    public static final ResourceKey<Item> SHIFTED_SWORD = register("shifted_sword");
    public static final ResourceKey<Item> SHIFTED_PICKAXE = register("shifted_pickaxe");
    public static final ResourceKey<Item> SHIFTED_AXE = register("shifted_axe");
    public static final ResourceKey<Item> SHIFTED_SHOVEL = register("shifted_shovel");
    public static final ResourceKey<Item> SHIFTED_HOE = register("shifted_hoe");
    public static final ResourceKey<Item> IMPURE_SHIFTED_DUST = register("impure_shifted_dust");
    public static final ResourceKey<Item> PURE_SHIFTED_DUST = register("pure_shifted_dust");
    public static final ResourceKey<Item> SHIFTED_NUGGET = register("shifted_nugget");
    public static final ResourceKey<Item> SHIFTED_INGOT = register("shifted_ingot");
    public static final ResourceKey<Item> SHIFTED_ROD = register("shifted_rod");
    public static final ResourceKey<Item> SHIFTED_GEM = register("shifted_gem");
    public static final ResourceKey<Item> SHIFTED_BUCKET = register("shifted_bucket");
    public static final ResourceKey<Item> SHIFTED_BUCKET_OF_MILK = register("shifted_bucket_of_milk");
    public static final ResourceKey<Item> MYSTIC_APPLE = register("mystic_apple");
    public static final ResourceKey<Item> SHRINK_DEVICE = register("shrink_device");
    //Nebulite
    public static final ResourceKey<Item> NEBULITE_VISOR = register("nebulite_visor");
    public static final ResourceKey<Item> NEBULITE_CROP_TOP = register("nebulite_crop_top");
    public static final ResourceKey<Item> NEBULITE_SKIRT = register("nebulite_skirt");
    public static final ResourceKey<Item> NEBULITE_PAWS = register("nebulite_paws");
    public static final ResourceKey<Item> NEBULITE_ANNIHILATOR = register("nebulite_annihilator");
    public static final ResourceKey<Item> NEBULITE_DECONSTRUCTOR = register("nebulite_deconstructor");
    public static final ResourceKey<Item> NEBULITE_TRUNCATER = register("nebulite_truncater");
    public static final ResourceKey<Item> NEBULITE_SPOON = register("nebulite_spoon");
    public static final ResourceKey<Item> NEBULITE_HARVESTER = register("nebulite_harvester");

}
