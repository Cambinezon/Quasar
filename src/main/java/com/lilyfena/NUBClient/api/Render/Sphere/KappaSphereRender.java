package com.lilyfena.NUBClient.api.Render.Sphere;


import com.lilyfena.NUBClient.api.Other.RegionPos;
import com.lilyfena.NUBClient.api.Render.BTR;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

/**
 *
 *
 *
 * @author DoggLilY
 * @since v1.3_b2
 */
public class KappaSphereRender {

    public void prepareSphereRenderer() {
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        BTR.worldRenderContext.matrixStack().push();

        RegionPos region = BTR.getCameraRegion();
        BTR.applyRegionalRenderOffset(BTR.worldRenderContext.matrixStack(), region);

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
    }

    public void renderSpheres(ArrayList<RenderSphere> spheres) {
        Matrix4f matrix = BTR.worldRenderContext.matrixStack().peek().getPositionMatrix();
        Tessellator tessellator = RenderSystem.renderThreadTesselator();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        RenderSystem.setShader(GameRenderer::getPositionProgram);
        Vec3d regionVec = BTR.getCameraRegion().toVec3d();

        for (RenderSphere sphere : spheres) {
            int l = sphere.indicies.size();
            for (int i = 0; i < l; i++) {
                BTR.drawActualLine(sphere.vectors.get(sphere.indicies.get(i)), sphere.vectors.get(sphere.indicies.get((i+1))),
                        matrix, sphere.red, sphere.green, sphere.blue, sphere.alpha,
                        tessellator, bufferBuilder, regionVec);
            }
        }
    }

    public void stopSphereRenderer() {
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        RenderSystem.setShaderColor(1,1,1,1);

        BTR.worldRenderContext.matrixStack().pop();
    }

}
