package net.limit.cubliminal.init;

import net.limit.cubliminal.Cubliminal;
import net.limit.cubliminal.effect.ParanoiaEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModEffects {
    public static StatusEffect PARANOIA;
    public static StatusEffect registerStatusEffect(String id) {
        return Registry.register(Registries.STATUS_EFFECT, Cubliminal.id(id),
                new ParanoiaEffect(StatusEffectType.HARMFUL, 24828));
    }

    public static void init() {
        PARANOIA = registerStatusEffect("paranoia");
    }
}
