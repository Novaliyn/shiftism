package com.novaliyn.shiftism.items;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;

import com.novaliyn.shiftism.Shiftism;
import com.novaliyn.shiftism.blocks.ShiftismBlocks;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
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

public class ShiftismItems {
	public static <T extends Item> T register(ResourceKey<Item> itemKey, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
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
	public static final TagKey<Block> INCORRECT_FOR_SHIFTED_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, "incorrect_for_shifted_tool"));
	public static final ToolMaterial SHIFTED_MATERIAL = new ToolMaterial(INCORRECT_FOR_SHIFTED_TOOL, 3939, 10f, 9f, 22, SHIFTED_REPAIR);
	public static final int SHIFTED_BASE_DURABILITY = 250;
	public static final ResourceKey<EquipmentAsset> SHIFTED_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, "shifted"));
	public static final ArmorMaterial SHIFTED_ARMOR_MATERIAL = new ArmorMaterial(SHIFTED_BASE_DURABILITY, Map.of(ArmorType.HELMET, 3, ArmorType.CHESTPLATE, 9, ArmorType.LEGGINGS, 9, ArmorType.BOOTS, 3), 9, SoundEvents.ARMOR_EQUIP_NETHERITE, 0.0f, 0.0f, SHIFTED_REPAIR, SHIFTED_ARMOR_MATERIAL_KEY);

	//Create Items
	public static final Item IMPURE_SHIFTED_DUST = register(ShiftismItemIds.IMPURE_SHIFTED_DUST, ShiftedDust::new, new Item.Properties());	
	public static final Item PURE_SHIFTED_DUST = register(ShiftismItemIds.PURE_SHIFTED_DUST, Item::new, new Item.Properties());
	public static final Item SHIFTED_NUGGET = register(ShiftismItemIds.SHIFTED_NUGGET, Item::new, new Item.Properties());
	public static final Item SHIFTED_INGOT = register(ShiftismItemIds.SHIFTED_INGOT, Item::new, new Item.Properties());	
	public static final Item SHIFTED_GEM = register(ShiftismItemIds.SHIFTED_GEM, Item::new, new Item.Properties());
	public static final Item SHIFTED_ROD = register(ShiftismItemIds.SHIFTED_ROD, Item::new, new Item.Properties());
	public static final Item SHIFTED_SWORD = register(ShiftismItemIds.SHIFTED_SWORD, ShiftedSword::new, new Item.Properties().sword(SHIFTED_MATERIAL, 1f, 1f));
	public static final Item SHIFTED_PICKAXE = register(ShiftismItemIds.SHIFTED_PICKAXE, ShiftedPickaxe::new, new Item.Properties().pickaxe(SHIFTED_MATERIAL, -5f, -2f));
	public static final Item SHIFTED_AXE = register(ShiftismItemIds.SHIFTED_AXE, ShiftedAxe::new, new Item.Properties().axe(SHIFTED_MATERIAL, -5f, -2f));
	public static final Item SHIFTED_SHOVEL = register(ShiftismItemIds.SHIFTED_SHOVEL, ShiftedShovel::new, new Item.Properties().shovel(SHIFTED_MATERIAL, -5f, -2f));
	public static final Item SHIFTED_HOE = register(ShiftismItemIds.SHIFTED_HOE, ShiftedHoe::new, new Item.Properties().hoe(SHIFTED_MATERIAL, -5f, -2f));
	public static final Item SHIFTED_BUCKET = register(ShiftismItemIds.SHIFTED_BUCKET, ShiftedBucket::new, new Item.Properties());
	public static final Item SHIFTED_BUCKET_OF_MILK = register(ShiftismItemIds.SHIFTED_BUCKET_OF_MILK, Item::new, new Item.Properties().food(ALWAYS_EAT).stacksTo(1));
	public static final Item SHIFTED_HELMET = register(ShiftismItemIds.SHIFTED_HELMET, Item::new, new Item.Properties().humanoidArmor(SHIFTED_ARMOR_MATERIAL, ArmorType.HELMET).durability(ArmorType.HELMET.getDurability(SHIFTED_BASE_DURABILITY)));
	public static final Item SHIFTED_CHESTPLATE = register(ShiftismItemIds.SHIFTED_CHESTPLATE, Item::new, new Item.Properties().humanoidArmor(SHIFTED_ARMOR_MATERIAL, ArmorType.CHESTPLATE).durability(ArmorType.CHESTPLATE.getDurability(SHIFTED_BASE_DURABILITY)));
	public static final Item SHIFTED_LEGGINGS = register(ShiftismItemIds.SHIFTED_LEGGINGS, Item::new, new Item.Properties().humanoidArmor(SHIFTED_ARMOR_MATERIAL, ArmorType.LEGGINGS).durability(ArmorType.LEGGINGS.getDurability(SHIFTED_BASE_DURABILITY)));
	public static final Item SHIFTED_BOOTS = register(ShiftismItemIds.SHIFTED_BOOTS, Item::new, new Item.Properties());
	public static final Item MYSTIC_APPLE = register(ShiftismItemIds.MYSTIC_APPLE, Item::new, new Item.Properties().food(ALWAYS_EAT, SPEED_JUMP));
	public static final Item SHRINK_DEVICE = register(ShiftismItemIds.SHRINK_DEVICE, ShiftedShrinkDevice::new, new Item.Properties().humanoidArmor(SHIFTED_ARMOR_MATERIAL, ArmorType.BOOTS).durability(ArmorType.BOOTS.getDurability(SHIFTED_BASE_DURABILITY)));
	// Initialize and Register
	public static void initialize() {

		//Add to Creative Tab
		for (Field f : ShiftismItems.class.getDeclaredFields()) {
			try {
				if (f.getType() == Item.class) {
					shiftedItemsList.add((Item) f.get(null));
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (Field f : ShiftismBlocks.class.getDeclaredFields()) {
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
			.icon(() -> new ItemStack(ShiftismItems.SHIFTED_SWORD))
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