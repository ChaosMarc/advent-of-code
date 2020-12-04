package de.chaosmarc.aoc.twentytwenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        int result = 0;
        List<String> fields = new ArrayList<>();
        File myObj = new File("src/de/chaosmarc/aoc/twentytwenty/input/Day4.txt");
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
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
        }
        System.out.println("Solution: " + result);
    }
}
