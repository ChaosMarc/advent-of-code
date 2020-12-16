package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.Helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day16Part1 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput(2020, 16);
        List<List<Integer>> tickets = new ArrayList<>();

        int firstRuleMin = Integer.MAX_VALUE;
        int firstRuleMax = Integer.MIN_VALUE;
        int secondRuleMin = Integer.MAX_VALUE;
        int secondRuleMax = Integer.MIN_VALUE;
        for (String line : input) {
            if (line.contains(":") || line.equals("")) {
                String[] split = line.split(" |-");
                if (split.length > 2) {
                    firstRuleMin = Math.min(firstRuleMin, Integer.parseInt(split[split.length - 5]));
                    firstRuleMax = Math.max(firstRuleMax, Integer.parseInt(split[split.length - 4]));
                    secondRuleMin = Math.min(secondRuleMin, Integer.parseInt(split[split.length - 2]));
                    secondRuleMax = Math.max(secondRuleMax, Integer.parseInt(split[split.length - 1]));
                }
            } else {
                tickets.add(Arrays.stream(line.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
            }
        }

        List<Integer> invalidFields = new ArrayList<>();
        for (List<Integer> ticket : tickets) {
            for (int field : ticket) {
                if ((firstRuleMax >= secondRuleMin && (field < firstRuleMin || field > secondRuleMax)) || (
                    firstRuleMax < secondRuleMin && !((field >= firstRuleMin && field <= firstRuleMax) || (
                        field >= secondRuleMin && field <= secondRuleMax)))) {
                    invalidFields.add(field);
                }
            }
        }

        System.out.println("Solution: " + invalidFields.stream().reduce(0, Integer::sum));
    }
}