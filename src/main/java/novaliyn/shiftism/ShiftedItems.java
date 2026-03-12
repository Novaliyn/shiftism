package novaliyn.shiftism;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.*;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
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

	//Properties
	public static final FoodProperties ALWAYS_EAT = new FoodProperties.Builder().alwaysEdible().build();
	public static final Consumable SPEED_JUMP = Consumables.defaultFood().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 30 * 20, 1), 1.0f)).build();


	//Registering Items
	public static Item shiftedTestObject;
	public static Block shiftedBrewingStand;

	public static void initialize() {
		shiftedTestObject = register("shifted_test_object", Item::new, new Item.Properties().food(ALWAYS_EAT, SPEED_JUMP));
	}
}