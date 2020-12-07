package de.chaosmarc.aoc.twentytwenty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day7Part1 {
    public static void main(String[] args) throws IOException {
        Map<String, Set<String>> bagMap = new HashMap<>();
        FileReader fileReader = new FileReader("src/de/chaosmarc/aoc/twentytwenty/input/Day7.txt");
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            reader.lines().forEach(line -> {
                String[] split = line.replaceAll("bag[s]*\\.*", "").split(" contain ");
                String val = split[0].trim();
                for (String s : split[1].split(",")) {
                    String key = s.substring(2).trim();
                    if (bagMap.containsKey(key)) {
                        bagMap.get(key).add(val);
                    } else {
                        Set<String> set = new HashSet<>();
                        set.add(val);
                        bagMap.put(key, set);
                    }
                }
            });
        }
        Set<String> allowedBags = new HashSet<>();
        addParentBags(bagMap, allowedBags, "shiny gold");
        System.out.println("Solution: " + allowedBags.size());
    }

    public static void addParentBags(Map<String, Set<String>> possibleBags, Set<String> allowedBags, String bag) {
        for (String parent : possibleBags.getOrDefault(bag, new HashSet<>())) {
            allowedBags.add(parent);
            addParentBags(possibleBags, allowedBags, parent);
        }
    }
}
