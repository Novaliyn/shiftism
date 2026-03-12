package com.novaliyn.shiftism;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.*;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.*;
import net.minecraft.resources.Identifier;

import java.util.function.Function;

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

	public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, "creative_tab"));
	public static final CreativeModeTab CUSTOM_CREATIVE_TAB = FabricItemGroup.builder()
			.icon(() -> new ItemStack(ShiftedItems.miku_sword))
			.title(Component.translatable("itemGroup.shiftism"))
			.displayItems((params, output) -> {
				//Items
				output.accept(ShiftedItems.miku_ingot);
				output.accept(ShiftedItems.miku_sword);

				//Blocks
				output.accept(ShiftedBlocks.miku_block);
			})
			.build();

	static {
		// Register the group.
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_CREATIVE_TAB_KEY, CUSTOM_CREATIVE_TAB);
	}

	//Properties
	public static final FoodProperties ALWAYS_EAT = new FoodProperties.Builder().alwaysEdible().build();
	public static final Consumable SPEED_JUMP = Consumables.defaultFood().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 30 * 20, 1), 1.0f)).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, 30 * 20, 1), 1.0f)).build();
	public static final ToolMaterial MIKU_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3939, 8f, 9f, 39, null);

	//Create Items
	public static Item miku_ingot;
	public static Item miku_sword;

	// Initialize and Register
	public static void initialize() {
		miku_ingot = register("miku_ingot", Item::new, new Item.Properties().food(ALWAYS_EAT, SPEED_JUMP));
		miku_sword = register("miku_sword", Item::new, new Item.Properties().sword(MIKU_MATERIAL, 1f, 1f));
	}
}