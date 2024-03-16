package net.limit.cubliminal.effect;

import net.limit.cubliminal.init.ModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;

import java.util.Random;

public class ParanoiaEffect extends StatusEffect {

    public ParanoiaEffect(StatusEffectType category, int color) {
        super(category, color);
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        Random heartbeat = new Random();
        Random whispering = new Random();
        Random damage = new Random();

        while (heartbeat.nextInt(800) == 1) {
            entity.playSound(ModSounds.HEARTBEAT, 1f, 1f);
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 60));
        }
        while (whispering.nextInt(1200) == 1) {
            entity.playSound(ModSounds.WHISPERING, 1f, 1f);
        }
        while (damage.nextInt(500) == 1) {
            entity.damage(entity.getDamageSources().genericKill(), 1);
        }
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean shouldApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
