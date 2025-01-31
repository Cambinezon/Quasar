package com.lilyfena.NUBClient.mixins;

import com.lilyfena.NUBClient.DY;
//import com.lilyfena.NUBClient.api.FileSystem.ConfigSystem.ConfigSystem;
import com.lilyfena.NUBClient.api.Render.BTR;
import com.lilyfena.NUBClient.api.Events.HITLEREvents.TickEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    public void onTick(CallbackInfo ci) {
        DY.EVENT_BUS.activate(new TickEvent.ClientTickEvent());
        DY.INSTANCE.onTick();
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    public void modifyMinecraftInit(RunArgs args, CallbackInfo ci) {
        BTR.init();
//        ConfigSystem.loadConfig();
        DY.INSTANCE.loadShaders();
    }

}
