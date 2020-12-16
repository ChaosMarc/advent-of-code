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

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String line : input) {
            if (line.contains(":") || line.equals("")) {
                String[] split = line.split(" |-");
                if (split.length > 2) {
                    min = Math.min(min, Integer.parseInt(split[split.length - 5]));
                    max = Math.max(max, Integer.parseInt(split[split.length - 1]));
                }
            } else {
                tickets.add(Arrays.stream(line.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
            }
        }

        List<Integer> invalidFields = new ArrayList<>();
        for (List<Integer> ticket : tickets) {
            for (int field : ticket) {
                if (field < min || field > max) {
                    invalidFields.add(field);
                }
            }
        }

        System.out.println("Solution: " + invalidFields.stream().reduce(0, Integer::sum));
    }
}