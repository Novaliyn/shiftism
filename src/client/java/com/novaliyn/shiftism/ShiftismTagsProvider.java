package com.novaliyn.shiftism;

import java.util.concurrent.CompletableFuture;

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
			/*valueLookupBuilder(ShiftedItems.SHIFTED_REPAIR).add(ShiftedItems.shifted_ingot).setReplace(true);
			//helmet
			valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftedItems.shifted_helmet);
			valueLookupBuilder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftedItems.shifted_helmet);
			valueLookupBuilder(ItemTags.HEAD_ARMOR).add(ShiftedItems.shifted_helmet);
			valueLookupBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(ShiftedItems.shifted_helmet);
			//chestplate
			valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftedItems.shifted_chestplate);
			valueLookupBuilder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftedItems.shifted_chestplate);
			valueLookupBuilder(ItemTags.CHEST_ARMOR).add(ShiftedItems.shifted_chestplate);
			valueLookupBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(ShiftedItems.shifted_chestplate);
			//leggings
			valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftedItems.shifted_leggings);
			valueLookupBuilder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftedItems.shifted_leggings);
			valueLookupBuilder(ItemTags.LEG_ARMOR).add(ShiftedItems.shifted_leggings);
			valueLookupBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE).add(ShiftedItems.shifted_leggings);
			//boots
			valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftedItems.shifted_boots);
			valueLookupBuilder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftedItems.shifted_boots);
			valueLookupBuilder(ItemTags.FOOT_ARMOR).add(ShiftedItems.shifted_boots);
			valueLookupBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(ShiftedItems.shifted_boots);
			//pickaxe
			valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftedItems.shifted_pickaxe);
			valueLookupBuilder(ItemTags.MINING_ENCHANTABLE).add(ShiftedItems.shifted_pickaxe);
			valueLookupBuilder(ItemTags.PICKAXES).add(ShiftedItems.shifted_pickaxe);
			//sword
			valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftedItems.shifted_sword);
			valueLookupBuilder(ItemTags.WEAPON_ENCHANTABLE).add(ShiftedItems.shifted_sword);
			valueLookupBuilder(ItemTags.SWORDS).add(ShiftedItems.shifted_sword);
			//axe
			valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftedItems.shifted_axe);
			valueLookupBuilder(ItemTags.MINING_ENCHANTABLE).add(ShiftedItems.shifted_axe);
			valueLookupBuilder(ItemTags.AXES).add(ShiftedItems.shifted_axe);
			//shovel
			valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftedItems.shifted_shovel);
			valueLookupBuilder(ItemTags.MINING_ENCHANTABLE).add(ShiftedItems.shifted_shovel);
			valueLookupBuilder(ItemTags.SHOVELS).add(ShiftedItems.shifted_shovel);
			//hoe
			valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftedItems.shifted_hoe);
			valueLookupBuilder(ItemTags.MINING_ENCHANTABLE).add(ShiftedItems.shifted_hoe);
			valueLookupBuilder(ItemTags.HOES).add(ShiftedItems.shifted_hoe);*/
	}
}