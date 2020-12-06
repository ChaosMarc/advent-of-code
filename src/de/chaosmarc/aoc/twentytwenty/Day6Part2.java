package de.chaosmarc.aoc.twentytwenty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day6Part2 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        int count = 0;
        int groupSize = 0;
        Map<String, Integer> answers = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(
            new FileReader("src/de/chaosmarc/aoc/twentytwenty/input/Day6.txt"))) {
            String data;
            do {
                data = reader.readLine();
                if (data == null || data.equals("")) {
                    for (Map.Entry<String, Integer> a : answers.entrySet()) {
                        if (a.getValue() == groupSize) {
                            count++;
                        }
                    }
                    result += count;
                    answers.clear();
                    groupSize = 0;
                    count = 0;
                    continue;
                }
                for (String s : data.split("")) {
                    answers.merge(s, 1, Integer::sum);
                }
                groupSize++;
            } while (data != null);
        }

        System.out.println("Solution: " + result);
    }
}
