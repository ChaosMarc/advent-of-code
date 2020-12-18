package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.InputReader;

import java.io.IOException;
import java.util.List;

public class Day3Part1 {
    public static void main(String[] args) throws IOException {
        System.out.println("Solution: " + countTrees(3, 1));
    }

    public static int countTrees(int right, int down) throws IOException {
        List<String> input = InputReader.read(2020, 3);
        int trees = 0;
        int pos = 0;
        for (int row = down; row < input.size(); row += down) {
            pos = (pos + right) % (input.get(row).length());
            if (input.get(row).charAt(pos) == '#') {
                trees++;
            }
        }
        return trees;
    }
}
