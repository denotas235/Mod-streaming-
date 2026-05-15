package com.nexus.derivative.render;

import com.nexus.derivative.util.ChunkUtils;
import net.minecraft.client.network.ClientPlayerEntity;

public class VisibilityController {
    public static void update(ClientPlayerEntity player, int chunkX, int chunkZ) {
        ChunkUtils.setVisible(chunkX, chunkZ, true);
        ChunkUtils.setVisible(chunkX + 1, chunkZ, true);
        ChunkUtils.setVisible(chunkX, chunkZ + 1, true);
    }

    public static void updateVisibleQuadrants(Object camera) {
        // Hook WorldRendererMixin
    }
}
