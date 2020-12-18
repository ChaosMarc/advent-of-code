package de.chaosmarc.aoc.twentyfifteen;

import de.chaosmarc.aoc.InputReader;

import java.io.IOException;
import java.util.*;

public class Day9Part1 {
    public static void main(String[] args) throws IOException {
        Map<List<String>, Integer> distanceMap = createDistanceMap();
        List<List<String>> permutations = createPermutations(distanceMap);

        int shortestRoute = Integer.MAX_VALUE;
        for (List<String> permutation : permutations) {
            int routeDistance = calcRouteDistance(distanceMap, permutation);
            if (routeDistance < shortestRoute) {
                shortestRoute = routeDistance;
                System.out.println("Solution: " + routeDistance + " - " + permutation.toString());
            }
        }
    }

    public static int calcRouteDistance(Map<List<String>, Integer> distanceMap, List<String> route) {
        int routeDistance = 0;
        for (int i = 0; i < route.size() - 1; i++) {
            List<String> distance = new ArrayList<>();
            distance.add(route.get(i));
            distance.add(route.get(i + 1));
            routeDistance += distanceMap.get(distance);
        }
        return routeDistance;
    }

    public static Map<List<String>, Integer> createDistanceMap() throws IOException {
        Map<List<String>, Integer> distances = new HashMap<>();
        for (String data : InputReader.read(2015, 9)) {
            String[] split = data.split(" ");
            List<String> distance = new ArrayList<>();
            distance.add(split[0]);
            distance.add(split[2]);
            distances.put(distance, Integer.parseInt(split[4]));
            distance = new ArrayList<>();
            distance.add(split[2]);
            distance.add(split[0]);
            distances.put(distance, Integer.parseInt(split[4]));
        }
        return distances;
    }

    public static Set<String> createLocationList(Map<List<String>, Integer> distanceMap) {
        Set<String> locations = new HashSet<>();
        for (List<String> key : distanceMap.keySet()) {
            locations.add(key.get(0));
            locations.add(key.get(1));
        }

        return locations;
    }

    // https://www.programcreek.com/2013/02/leetcode-permutations-java/
    public static List<List<String>> createPermutations(Map<List<String>, Integer> distanceMap) {
        Set<String> list = createLocationList(distanceMap);
        List<List<String>> result = new ArrayList<>();

        //start from an empty list
        result.add(new ArrayList<>());

        for (String s : list) {
            //list of list in current iteration of the array num
            List<List<String>> current = new ArrayList<>();

            for (List<String> l : result) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < l.size() + 1; j++) {
                    // + add num[i] to different locations
                    l.add(j, s);

                    ArrayList<String> temp = new ArrayList<>(l);
                    current.add(temp);

                    // - remove num[i] add
                    l.remove(j);
                }
            }

            result = new ArrayList<>(current);
        }

        return result;
    }
}
