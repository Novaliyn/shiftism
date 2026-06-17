package com.novaliyn.shiftism.datagen;

import java.util.concurrent.CompletableFuture;

import com.novaliyn.shiftism.ShiftismItems;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

public class ShiftismTagsProvider extends FabricTagsProvider.ItemTagsProvider {
	public ShiftismTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider wrapperLookup) {
		builder(ShiftismItems.SHIFTED_REPAIR).add(ShiftismItems.shifted_ingot.builtInRegistryHolder().key()).setReplace(true);
		//helmet
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItems.shifted_helmet.builtInRegistryHolder().key());
		builder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftismItems.shifted_helmet.builtInRegistryHolder().key());
		builder(ItemTags.HEAD_ARMOR).add(ShiftismItems.shifted_helmet.builtInRegistryHolder().key());
		builder(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(ShiftismItems.shifted_helmet.builtInRegistryHolder().key());
		//chestplate
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItems.shifted_chestplate.builtInRegistryHolder().key());
		builder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftismItems.shifted_chestplate.builtInRegistryHolder().key());
		builder(ItemTags.CHEST_ARMOR).add(ShiftismItems.shifted_chestplate.builtInRegistryHolder().key());
		builder(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(ShiftismItems.shifted_chestplate.builtInRegistryHolder().key());
		//leggings
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItems.shifted_leggings.builtInRegistryHolder().key());
		builder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftismItems.shifted_leggings.builtInRegistryHolder().key());
		builder(ItemTags.LEG_ARMOR).add(ShiftismItems.shifted_leggings.builtInRegistryHolder().key());
		builder(ItemTags.LEG_ARMOR_ENCHANTABLE).add(ShiftismItems.shifted_leggings.builtInRegistryHolder().key());
		//boots
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItems.shifted_boots.builtInRegistryHolder().key());
		builder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftismItems.shifted_boots.builtInRegistryHolder().key());
		builder(ItemTags.FOOT_ARMOR).add(ShiftismItems.shifted_boots.builtInRegistryHolder().key());
		builder(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(ShiftismItems.shifted_boots.builtInRegistryHolder().key());
		//pickaxe
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItems.shifted_pickaxe.builtInRegistryHolder().key());
		builder(ItemTags.MINING_ENCHANTABLE).add(ShiftismItems.shifted_pickaxe.builtInRegistryHolder().key());
		builder(ItemTags.PICKAXES).add(ShiftismItems.shifted_pickaxe.builtInRegistryHolder().key());
		//sword
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItems.shifted_sword.builtInRegistryHolder().key());
		builder(ItemTags.WEAPON_ENCHANTABLE).add(ShiftismItems.shifted_sword.builtInRegistryHolder().key());
		builder(ItemTags.SWORDS).add(ShiftismItems.shifted_sword.builtInRegistryHolder().key());
		//axe
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItems.shifted_axe.builtInRegistryHolder().key());
		builder(ItemTags.MINING_ENCHANTABLE).add(ShiftismItems.shifted_axe.builtInRegistryHolder().key());
		builder(ItemTags.AXES).add(ShiftismItems.shifted_axe.builtInRegistryHolder().key());
		//shovel
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItems.shifted_shovel.builtInRegistryHolder().key());
		builder(ItemTags.MINING_ENCHANTABLE).add(ShiftismItems.shifted_shovel.builtInRegistryHolder().key());
		builder(ItemTags.SHOVELS).add(ShiftismItems.shifted_shovel.builtInRegistryHolder().key());
		//hoe
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItems.shifted_hoe.builtInRegistryHolder().key());
		builder(ItemTags.MINING_ENCHANTABLE).add(ShiftismItems.shifted_hoe.builtInRegistryHolder().key());
		builder(ItemTags.HOES).add(ShiftismItems.shifted_hoe.builtInRegistryHolder().key());
	}
}