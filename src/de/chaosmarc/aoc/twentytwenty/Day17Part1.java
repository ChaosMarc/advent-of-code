package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.helper.Cube;
import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day17Part1 {
    private static final Map<Cube, Boolean> CUBES = new HashMap<>();

    public static void main(String[] args) throws IOException {
        List<String> input = InputReader.read(2020, 17);
        for (int y = 0; y < input.size(); y++) {
            char[] chars = input.get(y).toCharArray();
            for (int x = 0; x < chars.length; x++) {
                CUBES.put(new Cube(x, y, 0), chars[x] == '#');
            }
        }

        Map<Cube, Boolean> newCubes;
        for (int i = 0; i < 6; i++) {
            // add non-existent neighbors
            newCubes = new HashMap<>();
            for (Map.Entry<Cube, Boolean> entry : CUBES.entrySet()) {
                for (Cube neighbor : entry.getKey().getNeighbors()) {
                    if (!CUBES.containsKey(neighbor)) {
                        newCubes.put(neighbor, false);
                    }
                }
            }
            CUBES.putAll(newCubes);

            // toggle cubes
            newCubes = new HashMap<>();
            for (Map.Entry<Cube, Boolean> entry : CUBES.entrySet()) {
                Cube cube = entry.getKey();
                newCubes.put(cube, toggle(cube));
            }
            CUBES.putAll(newCubes);
        }
        System.out.println("Solution: " + CUBES.entrySet().stream().filter(Map.Entry::getValue).count());
    }

    public static boolean toggle(Cube cube) {
        boolean isActive = CUBES.get(cube);
        List<Cube> activeNeighbors =
            cube.getNeighbors().stream().filter(n -> CUBES.containsKey(n) && CUBES.get(n)).collect(Collectors.toList());
        if (isActive && (activeNeighbors.size() < 2 || activeNeighbors.size() > 3)) {
            return false;
        } else if (!isActive && activeNeighbors.size() == 3) {
            return true;
        } else {
            return CUBES.get(cube);
        }
    }
}
