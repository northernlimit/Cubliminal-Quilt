package net.limit.cubliminal.init;

import net.limit.cubliminal.Cubliminal;
import net.minecraft.registry.Holder;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;


public class ModSounds {
    private static SoundEvent register(String id) {
        return Registry.register(Registries.SOUND_EVENT, Cubliminal.id(id), SoundEvent.createVariableRangeEvent(Cubliminal.id(id)));
    }

	private static Holder.Reference<SoundEvent> registerSoundEvent(String id) {
		return Registry.registerHolder(Registries.SOUND_EVENT, Cubliminal.id(id), SoundEvent.createVariableRangeEvent(Cubliminal.id(id)));
	}
    public static final Holder.Reference<SoundEvent> AMBIENT_LEVEL_O = registerSoundEvent("ambient_0");
    public static final Holder.Reference<SoundEvent> AMBIENT_LEVEL_37 = registerSoundEvent("ambient_37");
    public static final SoundEvent BACTERIA_STEP_SOUND = register("bacteria_step");
    public static final SoundEvent BACTERIA_AMBIENT = register("bacteria_ambient");
    public static final SoundEvent HEARTBEAT = register("heartbeat");
    public static final SoundEvent WHISPERING = register("whispering");

    public static void init() {
    }
}
