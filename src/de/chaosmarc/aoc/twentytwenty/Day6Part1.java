package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.Helper;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6Part1 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        Set<String> answers = new HashSet<>();
        List<String> input = Helper.readInput(2020, 6);
        for (int i = 0; i <= input.size(); i++) {
            if (i == input.size() || input.get(i).equals("")) {
                result += answers.size();
                answers.clear();
            } else {
                answers.addAll(Arrays.asList(input.get(i).split("")));
            }
        }
        System.out.println("Solution: " + result);
    }
}
