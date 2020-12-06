package de.chaosmarc.aoc.twentyfifteen;

public class Day10Part2 {
    public static void main(String[] args) {
        String result = "3113322113";
        for (int i = 0; i < 50; i++) {
            result = Day10Part1.lookAndSay(result);
        }
        System.out.println("Solution: " + result.length());
    }
}
