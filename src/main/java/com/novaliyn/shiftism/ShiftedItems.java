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
	public static final TagKey<Item> SHIFTED_REPAIR = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, "shifted_repair"));
	public static final ToolMaterial SHIFTED_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3939, 10f, 9f, 22, SHIFTED_REPAIR);
	public static final int SHIFTED_BASE_DURABILITY = 250;
	public static final ResourceKey<EquipmentAsset> SHIFTED_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, "shifted"));
	public static final ArmorMaterial SHIFTED_ARMOR_MATERIAL = new ArmorMaterial(SHIFTED_BASE_DURABILITY, Map.of(ArmorType.HELMET, 3, ArmorType.CHESTPLATE, 9, ArmorType.LEGGINGS, 9, ArmorType.BOOTS, 3), 9, SoundEvents.ARMOR_EQUIP_NETHERITE, 0.0f, 0.0f, SHIFTED_REPAIR, SHIFTED_ARMOR_MATERIAL_KEY);

	//Create Items
	public static Item impure_shifted_dust;
	public static Item pure_shifted_dust;
	public static Item shifted_nugget;
	public static Item shifted_ingot;
	public static Item shifted_rod;
	public static Item shifted_sword;
	public static Item shifted_pickaxe;
	public static Item shifted_bucket;
	public static Item shifted_bucket_of_milk;
	public static Item shifted_helmet;
	public static Item shifted_chestplate;
	public static Item shifted_leggings;
	public static Item shifted_boots;
	public static Item mystic_apple;
	public static Item shrink_device;

	// Initialize and Register
	public static void initialize() {
		impure_shifted_dust = register("impure_shifted_dust", ShiftedDust::new, new Item.Properties());
		pure_shifted_dust = register("pure_shifted_dust", Item::new, new Item.Properties());
		shifted_nugget = register("shifted_nugget", Item::new, new Item.Properties());
		shifted_ingot = register("shifted_ingot", Item::new, new Item.Properties());
		shifted_rod = register("shifted_rod", Item::new, new Item.Properties());
		shifted_bucket_of_milk = register("shifted_bucket_of_milk", Item::new, new Item.Properties().food(ALWAYS_EAT).stacksTo(1));
		mystic_apple = register("mystic_apple", Item::new, new Item.Properties().food(ALWAYS_EAT, SPEED_JUMP));
		shrink_device = register("shrink_device", ShiftedShrinkDevice::new, new Item.Properties());

		//Tools
		shifted_sword = register("shifted_sword", Item::new, new Item.Properties().sword(SHIFTED_MATERIAL, 1f, 1f));
		shifted_pickaxe = register("shifted_pickaxe", ShiftedPickaxe::new, new Item.Properties().pickaxe(SHIFTED_MATERIAL, -5f, -2f));
		shifted_bucket = register("shifted_bucket", ShiftedBucket::new, new Item.Properties());

		//Armor
		shifted_helmet = register("shifted_helmet", Item::new, new Item.Properties().humanoidArmor(SHIFTED_ARMOR_MATERIAL, ArmorType.HELMET).durability(ArmorType.HELMET.getDurability(SHIFTED_BASE_DURABILITY)));
		shifted_chestplate = register("shifted_chestplate", Item::new, new Item.Properties().humanoidArmor(SHIFTED_ARMOR_MATERIAL, ArmorType.CHESTPLATE).durability(ArmorType.CHESTPLATE.getDurability(SHIFTED_BASE_DURABILITY)));
		shifted_leggings = register("shifted_leggings", Item::new, new Item.Properties().humanoidArmor(SHIFTED_ARMOR_MATERIAL, ArmorType.LEGGINGS).durability(ArmorType.LEGGINGS.getDurability(SHIFTED_BASE_DURABILITY)));
		shifted_boots = register("shifted_boots", Item::new, new Item.Properties().humanoidArmor(SHIFTED_ARMOR_MATERIAL, ArmorType.BOOTS).durability(ArmorType.BOOTS.getDurability(SHIFTED_BASE_DURABILITY)));

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
			.icon(() -> new ItemStack(ShiftedItems.shifted_sword))
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