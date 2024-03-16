package net.limit.cubliminal.init;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Lifecycle;
import net.limit.cubliminal.Cubliminal;
import net.limit.cubliminal.world.biome.TheLobbyBiome;
import net.limit.cubliminal.world.chunk.LevelZeroChunkGenerator;
import net.ludocrypt.limlib.api.LimlibRegistrar;
import net.ludocrypt.limlib.api.LimlibRegistryHooks;
import net.ludocrypt.limlib.api.LimlibWorld;
import net.ludocrypt.limlib.api.effects.post.PostEffect;
import net.ludocrypt.limlib.api.effects.sky.DimensionEffects;
import net.ludocrypt.limlib.api.effects.sound.SoundEffects;
import net.ludocrypt.limlib.api.skybox.Skybox;
import net.minecraft.registry.HolderProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.int_provider.ConstantIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.biome.source.FixedBiomeSource;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionType.MonsterSettings;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.List;
import java.util.OptionalLong;


public class ModWorlds implements LimlibRegistrar {

	private static final List<Pair<RegistryKey<LimlibWorld>, LimlibWorld>> WORLDS = Lists.newArrayList();
	private static final List<Pair<RegistryKey<SoundEffects>, SoundEffects>> SOUND_EFFECTS = Lists.newArrayList();
	private static final List<Pair<RegistryKey<Skybox>, Skybox>> SKYBOXES = Lists.newArrayList();
	private static final List<Pair<RegistryKey<DimensionEffects>, DimensionEffects>> DIMENSION_EFFECTS = Lists.newArrayList();
	private static final List<Pair<RegistryKey<PostEffect>, PostEffect>> POST_EFFECTS = Lists.newArrayList();

	public static String THE_LOBBY = "the_lobby";
    public static final RegistryKey<World> THE_LOBBY_KEY = RegistryKey.of(RegistryKeys.WORLD,
		Cubliminal.id(THE_LOBBY));

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void registerHooks() {
		getWorld(THE_LOBBY,
			new LimlibWorld(
				() -> new DimensionType(OptionalLong.of(15500), false, false, false, false, 1.0, true, true, 0, 384, 384,
					TagKey.of(RegistryKeys.BLOCK, Cubliminal.id(THE_LOBBY)), Cubliminal.id(THE_LOBBY),
					0F, new MonsterSettings(false, false, ConstantIntProvider.ZERO, 0)),
				(registry) -> new DimensionOptions(
					registry
						.get(RegistryKeys.DIMENSION_TYPE)
						.getHolder(RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Cubliminal.id(THE_LOBBY)))
						.get(),
					new LevelZeroChunkGenerator(
						new FixedBiomeSource(
							registry.get(RegistryKeys.BIOME).getHolder(ModBiomes.THE_LOBBY_BIOME).get()),
						LevelZeroChunkGenerator.createGroup()))));

		WORLDS.forEach((pair) -> LimlibWorld.LIMLIB_WORLD.register(pair.getFirst(), pair.getSecond(), Lifecycle.stable()));
		LimlibRegistryHooks
			.hook(SoundEffects.SOUND_EFFECTS_KEY, (infoLookup, registryKey, registry) -> SOUND_EFFECTS
				.forEach((pair) -> registry.register(pair.getFirst(), pair.getSecond(), Lifecycle.stable())));
		LimlibRegistryHooks
			.hook(Skybox.SKYBOX_KEY, (infoLookup, registryKey, registry) -> SKYBOXES
				.forEach((pair) -> registry.register(pair.getFirst(), pair.getSecond(), Lifecycle.stable())));
		LimlibRegistryHooks
			.hook(DimensionEffects.DIMENSION_EFFECTS_KEY, (infoLookup, registryKey, registry) -> DIMENSION_EFFECTS
				.forEach((pair) -> registry.register(pair.getFirst(), pair.getSecond(), Lifecycle.stable())));
		LimlibRegistryHooks
			.hook(PostEffect.POST_EFFECT_KEY, (infoLookup, registryKey, registry) -> POST_EFFECTS
				.forEach((pair) -> registry.register(pair.getFirst(), pair.getSecond(), Lifecycle.stable())));
		LimlibRegistryHooks.hook(RegistryKeys.BIOME, (infoLookup, registryKey, registry) -> {
			HolderProvider<PlacedFeature> features = infoLookup.lookup(RegistryKeys.PLACED_FEATURE).get().getter();
			HolderProvider<ConfiguredCarver<?>> carvers = infoLookup.lookup(RegistryKeys.CONFIGURED_CARVER).get().getter();
			registry
				.register(ModBiomes.THE_LOBBY_BIOME, TheLobbyBiome.create(features, carvers),
					Lifecycle.stable());
		});
	}

	private static <W extends LimlibWorld> W getWorld(String id, W world) {
		WORLDS.add(Pair.of(RegistryKey.of(LimlibWorld.LIMLIB_WORLD_KEY, Cubliminal.id(id)), world));
		return world;
	}

	private static <E extends SoundEffects> E getSoundEffects(String id, E soundEffects) {
		SOUND_EFFECTS.add(Pair.of(RegistryKey.of(SoundEffects.SOUND_EFFECTS_KEY, Cubliminal.id(id)), soundEffects));
		return soundEffects;
	}

	private static <S extends Skybox> S getSkybox(String id, S skybox) {
		SKYBOXES.add(Pair.of(RegistryKey.of(Skybox.SKYBOX_KEY, Cubliminal.id(id)), skybox));
		return skybox;
	}

	private static <D extends DimensionEffects> D getDimEffects(String id, D dimensionEffects) {
		DIMENSION_EFFECTS
			.add(Pair.of(RegistryKey.of(DimensionEffects.DIMENSION_EFFECTS_KEY, Cubliminal.id(id)), dimensionEffects));
		return dimensionEffects;
	}

	private static <P extends PostEffect> P getPostEffects(String id, P postEffect) {
		POST_EFFECTS.add(Pair.of(RegistryKey.of(PostEffect.POST_EFFECT_KEY, Cubliminal.id(id)), postEffect));
		return postEffect;
	}
}
