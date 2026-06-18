package com.novaliyn.shiftism.datagen;

import java.util.concurrent.CompletableFuture;

import com.novaliyn.shiftism.blocks.ShiftismBlocks;
import com.novaliyn.shiftism.items.ShiftismItems;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ShiftismBlockLootTableProvider extends FabricBlockLootSubProvider {
	protected ShiftismBlockLootTableProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(dataOutput, registryLookup);
	}

	@Override
	public void generate() {

        dropSelf(ShiftismBlocks.PRIDE_FLAG);
        dropSelf(ShiftismBlocks.TRANSGENDER_FLAG);
        dropSelf(ShiftismBlocks.SHIFTED_BLOCK);
        dropSelf(ShiftismBlocks.SHIFTED_PEG);
        add(ShiftismBlocks.SHIFTED_ORE, LootTable.lootTable().withPool(applyExplosionCondition(ShiftismBlocks.SHIFTED_ORE, LootPool.lootPool().setRolls(new UniformGenerator(new ConstantValue(1), new ConstantValue(3))).add(LootItem.lootTableItem(ShiftismItems.IMPURE_SHIFTED_DUST)))));
		dropOther(ShiftismBlocks.NEBULITE_WEB,	ShiftismItems.NEBULITE_THREAD);

	}
}

