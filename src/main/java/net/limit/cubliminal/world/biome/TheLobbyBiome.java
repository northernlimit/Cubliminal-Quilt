package net.limit.cubliminal.world.biome;

import net.limit.cubliminal.init.ModSounds;
import net.minecraft.registry.HolderProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;

public class TheLobbyBiome {
	public static Biome create(HolderProvider<PlacedFeature> features, HolderProvider<ConfiguredCarver<?>> carvers) {
		Biome.Builder biome = new Biome.Builder();

		SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
		GenerationSettings.Builder generationSettings = new GenerationSettings.Builder(features, carvers);
		BiomeEffects.Builder biomeEffects = new BiomeEffects.Builder();

		biomeEffects.loopSound(ModSounds.AMBIENT_LEVEL_O);
		biomeEffects.skyColor(0);
		biomeEffects.fogColor(0);
		biomeEffects.waterColor(15660426);
		biomeEffects.waterFogColor(12499526);
		BiomeEffects effects = biomeEffects.build();

		biome.spawnSettings(spawnSettings.build());
		biome.generationSettings(generationSettings.build());
		biome.temperature(0.8F);
		biome.downfall(0.4F);
		biome.hasPrecipitation(false);
		biome.effects(effects);

        return biome.build();
    }
}
