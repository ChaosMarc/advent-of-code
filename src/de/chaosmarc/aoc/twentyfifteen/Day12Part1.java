package de.chaosmarc.aoc.twentyfifteen;

import de.chaosmarc.aoc.InputReader;

import java.io.IOException;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Day12Part1 {
    public static void main(String[] args) throws IOException {
        System.out.println("Solution: " + Pattern.compile("-?\\d+").matcher(InputReader.read(2015, 12).get(0)).results()
            .map(MatchResult::group).mapToInt(Integer::parseInt).reduce(0, Integer::sum));
    }
}
