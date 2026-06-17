package com.novaliyn.shiftism.datagen;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import com.novaliyn.shiftism.Shiftism;
import com.novaliyn.shiftism.items.ShiftismItems;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.predicates.ContextAwarePredicate;
import net.minecraft.advancements.triggers.CriteriaTriggers;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.advancements.triggers.PlayerTrigger.TriggerInstance;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public class ShiftismAdvancementProvider extends FabricAdvancementProvider {
	protected ShiftismAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(output, registryLookup);
	}

	@Override
	public void generateAdvancement(HolderLookup.Provider wrapperLookup, Consumer<AdvancementHolder> consumer) {

        AdvancementHolder shiftismIntro = Advancement.Builder.advancement()
        .display (
            ShiftismItems.MYSTIC_APPLE,
            Component.literal("Shiftism"),
            Component.literal("Welcome to Shiftism, there is a weird buzzing noise coming from the end."),
            Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"), 
            AdvancementType.TASK,
            true,
            true,
            false
        )
        .addCriterion("joined_world", CriteriaTriggers.TICK.createCriterion(new TriggerInstance(Optional.empty())))
        .save(consumer, Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, "shiftism_intro"));

        AdvancementHolder getShiftedDust = Advancement.Builder.advancement()
        .parent(shiftismIntro)
		.display(
				ShiftismItems.IMPURE_SHIFTED_DUST,
				Component.literal("Obtained Impure Shifted Dust"), 
				Component.literal("Now what do you do? Hot and Glowy?"),
				null,
                AdvancementType.TASK, 
				true, 
				true, 
				false 
		)
		.addCriterion("got_impure_shifted_dust", InventoryChangeTrigger.TriggerInstance.hasItems(ShiftismItems.IMPURE_SHIFTED_DUST))
		.save(consumer, Identifier.fromNamespaceAndPath(Shiftism.MOD_ID, "get_impure_shifted_dust"));
	}
}
