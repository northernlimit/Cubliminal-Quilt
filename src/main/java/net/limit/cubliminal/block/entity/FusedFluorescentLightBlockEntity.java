package net.limit.cubliminal.block.entity;

import net.limit.cubliminal.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class FusedFluorescentLightBlockEntity extends BlockEntity {


	public FusedFluorescentLightBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntities.FUSED_FLUORESCENT_LIGHT_BLOCK_ENTITY, pos, state);
	}
}
