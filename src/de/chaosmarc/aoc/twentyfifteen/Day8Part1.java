package de.chaosmarc.aoc.twentyfifteen;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;

public class Day8Part1 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        for (String data : InputReader.read(2015, 8)) {
            String newData = data.replaceAll("\\\\x(\\d|[a-z])(\\d|[a-z])|\\\\\\\\|\\\\\"", "_");
            result += data.length() - newData.length() + 2;
        }
        System.out.println("Solution: " + result);
    }
}
