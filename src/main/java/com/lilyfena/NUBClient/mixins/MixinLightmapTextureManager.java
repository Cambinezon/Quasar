package com.lilyfena.NUBClient.mixins;

import net.minecraft.client.render.LightmapTextureManager;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LightmapTextureManager.class)
public class MixinLightmapTextureManager {

//    @Inject(method = "update", at = @At(value = "RETURN", target = "Lnet" +
//            "/minecraft/client/texture/NativeImage;setColor(III)V"))
//    private void hookUpdate(float delta, CallbackInfo ci)
//    {
//        GammaBrightnessEvent GammaBrightnessEvent = new GammaBrightnessEvent(delta);
//
//        NUBClient.EVENT_BUS.activate(GammaBrightnessEvent);
//
//        if (GammaBrightnessEvent.isCancelled())
//        {
//        }
//    }
}
