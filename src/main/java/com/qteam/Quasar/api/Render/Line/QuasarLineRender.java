package com.qteam.Quasar.api.Render.Line;

import com.qteam.Quasar.api.Render.QR;
import com.qteam.Quasar.impl.Mc;
import com.qteam.Quasar.api.Other.RegionPos;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;


/**
 *
 *
 *
 * @author Ferra13671
 * @since core
 */
public final class QuasarLineRender implements Mc {

    public void prepareLineRenderer() {
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        QR.worldRenderContext.matrixStack().push();

        RegionPos region = QR.getCameraRegion();
        QR.applyRegionalRenderOffset(QR.worldRenderContext.matrixStack(), region);

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
    }

    public void renderLines(List<RenderLine> lines) {
        Matrix4f matrix = QR.worldRenderContext.matrixStack().peek().getPositionMatrix();
        Tessellator tessellator = RenderSystem.renderThreadTesselator();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        RenderSystem.setShader(GameRenderer::getPositionProgram);
        Vec3d regionVec = QR.getCameraRegion().toVec3d();

        for (RenderLine line : lines) {
            if (line instanceof RenderActualLine) {
                QR.drawActualLine(line.vec3d, ((RenderActualLine) line).startvec3d, matrix, line.red, line.green, line.blue, line.alpha, tessellator, bufferBuilder, regionVec);
            } else {
                QR.trace(line.vec3d, matrix, mc.getTickDelta(), line.red, line.green, line.blue, line.alpha, tessellator, bufferBuilder, regionVec);
            }
        }
    }

    public void stopLineRenderer() {
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        RenderSystem.setShaderColor(1,1,1,1);

        QR.worldRenderContext.matrixStack().pop();
    }

    /**
     *
     *
     *
     * @since v1.3_b2
     * @param boxes
     */
    public void qRender(ArrayList<RenderLine> boxes) {
        prepareLineRenderer();
        renderLines(boxes);
        stopLineRenderer();
    }
}
