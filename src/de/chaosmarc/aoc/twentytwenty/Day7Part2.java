package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day7Part2 {
    public static void main(String[] args) throws IOException {
        Map<String, Map<String, Integer>> bagMap = new HashMap<>();
        for (String line : InputReader.read(2020, 7)) {
            String[] split = line.replaceAll("bag[s]*\\.*", "").split(" contain ");
            String key = split[0].trim();
            for (String s : split[1].split(",")) {
                String amountStr = s.substring(0, 2).trim();
                if (!amountStr.equals("no")) {
                    bagMap.computeIfAbsent(key, k -> new HashMap<>())
                        .merge(s.substring(2).trim(), Integer.parseInt(amountStr), Integer::sum);
                }
            }
        }
        System.out.println("Solution: " + countBags(bagMap, "shiny gold"));
    }

    public static int countBags(Map<String, Map<String, Integer>> bagMap, String bag) {
        int count = 0;
        if (bagMap.containsKey(bag)) {
            for (Map.Entry<String, Integer> child : bagMap.get(bag).entrySet()) {
                count += child.getValue() + child.getValue() * countBags(bagMap, child.getKey());
            }
            return count;
        }
        return count;
    }
}
