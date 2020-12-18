package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day16Part2 {
    public static void main(String[] args) throws IOException {
        List<String> input = InputReader.read(2020, 16);
        List<List<Integer>> tickets = new ArrayList<>();
        List<List<Integer>> rules = new ArrayList<>();

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
                }
            } else {
                tickets.add(Arrays.stream(line.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
            }
        }

        IntSummaryStatistics stats = rules.stream().flatMap(List::stream).collect(Collectors.toList()).stream()
            .collect(Collectors.summarizingInt(Integer::intValue));
        tickets = tickets.stream().filter(t -> t.stream().noneMatch(f -> f < stats.getMin() || f > stats.getMax()))
            .collect(Collectors.toList());
        List<Integer> myTicket = tickets.get(0);
        int fieldCount = myTicket.size();
        List<List<Integer>> finalTickets = tickets;

        Map<Integer, Integer> finalRuleMapping = new HashMap<>(); // rulePos, fieldPos
        while (finalRuleMapping.size() < fieldCount) {
            Map<Integer, Integer> ruleMapping = new HashMap<>(); // rulePos, possible fieldPos
            rules.forEach(rule -> {
                int rulePos = rules.indexOf(rule);
                IntStream.rangeClosed(0, fieldCount - 1).filter(
                    fieldPos -> finalRuleMapping.values().stream().noneMatch(r -> r == fieldPos) && finalTickets
                        .stream().allMatch(t -> isValid(t.get(fieldPos), rule)))
                    .forEach(fieldPos -> ruleMapping.put(rulePos, ruleMapping.containsKey(rulePos) ? -1 : fieldPos));
            });

            finalRuleMapping.putAll(ruleMapping.entrySet().stream().filter(x -> x.getValue() != -1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        }

        System.out.println(
            "Solution: " + finalRuleMapping.entrySet().stream().limit(6).mapToLong(i -> myTicket.get(i.getValue()))
                .reduce(1, (a, b) -> a * b));
    }

    public static boolean isValid(int value, List<Integer> rule) {
        return (value >= rule.get(0) && value <= rule.get(1)) || (value >= rule.get(2) && value <= rule.get(3));
    }
}