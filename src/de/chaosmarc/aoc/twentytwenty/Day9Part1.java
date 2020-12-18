package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day9Part1 {

    public static void main(String[] args) throws IOException {
        List<Long> input = InputReader.read(2020, 9).stream().map(Long::valueOf).collect(Collectors.toList());
        System.out.println("Solution: " + findNumber(input));
    }

    public static long findNumber(List<Long> input) {
        for (int i = 25; i < input.size(); i++) {
            long[] twoNumbers = Day1Part1.findTwoNumbers(input.subList(i - 25, i), input.get(i));
            if (twoNumbers.length != 2) {
                return input.get(i);
            }
        }
        return -1;
    }
}
