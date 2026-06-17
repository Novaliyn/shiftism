package com.novaliyn.shiftism.blocks;


import com.mojang.serialization.MapCodec;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RodBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public class ShiftedPeg extends RodBlock {
    public static final MapCodec<ShiftedPeg> CODEC = simpleCodec(ShiftedPeg::new);

	@Override
	public MapCodec<ShiftedPeg> codec() {
		return CODEC;
	}

    public ShiftedPeg(final BlockBehaviour.Properties properties) {
		super(properties);
	    this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP));
	}

	@Override
	protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(final BlockPlaceContext context) {
		Direction clickedFace = context.getClickedFace();
		BlockState blockState = context.getLevel().getBlockState(context.getClickedPos().relative(clickedFace.getOpposite()));
		return blockState.is(this) && blockState.getValue(FACING) == clickedFace
			? this.defaultBlockState().setValue(FACING, clickedFace.getOpposite())
			: this.defaultBlockState().setValue(FACING, clickedFace);
	}
}
