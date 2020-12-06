package de.chaosmarc.aoc.twentytwenty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day6Part1 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        Set<String> answers = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(
            new FileReader("src/de/chaosmarc/aoc/twentytwenty/input/Day6.txt"))) {
            String data;
            do {
                data = reader.readLine();
                if (data == null || data.equals("")) {
                    result += answers.size();
                    answers.clear();
                } else {
                    answers.addAll(Arrays.asList(data.split("")));
                }
            } while (data != null);
        }
        System.out.println("Solution: " + result);
    }
}
