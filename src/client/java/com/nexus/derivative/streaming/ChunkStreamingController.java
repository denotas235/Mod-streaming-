package com.nexus.derivative.streaming;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;

public class ChunkStreamingController {

    private static final int MARGIN_BLOCKS = 8;

    public static void update(ClientWorld world, ClientPlayerEntity player) {
        double x = player.getX();
        double z = player.getZ();

        int chunkX = (int)Math.floor(x) >> 4;
        int chunkZ = (int)Math.floor(z) >> 4;

        double localX = x - (chunkX << 4);
        double localZ = z - (chunkZ << 4);

        // TODO: lógica derivativa
    }
}
