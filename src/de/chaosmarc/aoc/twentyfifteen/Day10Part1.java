package de.chaosmarc.aoc.twentyfifteen;

public class Day10Part1 {
    public static void main(String[] args) {
        String result = "3113322113";
        for (int i = 0; i < 40; i++) {
            result = lookAndSay(result);
        }
        System.out.println("Solution: " + result.length());
    }

    public static String lookAndSay(String str) {
        str += "X";
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 1; i < str.length(); i++) {
            count++;
            if (str.charAt(i) != str.charAt(i - 1)) {
                result.append(count);
                result.append(str.charAt(i - 1));
                count = 0;
            }
        }
        return result.toString();
    }
}
