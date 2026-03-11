package novaliyn.shiftism;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.resources.Identifier;
import java.util.function.Function;

public class ShiftedItems {
	public static void initialize() {
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
		.register((itemGroup) -> itemGroup.accept(ShiftedItems.shiftedTestObject));
	}

	public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
		// Create the item key.
		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, name));
		// Create the item instance.
		T item = itemFactory.apply(settings.setId(itemKey));
		// Register the item.
		Registry.register(BuiltInRegistries.ITEM, itemKey, item);
		return item;
	}
	
	//Generic Items
	public static final Item shiftedTestObject = register("shifted_test_object", Item::new, new Item.Properties());
}