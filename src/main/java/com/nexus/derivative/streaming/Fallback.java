package com.nexus.derivative.streaming;

import net.minecraft.client.world.ClientWorld;

public class Fallback {

    public static void requestNearby(ClientWorld world, int cx, int cz) {

        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {

                int nx = cx + dx;
                int nz = cz + dz;

                if (PrefetchMap.shouldRequest(nx, nz)) {
                    world.getChunkManager().getChunk(nx, nz);
                }
            }
        }
    }
}
