package com.nexus.derivative.render;

import net.minecraft.client.network.ClientPlayerEntity;

public class VisibilityController {

    public static boolean shouldRenderChunk(int cx, int cz, ClientPlayerEntity player) {

        double dx = (cx << 4) - player.getX();
        double dz = (cz << 4) - player.getZ();

        double distSq = dx*dx + dz*dz;

        return distSq < 300 * 300;
    }
}
