package net.limit.cubliminal.world.chunk;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.limit.cubliminal.Cubliminal;
import net.limit.cubliminal.init.ModWorlds;
import net.ludocrypt.limlib.api.world.LimlibHelper;
import net.ludocrypt.limlib.api.world.NbtGroup;
import net.ludocrypt.limlib.api.world.chunk.AbstractNbtChunkGenerator;
import net.minecraft.server.world.ChunkHolder;
import net.minecraft.server.world.ServerLightingProvider;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.gen.RandomState;
import net.minecraft.world.gen.chunk.ChunkGenerator;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Function;

public class LevelZeroChunkGenerator extends AbstractNbtChunkGenerator {
	public static final Codec<LevelZeroChunkGenerator> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(BiomeSource.CODEC.fieldOf("biome_source").stable().forGetter((chunkGenerator) -> {
			return chunkGenerator.populationSource;
		}), NbtGroup.CODEC.fieldOf("group").stable().forGetter((chunkGenerator) -> {
			return chunkGenerator.nbtGroup;
		})).apply(instance, instance.stable(LevelZeroChunkGenerator::new));
	});

	public LevelZeroChunkGenerator(BiomeSource biomeSource, NbtGroup group) {
		super(biomeSource, group);
	}

	public static NbtGroup createGroup() {
		return NbtGroup.Builder
			.create(Cubliminal.id(ModWorlds.THE_LOBBY))
			.with("0space", 1, 1)
			.with("0block", 1, 1)
			.with("0column", 1, 2)
			.with("0corridor", 1, 2)
			.with("0midwall", 1, 2)
			.with("0wall", 1, 4)
			.with("0corner", 1, 4)
			.with("0thickcorner", 1, 4)
			.with("0thickwall", 1, 4)
			.with("0tinywall", 1, 4)
			.with("0twowalls", 1, 16)
			.build();
	}
	@Override
	protected Codec<? extends ChunkGenerator> getCodec() {
		return CODEC;
	}

	public void decorateRoom(ChunkRegion region, BlockPos pos){
		RandomGenerator random = RandomGenerator
			.createLegacy(region.getSeed() + LimlibHelper.blockSeed(pos));

		if (random.nextInt(3) == 0) {
			generateNbt(region, pos, nbtGroup.pick("0space", random));
		} else {
			if (random.nextInt(3) == 0) {
				generateNbt(region, pos, nbtGroup.pick(nbtGroup
					.chooseGroup(random, "0block", "0column", "0corridor", "0tinywall"), random));
			} else {
				generateNbt(region, pos, nbtGroup.pick(nbtGroup
					.chooseGroup(random, "0corner", "0wall", "0midwall"
						, "0thickcorner", "0thickwall", "0twowalls"), random));
			}
		}
	}

	@Override
	public CompletableFuture<Chunk> populateNoise(ChunkRegion region, ChunkStatus targetStatus, Executor executor,
												  ServerWorld world, ChunkGenerator generator,
												  StructureTemplateManager structureTemplateManager,
												  ServerLightingProvider lightingProvider, Function<Chunk,
		CompletableFuture<Either<Chunk, ChunkHolder.Unloaded>>> fullChunkConverter, List<Chunk> chunks, Chunk chunk) {

		BlockPos startPos = chunk.getPos().getStartPos();
		ChunkPos chunkPos = new ChunkPos(startPos);
		BlockPos originCoords = chunkPos.getBlockPos(0, 0, 0);
		int spacing = 6;
		int originX = originCoords.getX();
		int originZ = originCoords.getZ();

		if (originX >= 0 && originZ >= 0) {
			BlockPos startCoords = chunkPos.getBlockPos(0, 0, 0);
			int startX = startCoords.getX();
			int startZ = startCoords.getZ();

			int offsetX = spacing - Math.abs(startX) % spacing;
			int offsetZ = spacing - Math.abs(startZ) % spacing;
			if (offsetX == spacing) {
				offsetX = 0;
			}
			if (offsetZ == spacing) {
				offsetZ = 0;
			}
			int timesX = (16 - offsetX) / spacing;
			int timesZ = (16 - offsetZ) / spacing;

			if ((16 - offsetX) % spacing != 0) {
				++timesX;
			}
			if ((16 - offsetZ) % spacing != 0) {
				++timesZ;
			}

			for (int x = 0; x < timesX; x++) {
				for (int z = 0; z < timesZ; z++) {
					BlockPos offsetPos = startPos.add(x * spacing + offsetX, 0, z * spacing + offsetZ);
					decorateRoom(region, offsetPos);

					//region.setBlockState(offsetPos, Blocks.SHROOMLIGHT.getDefaultState(), Block.FORCE_STATE);
				}
			}
		} else if (originX < 0 && originZ >= 0) {
			BlockPos startCoords = chunkPos.getBlockPos(15, 0, 0);
			int startX = startCoords.getX();
			int startZ = startCoords.getZ();

			int offsetX = spacing - Math.abs(startX) % spacing;
			int offsetZ = spacing - Math.abs(startZ) % spacing;
			if (offsetX == spacing) {
				offsetX = 0;
			}
			if (offsetZ == spacing) {
				offsetZ = 0;
			}
			int timesX = (16 - offsetX) / spacing;
			int timesZ = (16 - offsetZ) / spacing;

			if ((16 - offsetX) % spacing != 0) {
				++timesX;
			}
			if ((16 - offsetZ) % spacing != 0) {
				++timesZ;
			}

			for (int x = 0; x < timesX; x++) {
				for (int z = 0; z < timesZ; z++) {
					BlockPos offsetPos = startPos.add(15 - (x * spacing + offsetX), 0, z * spacing + offsetZ);
					decorateRoom(region, offsetPos);

					//region.setBlockState(offsetPos, Blocks.SHROOMLIGHT.getDefaultState(), Block.FORCE_STATE);
				}
			}
		} else if (originX < 0) {
			BlockPos startCoords = chunkPos.getBlockPos(15, 0, 15);
			int startX = startCoords.getX();
			int startZ = startCoords.getZ();

			int offsetX = spacing - Math.abs(startX) % spacing;
			int offsetZ = spacing - Math.abs(startZ) % spacing;
			if (offsetX == spacing) {
				offsetX = 0;
			}
			if (offsetZ == spacing) {
				offsetZ = 0;
			}
			int timesX = (16 - offsetX) / spacing;
			int timesZ = (16 - offsetZ) / spacing;

			if ((16 - offsetX) % spacing != 0) {
				++timesX;
			}
			if ((16 - offsetZ) % spacing != 0) {
				++timesZ;
			}

			for (int x = 0; x < timesX; x++) {
				for (int z = 0; z < timesZ; z++) {
					BlockPos offsetPos = startPos.add(15 - (x * spacing + offsetX), 0, 15 - (z * spacing + offsetZ));
					decorateRoom(region, offsetPos);

					//region.setBlockState(offsetPos, Blocks.SHROOMLIGHT.getDefaultState(), Block.FORCE_STATE);
				}
			}
		} else {
			BlockPos startCoords = chunkPos.getBlockPos(0, 0, 15);
			int startX = startCoords.getX();
			int startZ = startCoords.getZ();

			int offsetX = spacing - Math.abs(startX) % spacing;
			int offsetZ = spacing - Math.abs(startZ) % spacing;
			if (offsetX == spacing) {
				offsetX = 0;
			}
			if (offsetZ == spacing) {
				offsetZ = 0;
			}
			int timesX = (16 - offsetX) / spacing;
			int timesZ = (16 - offsetZ) / spacing;

			if ((16 - offsetX) % spacing != 0) {
				++timesX;
			}
			if ((16 - offsetZ) % spacing != 0) {
				++timesZ;
			}

			for (int x = 0; x < timesX; x++) {
				for (int z = 0; z < timesZ; z++) {
					BlockPos offsetPos = startPos.add(x * spacing + offsetX, 0, 15 - (z * spacing + offsetZ));
					decorateRoom(region, offsetPos);

					//region.setBlockState(offsetPos, Blocks.SHROOMLIGHT.getDefaultState(), Block.FORCE_STATE);
				}
			}
		}
		return CompletableFuture.completedFuture(chunk);
	}

	@Override
	public int getPlacementRadius() {
		return 6;
	}

	@Override
	public int getWorldHeight() {
		return 100;
	}

    @Override
	public void method_40450(List<String> list, RandomState randomState, BlockPos pos) {
	}
}
