package com.novaliyn.shiftism;

import java.util.List;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class ShiftismConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHIFTED_ORE_VEIN_CONFIGURED_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, "shifted_ore_vein"));
    
    private static final RuleTest END_STONE_REPLACEABLE_RULE = new BlockMatchTest(Blocks.END_STONE);
    
    private static final List<OreConfiguration.TargetBlockState> SHIFTED_ORE_CONFIG = List.of(
        OreConfiguration.target(END_STONE_REPLACEABLE_RULE, ShiftedBlocks.shifted_ore.defaultBlockState())
    );

    public static void configure(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(SHIFTED_ORE_VEIN_CONFIGURED_KEY, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SHIFTED_ORE_CONFIG, 10)));
    }
}