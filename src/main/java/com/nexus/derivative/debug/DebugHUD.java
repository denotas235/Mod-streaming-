package com.nexus.derivative.debug;

import com.nexus.derivative.math.DerivativeState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class DebugHUD {

    public static void render() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null || client.textRenderer == null) return;

        MatrixStack matrices = new MatrixStack();

        client.textRenderer.draw(
            matrices,
            "VelX: " + String.format("%.2f", DerivativeState.getVelX()),
            10, 10, 0x00FF00
        );

        client.textRenderer.draw(
            matrices,
            "VelZ: " + String.format("%.2f", DerivativeState.getVelZ()),
            10, 20, 0x00FF00
        );
    }
}
