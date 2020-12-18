package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4Part1 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        List<String> fields = new ArrayList<>();
        List<String> input = InputReader.read(2020, 4);
        input.add("");
        for (String data : input) {
            if (data.equals("")) {
                if (fields.size() == 7) {
                    result++;
                }
                fields.clear();
                continue;
            }
            String[] split = data.split(" ");
            for (String s : split) {
                if (s.startsWith("byr") || s.startsWith("iyr") || s.startsWith("eyr") || s.startsWith("hgt") || s
                    .startsWith("hcl") || s.startsWith("ecl") || s.startsWith("pid")) {
                    fields.add(s);
                }
            }
        }
        System.out.println("Solution: " + result);
    }
}
