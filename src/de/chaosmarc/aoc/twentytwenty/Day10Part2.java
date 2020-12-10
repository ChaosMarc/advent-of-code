package de.chaosmarc.aoc.twentytwenty;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day10Part2 {

    private static final Map<Integer, Integer> patternValues = new HashMap<>();

    public static void main(String[] args) throws IOException {
        List<Integer> input = Day10Part1.getModifiedInput();
        int oneCount = 0;
        long combinations = 1;
        for (int i = 1; i < input.size(); i++) {
            if (input.get(i) - input.get(i - 1) == 1) {
                oneCount++;
            } else {
                combinations *= getPossibleCombinationCount(oneCount);
                oneCount = 0;
            }
        }
        System.out.println("Solution: " + combinations);
    }

    private static int getPossibleCombinationCount(int count) {
        // per block of 1s there are only so many combinations possible when removing some of them
        // block of 2x 1s = 1,1 + 2 (2)
        // block of 3x 1s = 1,1,1 + 2,1 + 1,2 + 3 (4)
        // block of 4x 1s = 1,1,1,1 + 2,1,1 + 1,2,1 + 1,1,2 + 2,2 + 3,1 + 1,3 (7)
        // which are the Tribonacci Numbers
        if (!patternValues.containsKey(count)) {
            if (count <= 1) {
                patternValues.put(count, 1);
            } else if (count == 2) {
                patternValues.put(count, 2);
            } else {
                patternValues.put(
                    count, getPossibleCombinationCount(count - 1) + getPossibleCombinationCount(count - 2)
                        + getPossibleCombinationCount(count - 3));
            }
        }
        return patternValues.get(count);
    }
}


