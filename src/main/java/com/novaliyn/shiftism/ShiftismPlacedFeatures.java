package com.novaliyn.shiftism;

import java.util.List;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class ShiftismPlacedFeatures {
    public static final ResourceKey<PlacedFeature> MIKU_ORE_PLACED_KEY = ResourceKey.create(
        Registries.PLACED_FEATURE, 
        Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, "miku_ore_placed")
    );
    
    public static void configure(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // Move the list and registration INSIDE the method
        List<PlacementModifier> mikuOreVeinModifiers = List.of(CountPlacement.of(10), BiomeFilter.biome(), InSquarePlacement.spread());

        context.register(MIKU_ORE_PLACED_KEY, new PlacedFeature(
            configuredFeatures.getOrThrow(ShiftismConfiguredFeatures.MIKU_ORE_VEIN_CONFIGURED_KEY),
            mikuOreVeinModifiers
        ));
    }
}