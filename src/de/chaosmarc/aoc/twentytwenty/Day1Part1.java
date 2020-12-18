package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.InputReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day1Part1 {

    public static void main(String[] args) throws IOException {
        List<Long> input = InputReader.read(2020, 1).stream().map(Long::valueOf).collect(Collectors.toList());
        long[] twoNumbers = findTwoNumbers(input, 2020);
        System.out.println("Solution: " + (twoNumbers[0] * twoNumbers[1]));
    }

    public static long[] findTwoNumbers(List<Long> list, long number) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == number) {
                    return new long[] {list.get(i), list.get(j)};
                }
            }
        }
        return new long[] {};
    }
}
