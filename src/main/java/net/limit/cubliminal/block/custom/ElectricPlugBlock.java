package net.limit.cubliminal.block.custom;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class ElectricPlugBlock extends HorizontalFacingBlock {
	public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
	protected static final VoxelShape WEST_SHAPE = Block.createCuboidShape(15.5, 1, 4.5, 16, 9.5, 11.5);
	protected static final VoxelShape EAST_SHAPE = Block.createCuboidShape(0, 1, 4.5, 0.5, 9.5, 11.5);
	protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(4.5, 1, 0, 11.5, 9.5, 0.5);
	protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(4.5, 1, 15.5, 11.5, 9.5, 16);
	public ElectricPlugBlock(Settings settings) {
		super(settings);
		this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
	@Override
	public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
		if (!state.canPlaceAt(world, pos)) {
			world.breakBlock(pos, false);
		}
	}
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return switch (state.get(FACING)) {
			default -> NORTH_SHAPE;
			case SOUTH -> SOUTH_SHAPE;
			case WEST -> WEST_SHAPE;
			case EAST -> EAST_SHAPE;
		};
	}

	@Override
	public BlockState rotate(BlockState state, BlockRotation rotation) {
		return state.with(FACING, rotation.rotate(state.get(FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, BlockMirror mirror) {
		return state.rotate(mirror.getRotation(state.get(FACING)));
	}

	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
		return direction.getOpposite() == state.get(FACING) && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : state;
	}

	@Override
	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		Direction direction = state.get(FACING);
		BlockPos blockPos = pos.offset(direction.getOpposite());
		BlockState blockState = world.getBlockState(blockPos);
		return blockState.isSideSolidFullSquare(world, blockPos, direction);
	}

	@Nullable
	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		BlockState blockState = this.getDefaultState();
		WorldView worldView = ctx.getWorld();
		BlockPos blockPos = ctx.getBlockPos();
		Direction[] directions = ctx.getPlacementDirections();

		for(Direction direction : directions) {
			if (direction.getAxis().isHorizontal()) {
				blockState = blockState.with(FACING, direction.getOpposite());
				if (blockState.canPlaceAt(worldView, blockPos)) {
					return blockState;
				}
			}
		}

		return null;
	}
}
