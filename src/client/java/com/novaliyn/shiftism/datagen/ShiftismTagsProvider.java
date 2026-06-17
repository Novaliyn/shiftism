package com.novaliyn.shiftism.datagen;

import java.util.concurrent.CompletableFuture;

import com.novaliyn.shiftism.items.ShiftismItemIds;
import com.novaliyn.shiftism.items.ShiftismItems;

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
		builder(ShiftismItemIds.SHIFTED_REPAIR).add(ShiftismItemIds.SHIFTED_INGOT).setReplace(true);
		//helmet
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_HELMET);
		builder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_HELMET);
		builder(ItemTags.HEAD_ARMOR).add(ShiftismItemIds.SHIFTED_HELMET);
		builder(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_HELMET);
		//chestplate
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_CHESTPLATE);
		builder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_CHESTPLATE);
		builder(ItemTags.CHEST_ARMOR).add(ShiftismItemIds.SHIFTED_CHESTPLATE);
		builder(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_CHESTPLATE);
		//leggings
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_LEGGINGS);
		builder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_LEGGINGS);
		builder(ItemTags.LEG_ARMOR).add(ShiftismItemIds.SHIFTED_LEGGINGS);
		builder(ItemTags.LEG_ARMOR_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_LEGGINGS);
		//boots
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_BOOTS);
		builder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_BOOTS);
		builder(ItemTags.FOOT_ARMOR).add(ShiftismItemIds.SHIFTED_BOOTS);
		builder(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_BOOTS);
		//pickaxe
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_PICKAXE);
		builder(ItemTags.MINING_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_PICKAXE);
		builder(ItemTags.PICKAXES).add(ShiftismItemIds.SHIFTED_PICKAXE);
		//sword
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_SWORD);
		builder(ItemTags.WEAPON_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_SWORD);
		builder(ItemTags.SWORDS).add(ShiftismItemIds.SHIFTED_SWORD);
		//axe
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_AXE);
		builder(ItemTags.MINING_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_AXE);
		builder(ItemTags.AXES).add(ShiftismItemIds.SHIFTED_AXE);
		//shovel
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_SHOVEL);
		builder(ItemTags.MINING_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_SHOVEL);
		builder(ItemTags.SHOVELS).add(ShiftismItemIds.SHIFTED_SHOVEL);
		//hoe
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_HOE);
		builder(ItemTags.MINING_ENCHANTABLE).add(ShiftismItemIds.SHIFTED_HOE);
		builder(ItemTags.HOES).add(ShiftismItemIds.SHIFTED_HOE);
	}
}