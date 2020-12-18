package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.InputReader;

import java.io.IOException;

public class Day2Part1 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        for (String line : InputReader.read(2020, 2)) {
            String[] input = line.split("(: )|[- ]");
            int occurrences = input[3].split(input[2], -1).length - 1;
            if (occurrences >= Integer.parseInt(input[0]) && occurrences <= Integer.parseInt(input[1])) {
                result++;
            }
        }
        System.out.println("Solution: " + result);
    }
}
