package de.chaosmarc.aoc.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HyperCube {
    private final int x;
    private final int y;
    private final int z;
    private final int w;

    public HyperCube(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "," + z + "," + w + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HyperCube cube = (HyperCube) o;
        return x == cube.x && y == cube.y && z == cube.z && w == cube.w;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, w);
    }

    public List<HyperCube> getNeighbors() {
        List<HyperCube> neighbors = new ArrayList<>();
        for (int addX = -1; addX <= 1; addX++) {
            for (int addY = -1; addY <= 1; addY++) {
                for (int addZ = -1; addZ <= 1; addZ++) {
                    for (int addW = -1; addW <= 1; addW++) {
                        int newX = this.x + addX;
                        int newY = this.y + addY;
                        int newZ = this.z + addZ;
                        int newW = this.w + addW;
                        if (this.x != newX || this.y != newY || this.z != newZ || this.w != newW) {
                            neighbors.add(new HyperCube(newX, newY, newZ, newW));
                        }
                    }
                }
            }
        }
        return neighbors;
    }
}
