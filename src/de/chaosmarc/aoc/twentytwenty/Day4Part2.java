package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.Helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4Part2 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        List<String> fields = new ArrayList<>();
        List<String> input = Helper.readInput(2020, 4);
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
                String[] field = s.split(":");
                switch (field[0]) {
                    case "byr":
                        if (isNumber(field[1])) {
                            int val = Integer.parseInt(field[1]);
                            if (val >= 1920 && val <= 2002) {
                                fields.add(field[1]);
                            }
                        }
                        break;
                    case "iyr":
                        if (isNumber(field[1])) {
                            int val = Integer.parseInt(field[1]);
                            if (val >= 2010 && val <= 2020) {
                                fields.add(field[1]);
                            }
                        }
                        break;
                    case "eyr":
                        if (isNumber(field[1])) {
                            int val = Integer.parseInt(field[1]);
                            if (val >= 2020 && val <= 2030) {
                                fields.add(field[1]);
                            }
                        }
                        break;
                    case "hgt":
                        if (field[1].matches("[0-9]+(cm|in)")) {
                            int val = Integer.parseInt(field[1].substring(0, field[1].length() - 2));
                            if ((field[1].endsWith("cm") && val >= 150 && val <= 193) || (field[1].endsWith("in")
                                && val >= 59 && val <= 76)) {
                                fields.add(field[1]);
                            }
                        }
                        break;
                    case "hcl":
                        if (field[1].matches("#[0-9a-f]{6}")) {
                            fields.add(field[1]);
                        }
                        break;
                    case "ecl":
                        if (field[1].matches("amb|blu|brn|gry|grn|hzl|oth")) {
                            fields.add(field[1]);
                        }
                        break;
                    case "pid":
                        if (field[1].matches("[0-9]{9}")) {
                            fields.add(field[1]);
                        }
                        break;
                    default:
                }
            }
        }
        System.out.println("Solution: " + result);
    }

    private static boolean isNumber(String val) {
        return val.matches("[0-9]+");
    }
}
