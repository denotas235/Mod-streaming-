package com.nexus.derivative.util;
import net.minecraft.client.world.ClientWorld;

public class ChunkUtils {
    public static void requestChunk(ClientWorld world, int chunkX, int chunkZ) {
        try {
            var manager = world.getChunkManager();
            manager.getChunk(chunkX, chunkZ, net.minecraft.world.chunk.ChunkStatus.FULL, true);
        } catch(Exception e){ e.printStackTrace(); }
    }
    public static void setVisible(int chunkX, int chunkZ, boolean visible) {}
}
