package net.limit.cubliminal.init;

import net.limit.cubliminal.Cubliminal;
import net.limit.cubliminal.entity.custom.BacteriaEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.entity.extensions.api.QuiltEntityTypeBuilder;

public class ModEntities {
    public static final EntityType<BacteriaEntity> BACTERIA = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Cubliminal.MOD_ID, "bacteria"),
		QuiltEntityTypeBuilder.create(SpawnGroup.MONSTER, BacteriaEntity::new)
			.setDimensions(EntityDimensions.fixed(0.8f,2.8f)).build());

    public static void init() {
    }
}

