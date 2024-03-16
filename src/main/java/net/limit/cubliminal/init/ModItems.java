package net.limit.cubliminal.init;

import net.limit.cubliminal.Cubliminal;
import net.limit.cubliminal.item.AlmondWaterItem;
import net.limit.cubliminal.item.BasicWeaponItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModItems {

    public static final Item YELLOW_WALLPAPER = registerItem("yellow_wallpaper", new Item(new QuiltItemSettings()));
    public static final Item BACTERIA_SPAWN_EGG = registerItem("bacteria_spawn_egg", new SpawnEggItem(ModEntities.BACTERIA, 0x171717, 0x2d02a6, new QuiltItemSettings()));
    public static final Item ALMOND_WATER = registerItem("almond_water", new AlmondWaterItem(new QuiltItemSettings().food(ModFoodComponents.ALMOND_WATER).maxCount(16)));
    public static final Item WOODEN_PLANK = registerItem("wooden_plank", new BasicWeaponItem(2, -2f, new QuiltItemSettings()));
    public static final Item NAILED_BAT = registerItem("nailed_bat", new SwordItem(ToolMaterials.IRON, 3, -2.2f, new QuiltItemSettings().maxCount(1)));
    private static Item registerItem(String id, Item item) {
        return Registry.register(Registries.ITEM, Cubliminal.id(id), item);
    }

    public static void init() {
	}
}
