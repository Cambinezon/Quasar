package com.lilyfena.NUBClient.mixins;

import com.lilyfena.NUBClient.DY;
import com.lilyfena.NUBClient.api.Events.HITLEREvents.RenderHudPostEvent;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {

//    @Inject(method = "render", at = @At("RETURN"))
//    public void renderHud(DrawContext context, float tickDelta, CallbackInfo ci) {
//        NUBClient.Hud.render(context.getMatrices(), tickDelta);
//        NUBClient.postInit();
//    }

    @Inject(method = "render", at = @At("TAIL"))
    public void modifyRenderPost(DrawContext drawContext, float tickDelta, CallbackInfo callbackInfo) {
        //RenderSystem.enableBlend();
        //RenderSystem.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        DY.EVENT_BUS.activate(new RenderHudPostEvent(tickDelta));
        //RenderSystem.setShaderColor(1, 1, 1, 1);
        //RenderSystem.setShader(GameRenderer::getPositionColorProgram);
    }
}
