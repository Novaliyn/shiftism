public class ShiftedBlocks {
  public static final Block shiftedWoodBlock = register("shifted_wood_block", Block::new, Block.Settings.create().strength(4.0f));
 
  private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
    final Identifier identifier = Identifier.of("shiftism", path);
    final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
 
    final Block block = Blocks.register(registryKey, factory, settings);
    Items.register(block);
    return block;
  }
}Gen