package net.limit.cubliminal.init;

import net.limit.cubliminal.Cubliminal;
import net.limit.cubliminal.block.entity.FluorescentLightBlockEntity;
import net.limit.cubliminal.block.entity.FusedFluorescentLightBlockEntity;
import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.block.entity.api.QuiltBlockEntityTypeBuilder;

public class ModBlockEntities {
    public static final BlockEntityType<BarrelBlockEntity> METAL_BARREL_BLOCK_ENTITY =
		Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Cubliminal.MOD_ID, "metal_barrel"),
			QuiltBlockEntityTypeBuilder.create(BarrelBlockEntity::new, ModBlocks.METAL_BARREL).build());

	public static final BlockEntityType<FluorescentLightBlockEntity> FLUORESCENT_LIGHT_BLOCK_ENTITY =
		Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Cubliminal.MOD_ID, "fluorescent_light"),
			QuiltBlockEntityTypeBuilder.create(FluorescentLightBlockEntity::new, ModBlocks.FLUORESCENT_LIGHT).build());

	public static final BlockEntityType<FusedFluorescentLightBlockEntity> FUSED_FLUORESCENT_LIGHT_BLOCK_ENTITY =
		Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Cubliminal.MOD_ID, "fused_fluorescent_light"),
			QuiltBlockEntityTypeBuilder.create(FusedFluorescentLightBlockEntity::new, ModBlocks.FUSED_FLUORESCENT_LIGHT).build());

    public static void init() {
    }
}
