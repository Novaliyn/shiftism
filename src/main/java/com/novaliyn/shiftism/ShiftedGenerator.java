package com.novaliyn.shiftism;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class ShiftedGenerator implements IWorldGenerator{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.dimensionId != 1) {
            return;
        }
        int VEIN_SIZE = 3 + random.nextInt(6);
        WorldGenMinable gen = new WorldGenMinable(Shiftism.miku_ore, VEIN_SIZE, Blocks.end_stone);
        for (int i = 0; i<13; i++) {
            int x = chunkX * 16 + random.nextInt(16);
            int y = random.nextInt(255) + 1;
            int z = chunkZ * 16 + random.nextInt(16);
            
            gen.generate(world, random, x, y, z);
        }
    }
}
