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
		builder(ShiftismItems.SHIFTED_REPAIR).add(ShiftismItems.SHIFTED_INGOT.builtInRegistryHolder().key()).setReplace(true);
		//helmet
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItems.SHIFTED_HELMET.builtInRegistryHolder().key());
		builder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftismItems.SHIFTED_HELMET.builtInRegistryHolder().key());
		builder(ItemTags.HEAD_ARMOR).add(ShiftismItems.SHIFTED_HELMET.builtInRegistryHolder().key());
		builder(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(ShiftismItems.SHIFTED_HELMET.builtInRegistryHolder().key());
		//chestplate
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItems.SHIFTED_CHESTPLATE.builtInRegistryHolder().key());
		builder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftismItems.SHIFTED_CHESTPLATE.builtInRegistryHolder().key());
		builder(ItemTags.CHEST_ARMOR).add(ShiftismItems.SHIFTED_CHESTPLATE.builtInRegistryHolder().key());
		builder(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(ShiftismItems.SHIFTED_CHESTPLATE.builtInRegistryHolder().key());
		//leggings
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItems.SHIFTED_LEGGINGS.builtInRegistryHolder().key());
		builder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftismItems.SHIFTED_LEGGINGS.builtInRegistryHolder().key());
		builder(ItemTags.LEG_ARMOR).add(ShiftismItems.SHIFTED_LEGGINGS.builtInRegistryHolder().key());
		builder(ItemTags.LEG_ARMOR_ENCHANTABLE).add(ShiftismItems.SHIFTED_LEGGINGS.builtInRegistryHolder().key());
		//boots
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItems.SHIFTED_BOOTS.builtInRegistryHolder().key());
		builder(ItemTags.ARMOR_ENCHANTABLE).add(ShiftismItems.SHIFTED_BOOTS.builtInRegistryHolder().key());
		builder(ItemTags.FOOT_ARMOR).add(ShiftismItems.SHIFTED_BOOTS.builtInRegistryHolder().key());
		builder(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(ShiftismItems.SHIFTED_BOOTS.builtInRegistryHolder().key());
		//pickaxe
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItems.SHIFTED_PICKAXE.builtInRegistryHolder().key());
		builder(ItemTags.MINING_ENCHANTABLE).add(ShiftismItems.SHIFTED_PICKAXE.builtInRegistryHolder().key());
		builder(ItemTags.PICKAXES).add(ShiftismItems.SHIFTED_PICKAXE.builtInRegistryHolder().key());
		//sword
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItems.SHIFTED_SWORD.builtInRegistryHolder().key());
		builder(ItemTags.WEAPON_ENCHANTABLE).add(ShiftismItems.SHIFTED_SWORD.builtInRegistryHolder().key());
		builder(ItemTags.SWORDS).add(ShiftismItems.SHIFTED_SWORD.builtInRegistryHolder().key());
		//axe
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItems.SHIFTED_AXE.builtInRegistryHolder().key());
		builder(ItemTags.MINING_ENCHANTABLE).add(ShiftismItems.SHIFTED_AXE.builtInRegistryHolder().key());
		builder(ItemTags.AXES).add(ShiftismItems.SHIFTED_AXE.builtInRegistryHolder().key());
		//shovel
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItems.SHIFTED_SHOVEL.builtInRegistryHolder().key());
		builder(ItemTags.MINING_ENCHANTABLE).add(ShiftismItems.SHIFTED_SHOVEL.builtInRegistryHolder().key());
		builder(ItemTags.SHOVELS).add(ShiftismItems.SHIFTED_SHOVEL.builtInRegistryHolder().key());
		//hoe
		builder(ItemTags.DURABILITY_ENCHANTABLE).add(ShiftismItems.SHIFTED_HOE.builtInRegistryHolder().key());
		builder(ItemTags.MINING_ENCHANTABLE).add(ShiftismItems.SHIFTED_HOE.builtInRegistryHolder().key());
		builder(ItemTags.HOES).add(ShiftismItems.SHIFTED_HOE.builtInRegistryHolder().key());
	}
}