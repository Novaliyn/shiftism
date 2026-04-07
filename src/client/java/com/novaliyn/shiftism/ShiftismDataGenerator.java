package com.novaliyn.shiftism;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class ShiftismDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ShiftismLangProvider::new);
		pack.addProvider(ShiftismModelProvider::new);
		pack.addProvider(ShiftismTagsProvider::new);
		//pack.addProvider(ShiftismRecipeProvider::new);
		pack.addProvider(ShiftismWorldGenProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, ShiftismConfiguredFeatures::configure);
		registryBuilder.add(Registries.PLACED_FEATURE, ShiftismPlacedFeatures::configure);

	}
}