package com.starl0stgaming.gregicalitystarbound.common;

import com.starl0stgaming.gregicalitystarbound.GregicalityStarbound;

import com.starl0stgaming.gregicalitystarbound.api.GCSBLog;
import com.starl0stgaming.gregicalitystarbound.api.space.planets.Planet;
import com.starl0stgaming.gregicalitystarbound.common.recipe.GCSBRecipeLoader;
import com.starl0stgaming.gregicalitystarbound.common.space.dimension.ModDimension;
import gregtech.api.GregTechAPI;
import gregtech.api.unification.material.event.PostMaterialEvent;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = GregicalityStarbound.MODID)
public class CommonProxy {


    public void preLoad() {
        ModDimension.init();
    }

    public void load() {

    }

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        GregicalityStarbound.SPACE_CONTROLLER.initializeSpace();

        IForgeRegistry<Biome> registry = event.getRegistry();

        registry.registerAll(ModDimension.BIOMES.toArray(new Biome[0]));

        ModDimension.BIOMES.forEach((biome) -> {
            BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 4));
            BiomeManager.addSpawnBiome(biome);

            BiomeDictionary.addTypes(biome, BiomeDictionary.Type.DEAD);
        });

        GCSBLog.LOGGER.info("Registered Biomes");


    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        GCSBRecipeLoader.init();
    }
}
