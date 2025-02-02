package com.qteam.Quasar.mixins;

//import com.ferra13671.BThack.Core.Client;

import net.minecraft.client.render.BackgroundRenderer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BackgroundRenderer.class)
public class MixinBackgroundRenderer {

//    @Inject(method = "applyFog", at = @At("TAIL"))
//    private static void modifyApplyFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci) {
//        if (ModuleManager.NoFog.isEnabled()) {
//            if (fogType == BackgroundRenderer.FogType.FOG_TERRAIN) {
//                RenderSystem.setShaderFogStart(viewDistance * 4);
//                RenderSystem.setShaderFogEnd(viewDistance * 4.25f);
//            }
//        }
//    }
}
