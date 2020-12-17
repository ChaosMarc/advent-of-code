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
        List<List<Integer>> validTickets =
            tickets.stream().filter(t -> t.stream().noneMatch(f -> f < stats.getMin() || f > stats.getMax()))
                .collect(Collectors.toList());

        Map<Integer, List<Integer>> finalRuleMapping = new HashMap<>(); // rulePos, fieldPos
        while (finalRuleMapping.size() < tickets.get(0).size()) {
            Map<Integer, List<Integer>> ruleMapping = new HashMap<>();
            for (int i1 = 0; i1 < rules.size(); i1++) {
                int i = i1;
                for (int j1 = 0; j1 < tickets.get(0).size(); j1++) {
                    int j = j1;
                    if (finalRuleMapping.values().stream().noneMatch(x -> x.get(0) == j) && validTickets.stream()
                        .allMatch(
                            ticket -> (ticket.get(j) >= rules.get(i).get(0) && ticket.get(j) <= rules.get(i).get(1))
                                || (ticket.get(j) >= rules.get(i).get(2) && ticket.get(j) <= rules.get(i).get(3)))) {
                        List<Integer> rm = ruleMapping.containsKey(i1) ? ruleMapping.get(i1) : new ArrayList<>();
                        rm.add(j);
                        ruleMapping.put(i1, rm);
                    }
                }
            }
            finalRuleMapping.putAll(ruleMapping.entrySet().stream().filter(x -> x.getValue().size() == 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
        }

        System.out.println("Solution: " + finalRuleMapping.entrySet().stream().limit(6)
            .mapToLong(i -> validTickets.get(0).get(i.getValue().get(0))).reduce(1, (a, b) -> a * b));
    }
}