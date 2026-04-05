package com.novaliyn.shiftism;

import java.lang.reflect.Field;
import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;

import org.lwjgl.openal.AL;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public class ShiftedItems {
	public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
		// Create the item key.
		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, name));
		// Create the item instance.
		T item = itemFactory.apply(settings.setId(itemKey));
		// Register the item.
		Registry.register(BuiltInRegistries.ITEM, itemKey, item);
		return item;
	}


	//Creative Tab List
	public static ArrayList<Item> shiftedItemsList = new ArrayList<Item>();
	public static ArrayList<Block> shiftedBlocksList = new ArrayList<Block>();

	//Properties
	public static final FoodProperties ALWAYS_EAT = new FoodProperties.Builder().alwaysEdible().build();
	public static final Consumable SPEED_JUMP = Consumables.defaultFood().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 30 * 20, 1), 1.0f)).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, 30 * 20, 1), 1.0f)).build();

	//Armor and Tool Properties
	public static final TagKey<Item> MIKU_REPAIR = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, "miku_repair"));
	public static final ToolMaterial MIKU_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3939, 8f, 9f, 39, MIKU_REPAIR);
	public static final int MIKU_BASE_DURABILITY = 250;
	public static final ResourceKey<EquipmentAsset> MIKU_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, "miku"));
	public static final ArmorMaterial MIKU_ARMOR_MATERIAL = new ArmorMaterial(MIKU_BASE_DURABILITY, Map.of(ArmorType.HELMET, 3, ArmorType.CHESTPLATE, 9, ArmorType.LEGGINGS, 9, ArmorType.BOOTS, 3), 9, SoundEvents.ARMOR_EQUIP_NETHERITE, 0.0f, 0.0f, MIKU_REPAIR, MIKU_ARMOR_MATERIAL_KEY);

	//Create Items
	public static Item impure_miku_dust;
	public static Item pure_miku_dust;
	public static Item miku_nugget;
	public static Item miku_ingot;
	public static Item miku_rod;
	public static Item miku_sword;
	public static Item miku_pickaxe;
	public static Item miku_bucket;
	public static Item miku_bucket_of_milk;
	public static Item miku_helmet;
	public static Item miku_chestplate;
	public static Item miku_leggings;
	public static Item miku_boots;

	// Initialize and Register
	public static void initialize() {
		impure_miku_dust = register("impure_miku_dust", ShiftedMikuDust::new, new Item.Properties());
		pure_miku_dust = register("pure_miku_dust", Item::new, new Item.Properties());
		miku_nugget = register("miku_nugget", Item::new, new Item.Properties());
		miku_ingot = register("miku_ingot", Item::new, new Item.Properties().food(ALWAYS_EAT, SPEED_JUMP));
		miku_rod = register("miku_rod", Item::new, new Item.Properties());
		miku_bucket_of_milk = register("miku_bucket_of_milk", Item::new, new Item.Properties().food(ALWAYS_EAT).stacksTo(1));

		//Tools
		miku_sword = register("miku_sword", Item::new, new Item.Properties().sword(MIKU_MATERIAL, 1f, 1f));
		miku_pickaxe = register("miku_pickaxe", ShiftedMikuPickaxe::new, new Item.Properties().pickaxe(MIKU_MATERIAL, 1f, 1f));
		miku_bucket = register("miku_bucket", ShiftedMikuBucket::new, new Item.Properties());

		//Armor
		miku_helmet = register("miku_helmet", Item::new, new Item.Properties().humanoidArmor(MIKU_ARMOR_MATERIAL, ArmorType.HELMET).durability(ArmorType.HELMET.getDurability(MIKU_BASE_DURABILITY)));
		miku_chestplate = register("miku_chestplate", Item::new, new Item.Properties().humanoidArmor(MIKU_ARMOR_MATERIAL, ArmorType.CHESTPLATE).durability(ArmorType.CHESTPLATE.getDurability(MIKU_BASE_DURABILITY)));
		miku_leggings = register("miku_leggings", Item::new, new Item.Properties().humanoidArmor(MIKU_ARMOR_MATERIAL, ArmorType.LEGGINGS).durability(ArmorType.LEGGINGS.getDurability(MIKU_BASE_DURABILITY)));
		miku_boots = register("miku_boots", Item::new, new Item.Properties().humanoidArmor(MIKU_ARMOR_MATERIAL, ArmorType.BOOTS).durability(ArmorType.BOOTS.getDurability(MIKU_BASE_DURABILITY)));

		//Add to Creative Tab
		for (Field f : ShiftedItems.class.getDeclaredFields()) {
			try {
				if (f.getType() == Item.class) {
					shiftedItemsList.add((Item) f.get(null));
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (Field f : ShiftedBlocks.class.getDeclaredFields()) {
			try {
				if (f.getType() == Block.class) {
					shiftedBlocksList.add((Block) f.get(null));
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, "creative_tab"));
	public static final CreativeModeTab CUSTOM_CREATIVE_TAB = FabricCreativeModeTab.builder()
			.icon(() -> new ItemStack(ShiftedItems.miku_sword))
			.title(Component.translatable("itemGroup.shiftism"))
			.displayItems((params, output) -> {
				if (!shiftedItemsList.isEmpty()) {
					for (Item i : shiftedItemsList) {
						output.accept(i);
					}
				}
				if (!shiftedBlocksList.isEmpty()) {
					for (Block i : shiftedBlocksList) {
						output.accept(i);
					}
				}
			})
			.build();

	static {
		// Register the group.
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_CREATIVE_TAB_KEY, CUSTOM_CREATIVE_TAB);
	}

}