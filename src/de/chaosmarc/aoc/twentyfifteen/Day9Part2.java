package de.chaosmarc.aoc.twentyfifteen;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day9Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Map<List<String>, Integer> distanceMap = Day9Part1.createDistanceMap();
        Set<String> locations = Day9Part1.createLocationList(distanceMap);
        List<List<String>> permutations = Day9Part1.permute(locations.toArray(new String[0]));

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
