package com.nexus.derivative.mixin;

import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.Camera;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

    @Inject(method = "render", at = @At("HEAD"))
    private void onRender(Camera camera, float tickDelta, long limitTime, boolean renderBlockOutline, CallbackInfo ci) {
        // TODO: lógica de visibilidade derivativa
    }
}
