package com.qteam.Quasar.api.Render.Line;
import net.minecraft.util.math.Vec3d;


/**
 *
 *
 *
 * @author DoggLilY
 * @since v1.3_b1
 */
public class RenderActualLine extends RenderLine {

    public final Vec3d startvec3d;

    public RenderActualLine(Vec3d vec3d, Vec3d start, float red, float green, float blue, float alpha) {
        super(vec3d, red, green, blue, alpha);
        this.startvec3d = start;
    }
}
