package de.chaosmarc.aoc.twentytwentyone;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2Part1 {

    public static void main(String[] args) throws IOException {
        List<String> input = new ArrayList<>(InputReader.read(2021, 2));
        long xTimesY = dive(input);
        System.out.println("Solution: " + xTimesY);
    }

    public static long dive(List<String> list) throws IOException {
        long x = 0;
        long y = 0;
        for (String line : list) {
            String[] split = line.split(" ");
            switch (split[0]) {
                case "forward":
                    x += Long.parseLong(split[1]);
                    break;
                case "down":
                    y += Long.parseLong(split[1]);
                    break;
                case "up":
                    y -= Long.parseLong(split[1]);
                    break;
                default:
                    throw new IOException("Unhandled Input");
            }
        }
        return x * y;
    }
}
