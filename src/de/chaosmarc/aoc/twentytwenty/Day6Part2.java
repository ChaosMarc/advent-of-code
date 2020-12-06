package de.chaosmarc.aoc.twentytwenty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day6Part2 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        int groupSize = 0;
        Map<String, Integer> answers = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(
            new FileReader("src/de/chaosmarc/aoc/twentytwenty/input/Day6.txt"))) {
            String data;
            do {
                data = reader.readLine();
                if (data == null || data.equals("")) {
                    Set<String> sameAnswers = new HashSet<>();
                    for (Map.Entry<String, Integer> a : answers.entrySet()) {
                        if (a.getValue() == groupSize) {
                            sameAnswers.add(a.getKey());
                        }
                    }
                    result += sameAnswers.size();
                    answers.clear();
                    groupSize = 0;
                    continue;
                }
                for (String s : data.split("")) {
                    if (answers.containsKey(s)) {
                        answers.put(s, answers.get(s) + 1);
                    } else {
                        answers.put(s, 1);
                    }
                }
                groupSize++;
            } while (data != null);
        }

        System.out.println("Solution: " + result);
    }
}
