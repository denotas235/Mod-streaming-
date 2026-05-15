package com.nexus.derivative.streaming;

import com.nexus.derivative.util.ChunkUtils;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;

public class ChunkStreamingController {
    private static final int MARGIN_BLOCKS = 8;
    private static final int PREFETCH_RADIUS = 2;

    public static void update(ClientWorld world, ClientPlayerEntity player) {
        int chunkX = (int)Math.floor(player.getX()) >> 4;
        int chunkZ = (int)Math.floor(player.getZ()) >> 4;
        double localX = player.getX() - (chunkX << 4);
        double D_frente = 16 * PREFETCH_RADIUS - localX;
        if (D_frente <= MARGIN_BLOCKS) {
            for (int dx = 1; dx <= PREFETCH_RADIUS; dx++) {
                ChunkUtils.requestChunk(world, chunkX + dx, chunkZ);
            }
        }
    }

    public static void forceLoadChunk(Object manager, int x, int z) {
        // Hook para ClientChunkManagerMixin
    }
}
