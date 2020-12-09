package de.chaosmarc.aoc.twentytwenty;

import java.io.IOException;

public class Day3Part2 {
    public static void main(String[] args) throws IOException {
        int result = 1;
        int[][] slopes = new int[][] {{1, 1}, {3, 1}, {5, 1}, {7, 1}, {1, 2}};
        for (int[] slope : slopes) {
            result *= Day3Part1.countTrees(slope[0], slope[1]);
        }
        System.out.println("Solution: " + result);
    }
}
