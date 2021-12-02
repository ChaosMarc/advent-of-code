package de.chaosmarc.aoc.twentytwentyone;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2Part2 {

    public static void main(String[] args) throws IOException {
        List<String> input = new ArrayList<>(InputReader.read(2021, 2));
        long xTimesY = dive(input);
        System.out.println("Solution: " + xTimesY);
    }

    public static long dive(List<String> list) throws IOException {
        long x = 0;
        long y = 0;
        long z = 0;
        for (String line : list) {
            String[] split = line.split(" ");
            long val = Long.parseLong(split[1]);
            switch (split[0]) {
                case "forward":
                    x += val;
                    y += z * val;
                    break;
                case "down":
                    z += val;
                    break;
                case "up":
                    z -= val;
                    break;
                default:
                    throw new IOException("Unhandled Input");
            }
        }
        return x * y;
    }
}
