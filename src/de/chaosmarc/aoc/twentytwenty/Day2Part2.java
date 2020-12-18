package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.InputReader;

import java.io.IOException;

public class Day2Part2 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        for (String line : InputReader.read(2020, 2)) {
            String[] input = line.split("(: )|[- ]");
            boolean first = input[3].charAt(Integer.parseInt((input[0])) - 1) == input[2].charAt(0);
            boolean second = input[3].charAt(Integer.parseInt((input[1])) - 1) == input[2].charAt(0);
            if (first ^ second) {
                result++;
            }
        }
        System.out.println("Solution: " + result);
    }
}
