package com.nexus.derivative.mixin;

import net.minecraft.client.world.ClientChunkManager;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.world.chunk.ChunkStatus;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientChunkManager.class)
public class ClientChunkManagerMixin {

    @Inject(method = "getChunk", at = @At("HEAD"))
    private void onGetChunk(int x, int z, ChunkStatus status, boolean create, CallbackInfoReturnable<WorldChunk> cir) {
        // hook correto para 1.21.1
    }
}
