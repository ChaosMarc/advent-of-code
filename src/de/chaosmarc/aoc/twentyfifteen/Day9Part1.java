package de.chaosmarc.aoc.twentyfifteen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day9Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Map<List<String>, Integer> distanceMap = createDistanceMap();
        Set<String> locations = createLocationList(distanceMap);
        List<List<String>> permutations = permute(locations.toArray(new String[0]));

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

    public static Map<List<String>, Integer> createDistanceMap() throws FileNotFoundException {
        Map<List<String>, Integer> distances = new HashMap<>();
        File myObj = new File("src/de/chaosmarc/aoc/twentyfifteen/input/Day9.txt");
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(" ");
                List<String> distance = new ArrayList<>();
                distance.add(data[0]);
                distance.add(data[2]);
                distances.put(distance, Integer.parseInt(data[4]));
                distance = new ArrayList<>();
                distance.add(data[2]);
                distance.add(data[0]);
                distances.put(distance, Integer.parseInt(data[4]));
            }
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
    public static List<List<String>> permute(String[] list) {
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
