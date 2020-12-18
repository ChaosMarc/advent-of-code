package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day9Part2 {

    public static void main(String[] args) throws IOException {
        List<Long> input = InputReader.read(2020, 9).stream().map(Long::valueOf).collect(Collectors.toList());
        List<Long> summands = findSummands(input, Day9Part1.findNumber(input));
        System.out.println("Solution: " + (Collections.min(summands) + Collections.max(summands)));
    }

    public static List<Long> findSummands(List<Long> input, long number) {
        ArrayList<Long> summands = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            summands.add(input.get(i));
            for (int j = i + 1; j < input.size(); j++) {
                summands.add(input.get(j));
                long sum = getSum(summands);
                if (sum == number) {
                    return summands;
                } else if (sum > number) {
                    summands.clear();
                    break;
                }
            }
        }
        return new ArrayList<>();
    }

    public static long getSum(List<Long> summands) {
        long sum = 0;
        for (Long summand : summands) {
            sum += summand;
        }
        return sum;
    }
}
