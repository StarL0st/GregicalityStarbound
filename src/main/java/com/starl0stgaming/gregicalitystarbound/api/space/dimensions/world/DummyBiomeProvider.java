package com.starl0stgaming.gregicalitystarbound.api.space.dimensions.world;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;

import java.util.List;

public class DummyBiomeProvider extends BiomeProvider {


    public DummyBiomeProvider(List<Biome> biomes) {
        allowedBiomes = biomes;
    }

}
