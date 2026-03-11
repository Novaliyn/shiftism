public final class ShiftedItems {
  private ShiftedItems() {
  }
 
  public static final Item shiftedWoodSword = register("shifted_wood_sword", Item::new, new Item.Settings());
 
  public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
    final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("shiftism", path));
    return Items.register(registryKey, factory, settings);
  }
 
  public static void initialize() {
  }
}