package com.qteam.Quasar.mixins;

import com.qteam.Quasar.Q;
//import com.qteam.Quasar.api.FileSystem.ConfigSystem.ConfigSystem;
import com.qteam.Quasar.api.Render.QR;
import com.qteam.Quasar.api.Events.HITLEREvents.TickEvent;
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
        Q.EVENT_BUS.activate(new TickEvent.ClientTickEvent());
        Q.INSTANCE.onTick();
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    public void modifyMinecraftInit(RunArgs args, CallbackInfo ci) {
        QR.init();
//        ConfigSystem.loadConfig();
        Q.INSTANCE.loadShaders();
    }

}
