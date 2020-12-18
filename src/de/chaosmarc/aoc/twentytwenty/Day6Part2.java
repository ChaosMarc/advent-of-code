package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day6Part2 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        int count = 0;
        int groupSize = 0;
        Map<String, Integer> answers = new HashMap<>();
        List<String> input = InputReader.read(2020, 6);
        for (int i = 0; i <= input.size(); i++) {
            if (i == input.size() || input.get(i).equals("")) {
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
            for (String s : input.get(i).split("")) {
                answers.merge(s, 1, Integer::sum);
            }
            groupSize++;
        }

        System.out.println("Solution: " + result);
    }
}
