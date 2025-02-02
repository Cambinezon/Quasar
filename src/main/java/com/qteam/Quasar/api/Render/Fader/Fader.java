package com.qteam.Quasar.api.Render.Fader;

import com.qteam.Quasar.api.Render.Box.RenderBox;
import net.minecraft.util.math.Box;

public class Fader {
    public final float fadeDuration;
    private final long detectionTime;
    private final Box bp;
    public float r;
    public float g;
    public float b;
    public float a;

    public Fader(Box bp, float fadeDuration, float r, float g, float b, float a) {
        this.fadeDuration = fadeDuration;
        this.detectionTime = System.currentTimeMillis();
        this.bp = bp;

        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public float fade() {
        float elapsed = (System.currentTimeMillis() - this.detectionTime) / 1000.0f;
        return Math.max(0, 1.0f - elapsed / this.fadeDuration);
    }

    public RenderBox getFadingRenderBox() {
        a *= this.fade();
        return new RenderBox(bp,
                this.r,this.g,this.b, this.a, this.r,this.g,this.b, this.a * .30f);
    }

    public RenderBox getExpandingRenderBox() {
        this.a *= this.fade();
        return new RenderBox(bp.expand(bp.getLengthX() - a, bp.getLengthY() - a, bp.getLengthZ() - a),
                this.r,this.g,this.b, this.a, this.r,this.g,this.b, this.a * .30f);
    }
}
