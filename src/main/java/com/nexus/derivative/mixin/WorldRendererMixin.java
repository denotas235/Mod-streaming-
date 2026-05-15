package com.nexus.derivative.mixin;

import com.nexus.derivative.render.VisibilityController;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public abstract class WorldRendererMixin {
    @Inject(method = "render", at = @At("HEAD"))
    private void onRender(Camera camera, Object frustum, Object matrices, CallbackInfo ci) {
        VisibilityController.updateVisibleQuadrants(camera);
    }
}
