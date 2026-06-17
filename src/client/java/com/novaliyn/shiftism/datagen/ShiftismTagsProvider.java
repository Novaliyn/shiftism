package com.novaliyn.shiftism.datagen;

import java.util.concurrent.CompletableFuture;

import com.novaliyn.shiftism.ShiftedItems;

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
		builder(ShiftedItems.SHIFTED_REPAIR).add(ShiftedItems.shifted_ingot.builtInRegistryHolder().key()).setReplace(true);
		//helmet
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftedItems.shifted_helmet.builtInRegistryHolder().key());
		builder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftedItems.shifted_helmet.builtInRegistryHolder().key());
		builder(ItemTags.HEAD_ARMOR).add(ShiftedItems.shifted_helmet.builtInRegistryHolder().key());
		builder(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(ShiftedItems.shifted_helmet.builtInRegistryHolder().key());
		//chestplate
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftedItems.shifted_chestplate.builtInRegistryHolder().key());
		builder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftedItems.shifted_chestplate.builtInRegistryHolder().key());
		builder(ItemTags.CHEST_ARMOR).add(ShiftedItems.shifted_chestplate.builtInRegistryHolder().key());
		builder(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(ShiftedItems.shifted_chestplate.builtInRegistryHolder().key());
		//leggings
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftedItems.shifted_leggings.builtInRegistryHolder().key());
		builder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftedItems.shifted_leggings.builtInRegistryHolder().key());
		builder(ItemTags.LEG_ARMOR).add(ShiftedItems.shifted_leggings.builtInRegistryHolder().key());
		builder(ItemTags.LEG_ARMOR_ENCHANTABLE).add(ShiftedItems.shifted_leggings.builtInRegistryHolder().key());
		//boots
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftedItems.shifted_boots.builtInRegistryHolder().key());
		builder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftedItems.shifted_boots.builtInRegistryHolder().key());
		builder(ItemTags.FOOT_ARMOR).add(ShiftedItems.shifted_boots.builtInRegistryHolder().key());
		builder(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(ShiftedItems.shifted_boots.builtInRegistryHolder().key());
		//pickaxe
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftedItems.shifted_pickaxe.builtInRegistryHolder().key());
		builder(ItemTags.MINING_ENCHANTABLE).add(ShiftedItems.shifted_pickaxe.builtInRegistryHolder().key());
		builder(ItemTags.PICKAXES).add(ShiftedItems.shifted_pickaxe.builtInRegistryHolder().key());
		//sword
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftedItems.shifted_sword.builtInRegistryHolder().key());
		builder(ItemTags.WEAPON_ENCHANTABLE).add(ShiftedItems.shifted_sword.builtInRegistryHolder().key());
		builder(ItemTags.SWORDS).add(ShiftedItems.shifted_sword.builtInRegistryHolder().key());
		//axe
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftedItems.shifted_axe.builtInRegistryHolder().key());
		builder(ItemTags.MINING_ENCHANTABLE).add(ShiftedItems.shifted_axe.builtInRegistryHolder().key());
		builder(ItemTags.AXES).add(ShiftedItems.shifted_axe.builtInRegistryHolder().key());
		//shovel
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftedItems.shifted_shovel.builtInRegistryHolder().key());
		builder(ItemTags.MINING_ENCHANTABLE).add(ShiftedItems.shifted_shovel.builtInRegistryHolder().key());
		builder(ItemTags.SHOVELS).add(ShiftedItems.shifted_shovel.builtInRegistryHolder().key());
		//hoe
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftedItems.shifted_hoe.builtInRegistryHolder().key());
		builder(ItemTags.MINING_ENCHANTABLE).add(ShiftedItems.shifted_hoe.builtInRegistryHolder().key());
		builder(ItemTags.HOES).add(ShiftedItems.shifted_hoe.builtInRegistryHolder().key());
	}
}