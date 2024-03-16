package net.limit.cubliminal;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.limit.cubliminal.entity.client.BacteriaModel;
import net.limit.cubliminal.entity.client.BacteriaRenderer;
import net.limit.cubliminal.init.ModEntities;
import net.limit.cubliminal.init.ModModelLayers;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class CubliminalClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(ModContainer modContainer) {
        EntityRendererRegistry
			.register(ModEntities.BACTERIA, BacteriaRenderer::new);
        EntityModelLayerRegistry
			.registerModelLayer(ModModelLayers.BACTERIA, BacteriaModel::getTexturedModelData);
    }
}
