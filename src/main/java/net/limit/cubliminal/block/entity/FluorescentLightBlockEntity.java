package net.limit.cubliminal.block.entity;

import net.limit.cubliminal.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class FluorescentLightBlockEntity extends BlockEntity {


	public FluorescentLightBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntities.FLUORESCENT_LIGHT_BLOCK_ENTITY, pos, state);
	}
}
