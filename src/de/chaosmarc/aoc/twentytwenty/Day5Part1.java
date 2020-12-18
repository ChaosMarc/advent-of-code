package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.InputReader;

import java.io.IOException;

public class Day5Part1 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        for (String data : InputReader.read(2020, 5)) {
            int row = Integer.parseInt(data.substring(0, 7).replace("F", "0").replace("B", "1"), 2);
            int col = Integer.parseInt(data.substring(7).replace("L", "0").replace("R", "1"), 2);
            int id = row * 8 + col;
            result = Math.max(result, id);
        }

        System.out.println("Solution: " + result);
    }
}
