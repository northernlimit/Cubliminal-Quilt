package net.limit.cubliminal;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.limit.cubliminal.entity.custom.BacteriaEntity;
import net.limit.cubliminal.init.*;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class Cubliminal implements ModInitializer {
	public static final String MOD_ID = "cubliminal";

	public static Identifier id(String id) {
		return new Identifier("cubliminal", id);
	}
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize(ModContainer mod) {
		ModItemGroups.init();
		ModItems.init();
		ModBlocks.init();
		ModBiomes.init();
		ModSounds.init();
		ModEntities.init();
		ModEffects.init();
		FabricDefaultAttributeRegistry.register(ModEntities.BACTERIA, BacteriaEntity.createBacteriaAttributes());
		ModBlockEntities.init();
	}
}
