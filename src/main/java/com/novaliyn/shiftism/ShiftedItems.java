package com.novaliyn.shiftism;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.function.Function;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
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
	public static final TagKey<Item> MIKU_REPAIR = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, "miku_repair"));
	public static final ToolMaterial MIKU_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3939, 8f, 9f, 39, ShiftedItems.MIKU_REPAIR);

	//Create Items
	public static Item impure_miku_dust;
	public static Item pure_miku_dust;
	public static Item miku_nugget;
	public static Item miku_ingot;
	public static Item miku_rod;
	public static Item miku_sword;
	public static Item miku_bucket;
	public static Item miku_milk;

	// Initialize and Register
	public static void initialize() {
		impure_miku_dust = register("impure_miku_dust", ShiftedMikuDust::new, new Item.Properties());
		pure_miku_dust = register("pure_miku_dust", Item::new, new Item.Properties());
		miku_nugget = register("miku_nugget", Item::new, new Item.Properties());
		miku_ingot = register("miku_ingot", Item::new, new Item.Properties().food(ALWAYS_EAT, SPEED_JUMP));
		miku_rod = register("miku_rod", Item::new, new Item.Properties());
		miku_sword = register("miku_sword", Item::new, new Item.Properties().sword(MIKU_MATERIAL, 1f, 1f));
		miku_bucket = register("miku_bucket", ShiftedMikuBucket::new, new Item.Properties());
		miku_milk = register("miku_milk", Item::new, new Item.Properties());

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
	public static final CreativeModeTab CUSTOM_CREATIVE_TAB = FabricItemGroup.builder()
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