package de.chaosmarc.aoc.twentytwentyone;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day1Part1 {

    public static void main(String[] args) throws IOException {
        List<Long> input = InputReader.read(2021, 1).stream().map(Long::valueOf).collect(Collectors.toList());
        long incrementCount = countIncrements(input);
        System.out.println("Solution: " + incrementCount);
    }

    public static long countIncrements(List<Long> list) {
        long increments = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            increments += list.get(i + 1) > list.get(i) ? 1 : 0;
        }
        return increments;
    }
}
