package com.qteam.Quasar.api.Render.Sphere;

import net.minecraft.util.math.Vec3d;

import java.util.ArrayList;
import java.util.List;


/**
 *
 *
 *
 * @author DoggLilY
 * @since v1.3_b2
 */
public class RenderSphere {

    public final Vec3d position;
    public final int complexity;
    public final float range;
    public final List<Vec3d> vectors;
    public final List<Integer> indicies;
    public final float red;
    public final float green;
    public final float blue;
    public final float alpha;

    public RenderSphere(Vec3d position, int complexity, float range, float r, float g, float b, float a) {

        this.complexity = complexity;
        this.position = position;
        this.range = range;
        this.vectors = this.generateSphereVectors();
        this.indicies = this.generateSphereIndices();
        this.red = r;
        this.green = g;
        this.blue = b;
        this.alpha = a;

    }

    public List<Vec3d> generateSphereVectors() {
        List<Vec3d> positions = new ArrayList<>();

        double step = Math.PI / complexity;

        for (double theta = 0; theta < 2 * Math.PI; theta += step) {
            for (double phi = 0; phi < Math.PI; phi += step) {
                double x = range * Math.sin(phi) * Math.cos(theta);
                double y = range * Math.sin(phi) * Math.sin(theta);
                double z = range * Math.cos(phi);

                positions.add(new Vec3d(x, y, z).add(position));
            }
        }

        return positions;
    }


    public List<Integer> generateSphereIndices() {
        List<Integer> indices = new ArrayList<>();

        int latitudeCount = complexity + 1;
        int longitudeCount = complexity * 2;

        for (int lat = 0; lat < latitudeCount - 1; lat++) {
            for (int lon = 0; lon < longitudeCount; lon++) {

                int current = lat * longitudeCount + lon;
                int next = current + longitudeCount;

                indices.add(current);
                indices.add(next);
                indices.add((current + 1) % longitudeCount + lat * longitudeCount);

                indices.add((current + 1) % longitudeCount + lat * longitudeCount);
                indices.add(next);
                indices.add((next + 1) % longitudeCount + (lat + 1) * longitudeCount);
            }
        }

        return indices;
    }
}
