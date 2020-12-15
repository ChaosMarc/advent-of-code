package de.chaosmarc.aoc.twentytwenty;

import java.util.HashMap;
import java.util.Map;

public class Day15Part1 {
    public static void main(String[] args) {
        System.out.println("Solution: " + findSpokenNumber(2020));
    }

    public static int findSpokenNumber(int nthNumber) {
        int[] input = new int[] {5, 1, 9, 18, 13, 8, 0};
        Map<Integer, int[]> spokenNumbers = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            // int[] = turn spoken in last, turn spoken in before last, # spoken before
            spokenNumbers.put(input[i], new int[] {i + 1, -1, 0});
        }
        int lastNumber = input[input.length - 1];
        int turn = input.length + 1;
        int nextNumber = -1;

        while (turn <= nthNumber) {
            int[] last = spokenNumbers.get(lastNumber);
            if (last[1] == -1) {
                nextNumber = 0;
            } else {
                nextNumber = last[0] - last[1];
            }
            if (spokenNumbers.containsKey(nextNumber)) {
                int[] next = spokenNumbers.get(nextNumber);
                spokenNumbers.put(nextNumber, new int[] {turn, next[0], next[2] + 1});
            } else {
                spokenNumbers.put(nextNumber, new int[] {turn, -1, 0});
            }
            lastNumber = nextNumber;
            turn++;
        }
        return nextNumber;
    }
}