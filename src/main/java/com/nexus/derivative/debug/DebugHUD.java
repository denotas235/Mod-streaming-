package com.nexus.derivative.debug;

import com.nexus.derivative.math.DerivativeState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.font.TextRenderer;
import org.joml.Matrix4f;

public class DebugHUD {

    public static void render() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null || client.textRenderer == null) return;

        MatrixStack matrices = new MatrixStack();
        Matrix4f matrix = matrices.peek().getPositionMatrix();
        VertexConsumerProvider.Immediate provider = client.getBufferBuilders().getEntityVertexConsumers();

        TextRenderer tr = client.textRenderer;

        tr.draw(
            "VelX: " + String.format("%.2f", DerivativeState.getVelX()),
            10f, 10f,
            0x00FF00,
            false,
            matrix,
            provider,
            TextRenderer.TextLayerType.NORMAL,
            0,
            0xF000F0
        );

        tr.draw(
            "VelZ: " + String.format("%.2f", DerivativeState.getVelZ()),
            10f, 20f,
            0x00FF00,
            false,
            matrix,
            provider,
            TextRenderer.TextLayerType.NORMAL,
            0,
            0xF000F0
        );

        provider.draw();
    }
}
