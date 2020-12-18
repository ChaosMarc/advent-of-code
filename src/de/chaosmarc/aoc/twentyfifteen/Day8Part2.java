package de.chaosmarc.aoc.twentyfifteen;

import de.chaosmarc.aoc.InputReader;

import java.io.IOException;

public class Day8Part2 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        for (String data : InputReader.read(2015, 8)) {
            String newData = data.replaceAll("\\\\\\\\|\\\\\"", "____")
                .replaceAll("\\\\x(\\d|[a-z])(\\d|[a-z])|\\\\\\\\|\\\\\"", "_____").replace("\"", "___");
            result += newData.length() - data.length();
        }
        System.out.println("Solution: " + result);
    }
}
