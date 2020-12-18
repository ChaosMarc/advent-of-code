package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day7Part1 {
    public static void main(String[] args) throws IOException {
        Map<String, Set<String>> bagMap = new HashMap<>();
        for (String line : InputReader.read(2020, 7)) {
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
