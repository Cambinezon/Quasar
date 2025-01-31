package com.lilyfena.NUBClient.mixins;

import com.lilyfena.NUBClient.DY;
import com.lilyfena.NUBClient.api.Events.HITLEREvents.Player.RenderWorldEvent;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.WorldRenderer;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class RenderMixin {

    @Inject(method = "render", at = @At("RETURN"))
    private void afterRender(CallbackInfo ci) {
        //MinecraftClient.getInstance().getProfiler().push("oyvey-render-3d");
        RenderSystem.clear(GL11.GL_DEPTH_BUFFER_BIT, MinecraftClient.IS_SYSTEM_MAC);
        DY.EVENT_BUS.activate(new RenderWorldEvent.End(DY.renderContext));
        //MinecraftClient.getInstance().getProfiler().pop();
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
    }
}
