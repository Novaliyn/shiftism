package com.novaliyn.shiftism;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ShiftismLangProvider extends FabricLanguageProvider {
    protected ShiftismLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

	@Override
	public void generateTranslations(HolderLookup.Provider holderLookup, TranslationBuilder translationBuilder) {
		translationBuilder.add("itemGroup.shiftism", "Shiftism");
		
		//Items
		for (Item item : ShiftedItems.shiftedItemsList) {
			String translationKey = item.getDescriptionId();
			String friendlyName = formatName(BuiltInRegistries.ITEM.getKey(item).getPath());
			translationBuilder.add(translationKey, friendlyName);
		}

		//Blocks
		for (Block block : ShiftedItems.shiftedBlocksList) {
			String translationKey = block.getDescriptionId();
			String friendlyName = formatName(BuiltInRegistries.BLOCK.getKey(block).getPath());
			translationBuilder.add(translationKey, friendlyName);
		}
	}

	private String formatName(String path) {
		String[] words = path.split("_");
		StringBuilder builder = new StringBuilder();
		for (String word : words) {
			if (!word.isEmpty()) {
				builder.append(Character.toUpperCase(word.charAt(0)))
					.append(word.substring(1).toLowerCase())
					.append(" ");
			}
		}
		return builder.toString().trim();
	}
}