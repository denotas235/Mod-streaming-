package com.nexus.derivative.core;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class NexusDerivativeStreaming implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(this::onClientTick);
    }

    private void onClientTick(MinecraftClient client) {
        if (client.player == null || client.world == null) return;
        var player = client.player;
        DerivativeState.update(player.getX(), player.getZ(), client.getLastFrameDuration());
        ChunkStreamingController.update(client.world, player);
    }
}
