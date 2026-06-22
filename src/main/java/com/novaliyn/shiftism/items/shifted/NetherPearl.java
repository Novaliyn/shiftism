package com.novaliyn.shiftism.items.shifted;

import com.novaliyn.shiftism.blocks.ShiftismBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class NetherPearl extends Item {
    public NetherPearl(Properties settings) {
        super(settings);
    }

    @Override
        public InteractionResult use(Level level, Player player, InteractionHand hand) {
            ItemStack hands = player.getItemInHand(hand);
            if (!level.isClientSide()) {
                if (level.dimension() != Level.END) {
                    player.sendSystemMessage(Component.literal("This item can only be used in the End.").withStyle(ChatFormatting.RED));
                    return InteractionResult.FAIL;
                }
                if (!player.isCreative()) {
                    hands.shrink(1);
                }
                level.explode(player, (double) player.getBlockX(), (double) player.getBlockY(), (double) player.getBlockZ(), 15.0F, false, Level.ExplosionInteraction.BLOCK);
                int replacements = 5 + level.getRandom().nextInt(8);
                for (int i = 0; i < replacements; i++) {
                    int x = (int) Math.floor(player.getBlockX()) + level.getRandom().nextInt(17) - 8;
                    int y = (int) Math.floor(player.getBlockY()) + level.getRandom().nextInt(9) - 4;
                    int z = (int) Math.floor(player.getBlockZ()) + level.getRandom().nextInt(17) - 8;
                    BlockPos meow = new BlockPos(x, y, z);
                    if (level.getBlockState(meow).getBlock() == Blocks.END_STONE) {
                        level.setBlockAndUpdate(meow, ShiftismBlocks.SHIFTED_ORE.defaultBlockState());
                    }
                }
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.PASS;
        }

}