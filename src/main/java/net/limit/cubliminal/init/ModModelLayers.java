package net.limit.cubliminal.init;

import net.limit.cubliminal.Cubliminal;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer BACTERIA =
            new EntityModelLayer(new Identifier(Cubliminal.MOD_ID, "bacteria"), "main");
}
