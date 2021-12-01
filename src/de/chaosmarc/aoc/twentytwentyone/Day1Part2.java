package de.chaosmarc.aoc.twentytwentyone;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day1Part2 {

    public static void main(String[] args) throws IOException {
        List<Long> input = InputReader.read(2021, 1).stream().map(Long::valueOf).collect(Collectors.toList());
        long incrementCount = countIncrements(input);
        System.out.println("Solution: " + incrementCount);
    }

    public static long countIncrements(List<Long> list) {
        long increments = 0;
        for (int i = 0; i < list.size() - 3; i++) {
            long prev = list.get(i) + list.get(i + 1) + list.get(i + 2);
            long cur = list.get(i + 1) + list.get(i + 2) + list.get(i + 3);
            increments += cur > prev ? 1 : 0;
        }
        return increments;
    }
}
