package de.chaosmarc.aoc.twentyfifteen;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day9Part2 {
    public static void main(String[] args) throws IOException {
        Map<List<String>, Integer> distanceMap = Day9Part1.createDistanceMap();
        List<List<String>> permutations = Day9Part1.createPermutations(distanceMap);

        int longestRoute = 0;
        for (List<String> permutation : permutations) {
            int routeDistance = Day9Part1.calcRouteDistance(distanceMap, permutation);
            if (routeDistance > longestRoute) {
                longestRoute = routeDistance;
                System.out.println("Solution: " + routeDistance + " - " + permutation.toString());
            }
        }
    }
}
