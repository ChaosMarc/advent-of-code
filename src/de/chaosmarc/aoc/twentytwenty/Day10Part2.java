package de.chaosmarc.aoc.twentytwenty;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day10Part2 {
    public static void main(String[] args) throws IOException {
        List<Integer> input = Day10Part1.getModifiedInput();

        // per block of 1s there are only so many combinations possible to remove some of them
        Map<Integer, Integer> patternValues = new HashMap<>();
        patternValues.put(0, 1);
        patternValues.put(1, 1);
        patternValues.put(2, 2); // Diff-Combinations: 1,1 + 2
        patternValues.put(3, 4); // Diff-Combinations: 1,1,1 + 2,1 + 1,2 + 3
        patternValues.put(4, 7); // Diff-Combinations: 1,1,1,1 + 2,1,1 + 1,2,1 + 1,1,2 + 2,2 + 3,1 + 1,3

        int oneCount = 0;
        long combinations = 1;
        for (int i = 1; i < input.size(); i++) {
            if (input.get(i) - input.get(i - 1) == 1) {
                oneCount++;
            } else {
                combinations *= patternValues.get(oneCount);
                oneCount = 0;
            }
        }
        System.out.println("Solution: " + combinations);
    }
}


