package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.Helper;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day10Part1 {

    public static void main(String[] args) throws IOException {
        List<Integer> input = getModifiedInput();
        System.out.println("Solution: " + (getDiffCount(input, 1) * getDiffCount(input, 3)));
    }

    public static int getDiffCount(List<Integer> input, int diff) {
        int diffCount = 0;
        for (int i = 1; i < input.size(); i++) {
            if (input.get(i) - input.get(i - 1) == diff) {
                diffCount++;
            }
        }
        return diffCount;
    }

    public static List<Integer> getModifiedInput() throws IOException {
        List<Integer> input =
            Helper.readInput(2020, 10).stream().map(Integer::valueOf).sorted().collect(Collectors.toList());
        Collections.reverse(input);
        input.add(0); // outlet
        Collections.reverse(input);
        input.add(input.get(input.size() - 1) + 3); // built-in
        return input;
    }
}
