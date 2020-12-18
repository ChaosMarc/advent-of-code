package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.InputReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day1Part2 {
    public static void main(String[] args) throws IOException {
        List<Long> input = InputReader.read(2020, 1).stream().map(Long::valueOf).collect(Collectors.toList());
        long[] threeNumbers = findThreeNumbers(input, 2020);
        System.out.println("Solution: " + (threeNumbers[0] * threeNumbers[1] * threeNumbers[2]));
    }

    public static long[] findThreeNumbers(List<Long> list, long number) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) >= number) {
                    continue;
                }
                for (int k = j + 1; k < list.size(); k++) {
                    long sum = list.get(i) + list.get(j) + list.get(k);
                    if (sum == number) {
                        return new long[] {list.get(i), list.get(j), list.get(k)};
                    }
                }
            }
        }
        return new long[] {};
    }
}
