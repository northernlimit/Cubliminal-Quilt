package net.limit.cubliminal.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.limit.cubliminal.Cubliminal;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BACKROOMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Cubliminal.MOD_ID, "backrooms"),
            FabricItemGroup.builder().name(Text.translatable("itemgroup.Backrooms"))
                    .icon(() -> new ItemStack(ModBlocks.YELLOW_WALLPAPERS)).entries((displayContext, entries) -> {

                        entries.addItem(ModItems.YELLOW_WALLPAPER);
                        entries.addItem(ModBlocks.YELLOW_WALLPAPERS);
                        entries.addItem(ModBlocks.YELLOW_WALLPAPERS_PLUG);
                        entries.addItem(ModBlocks.YELLOW_WALLPAPERS_WALL);
						entries.addItem(ModBlocks.YELLOW_WALLPAPERS_VERTICAL_SLAB);
                        entries.addItem(ModBlocks.BOTTOM_YELLOW_WALLPAPERS);
                        entries.addItem(ModBlocks.DAMAGED_YELLOW_WALLPAPERS);
                        entries.addItem(ModBlocks.FALSE_CEILING);
                        entries.addItem(ModBlocks.FALSE_CEILING_SMOKE_DETECTOR);
                        entries.addItem(ModBlocks.DAMP_CARPET);
                        entries.addItem(ModBlocks.DIRTY_DAMP_CARPET);
                        entries.addItem(ModBlocks.LED_LIGHTS);
                        entries.addItem(ModBlocks.FUSED_LED_LIGHTS);
						entries.addItem(ModBlocks.FLUORESCENT_LIGHT);
						entries.addItem(ModBlocks.FUSED_FLUORESCENT_LIGHT);
						entries.addItem(ModBlocks.SMOKE_DETECTOR);
						entries.addItem(ModBlocks.ELECTRIC_PLUG);
                        entries.addItem(ModBlocks.METAL_BARREL);
                        entries.addItem(ModItems.BACTERIA_SPAWN_EGG);
                        entries.addItem(ModItems.ALMOND_WATER);
                        entries.addItem(ModItems.WOODEN_PLANK);
                        entries.addItem(ModItems.NAILED_BAT);
                        entries.addItem(ModBlocks.POOL_TILES);
                        entries.addItem(ModBlocks.POOL_TILE_SLAB);
                        entries.addItem(ModBlocks.POOL_TILE_STAIRS);
                        entries.addItem(ModBlocks.POOL_TILE_WALL);

                    }).build());

    public static void init() {
    }
}
