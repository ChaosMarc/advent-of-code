package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.Helper;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Day16Part2 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput(2020, 16);
        List<List<Integer>> tickets = new ArrayList<>();
        List<List<Integer>> rules = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String line : input) {
            if (line.contains(":") || line.equals("")) {
                String[] split = line.split("[\\- ]");
                if (split.length > 2) {
                    List<Integer> rule = new ArrayList<>();
                    rule.add(Integer.parseInt(split[split.length - 5]));
                    rule.add(Integer.parseInt(split[split.length - 4]));
                    rule.add(Integer.parseInt(split[split.length - 2]));
                    rule.add(Integer.parseInt(split[split.length - 1]));
                    rules.add(rule);
                    min = Math.min(min, Integer.parseInt(split[split.length - 5]));
                    max = Math.max(max, Integer.parseInt(split[split.length - 1]));
                }
            } else {
                tickets.add(Arrays.stream(line.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
            }
        }

        List<List<Integer>> validTickets = new ArrayList<>();
        for (List<Integer> ticket : tickets) {
            boolean isValid = true;
            for (int field : ticket) {
                if (field < min || field > max) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                validTickets.add(ticket);
            }
        }

        int fieldCount = tickets.get(0).size();
        Map<Integer, List<Integer>> finalRuleMapping = new HashMap<>(); // rulePos, fieldPos
        while (finalRuleMapping.size() < fieldCount) {
            Map<Integer, List<Integer>> ruleMapping = new HashMap<>();
            for (int i = 0; i < rules.size(); i++) {
                List<Integer> rule = rules.get(i);
                if (finalRuleMapping.containsKey(i)) {
                    continue;
                }
                for (int j = 0; j < fieldCount; j++) {
                    boolean skip = false;
                    for (Map.Entry<Integer, List<Integer>> entry : finalRuleMapping.entrySet()) {
                        if (entry.getValue().get(0) == j) {
                            skip = true;
                            break;
                        }
                    }
                    if (skip) {
                        continue;
                    }

                    boolean ruleMatchesAllFields = true;
                    for (List<Integer> ticket : validTickets) {
                        Integer field = ticket.get(j);
                        if (!((field >= rule.get(0) && field <= rule.get(1)) || (field >= rule.get(2) && field <= rule
                            .get(3)))) {
                            ruleMatchesAllFields = false;
                            break;
                        }
                    }
                    if (ruleMatchesAllFields) {
                        List<Integer> rm = ruleMapping.containsKey(i) ? ruleMapping.get(i) : new ArrayList<>();
                        rm.add(j);
                        ruleMapping.put(i, rm);
                    }
                }
            }

            for (Map.Entry<Integer, List<Integer>> integerIntegerEntry : ruleMapping.entrySet()) {
                if (integerIntegerEntry.getValue().size() == 1) {
                    finalRuleMapping.put(integerIntegerEntry.getKey(), integerIntegerEntry.getValue());
                }
            }
        }

        long result = 1;
        for (int i = 0; i < 6; i++) {
            int field = finalRuleMapping.get(i).get(0);
            result *= validTickets.get(0).get(field);
        }

        System.out.println("Solution: " + result);
    }
}