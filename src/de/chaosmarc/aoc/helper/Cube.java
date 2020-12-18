package de.chaosmarc.aoc.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cube {
    private final int x;
    private final int y;
    private final int z;

    public Cube(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "," + z + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cube cube = (Cube) o;
        return x == cube.x && y == cube.y && z == cube.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    public List<Cube> getNeighbors() {
        List<Cube> neighbors = new ArrayList<>();
        for (int addX = -1; addX <= 1; addX++) {
            for (int addY = -1; addY <= 1; addY++) {
                for (int addZ = -1; addZ <= 1; addZ++) {
                    int newX = this.x + addX;
                    int newY = this.y + addY;
                    int newZ = this.z + addZ;
                    if (this.x != newX || this.y != newY || this.z != newZ) {
                        neighbors.add(new Cube(newX, newY, newZ));
                    }
                }
            }
        }
        return neighbors;
    }
}

