package net.limit.cubliminal.init;

import net.limit.cubliminal.Cubliminal;
import net.limit.cubliminal.block.custom.*;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import static net.minecraft.block.Blocks.createLightLevelFromLitBlockState;

public class ModBlocks {
    private static void registerBlockItem(String id, Block block) {
        Registry.register(Registries.ITEM, Cubliminal.id(id),
                new BlockItem(block, new QuiltItemSettings()));
    }
    private static Block registerBlock(String id, Block block) {
        registerBlockItem(id, block);
        return Registry.register(Registries.BLOCK, Cubliminal.id(id), block);
    }

    public static final Block YELLOW_WALLPAPERS = registerBlock("yellow_wallpapers",
            new Block(QuiltBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE)
				.sounds(BlockSoundGroup.BASALT)
				.strength(5, 7)));
    public static final Block YELLOW_WALLPAPERS_PLUG = registerBlock("yellow_wallpapers_plug",
            new Block(QuiltBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE)
				.sounds(BlockSoundGroup.BASALT)
				.strength(5, 7)));
    public static final Block YELLOW_WALLPAPERS_WALL = registerBlock("yellow_wallpapers_wall",
            new WallBlock(QuiltBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE)
				.sounds(BlockSoundGroup.BASALT)
				.strength(5, 7)));
	public static final Block YELLOW_WALLPAPERS_VERTICAL_SLAB = registerBlock("yellow_wallpapers_vertical_slab",
		new VerticalSlabBlock(AbstractBlock.Settings.create()
			.sounds(BlockSoundGroup.BASALT)
			.strength(5, 7)));
    public static final Block DAMAGED_YELLOW_WALLPAPERS = registerBlock("damaged_yellow_wallpapers",
            new Block(QuiltBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE).sounds(BlockSoundGroup.BASALT).strength(5, 7)));
    public static final Block BOTTOM_YELLOW_WALLPAPERS = registerBlock("bottom_yellow_wallpapers",
            new Block(QuiltBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE)
				.sounds(BlockSoundGroup.BASALT)
				.strength(5, 7)));
    public static final Block FALSE_CEILING = registerBlock("false_ceiling",
            new Block(QuiltBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE)
				.sounds(BlockSoundGroup.CALCITE)
				.strength(5, 7)));
    public static final Block FALSE_CEILING_SMOKE_DETECTOR = registerBlock("false_ceiling_smoke_detector",
            new Block(QuiltBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE)
				.sounds(BlockSoundGroup.CALCITE)
				.strength(5, 7)));
    public static final Block DAMP_CARPET = registerBlock("damp_carpet",
            new Block(QuiltBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE)
				.sounds(BlockSoundGroup.WOOL)
				.strength(2, 3)));
    public static final Block DIRTY_DAMP_CARPET = registerBlock("dirty_damp_carpet",
            new Block(QuiltBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE)
				.sounds(BlockSoundGroup.WOOL)
				.strength(2, 3)));
    public static final Block LED_LIGHTS = registerBlock("led_lights",
            new Block(QuiltBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE)
				.sounds(BlockSoundGroup.GLASS)
				.strength(3, 5)
				.luminance(state ->15)));
    public static final Block FUSED_LED_LIGHTS = registerBlock("fused_led_lights",
            new Block(QuiltBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE)
				.sounds(BlockSoundGroup.GLASS)
				.strength(3, 5)));
    public static final Block POOL_TILES = registerBlock("pool_tiles",
            new Block(QuiltBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE)
				.sounds(BlockSoundGroup.DEEPSLATE_TILES)));
    public static final Block POOL_TILE_STAIRS = registerBlock("pool_tile_stairs",
            new StairsBlock(ModBlocks.POOL_TILES.getDefaultState(),
				QuiltBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE)));
    public static final Block POOL_TILE_SLAB = registerBlock("pool_tile_slab",
            new SlabBlock(QuiltBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE)));
    public static final Block POOL_TILE_WALL = registerBlock("pool_tile_wall",
            new WallBlock(QuiltBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE)));

    public static final Block METAL_BARREL = registerBlock("metal_barrel",
            new MetalBarrelBlock(QuiltBlockSettings.copyOf(Blocks.IRON_BLOCK)));

	public static final Block FLUORESCENT_LIGHT = registerBlock("fluorescent_light",
		new FluorescentLightBlock(AbstractBlock.Settings.create()
			.strength(3, 5)
			.luminance(createLightLevelFromLitBlockState(15))
			.sounds(BlockSoundGroup.GLASS)));

	public static final Block FUSED_FLUORESCENT_LIGHT = registerBlock("fused_fluorescent_light",
		new FusedFluorescentLightBlock(AbstractBlock.Settings.create()
			.strength(3, 5)
			.luminance(createLightLevelFromLitBlockState(6))
			.sounds(BlockSoundGroup.GLASS)));
	public static final Block SMOKE_DETECTOR = registerBlock("smoke_detector",
		new SmokeDetectorBlock(AbstractBlock.Settings.create()
			.strength(4, 5)
			.offsetType(AbstractBlock.OffsetType.XZ)
			.dynamicBounds()
			.solidBlock(Blocks::never)
			.sounds(BlockSoundGroup.LANTERN)));

	public static final Block ELECTRIC_PLUG = registerBlock("electric_plug",
		new ElectricPlugBlock(AbstractBlock.Settings.create()
			.strength(4, 5)
			.sounds(BlockSoundGroup.CALCITE)));

    public static void init() {
    }
}
