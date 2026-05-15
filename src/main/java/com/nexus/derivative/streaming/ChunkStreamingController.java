package com.nexus.derivative.streaming;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.network.ClientPlayerEntity;

public class ChunkStreamingController {

    public static void update(ClientWorld world, ClientPlayerEntity player) {

        double x = player.getX();
        double z = player.getZ();

        int[][] predicted = Predictor.predictFutureChunks(x, z);

        for (int[] p : predicted) {
            int cx = p[0];
            int cz = p[1];

            if (PrefetchMap.shouldRequest(cx, cz)) {
                world.getChunkManager().getChunk(cx, cz);
            }
        }
    }
}
