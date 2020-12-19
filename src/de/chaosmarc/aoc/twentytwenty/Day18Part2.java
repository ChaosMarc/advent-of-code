package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.List;

public class Day18Part2 {
    public static void main(String[] args) throws IOException {
        List<String> input = InputReader.read(2020, 18);
        long result = 0;
        for (String line : input) {
            result += Long.parseLong(evaluate(line.replace(" ", "")));
        }
        System.out.println("Solution: " + result);
    }

    public static String evaluate(String expression) {
        if (expression.contains("(")) {
            for (int i = 0; i < expression.length(); i++) {
                if (expression.charAt(i) == '(') {
                    int opening = 1;
                    int closing = 0;
                    for (int j = i + 1; j < expression.length(); j++) {
                        opening += expression.charAt(j) == '(' ? 1 : 0;
                        closing += expression.charAt(j) == ')' ? 1 : 0;
                        if (opening == closing) {
                            expression =
                                expression.substring(0, i) + evaluate(expression.substring(i + 1, j)) + expression
                                    .substring(j + 1);
                            break;
                        }
                    }
                }
            }
            return evaluate(expression);
        } else {
            return String.valueOf(multiply(expression));
        }
    }

    private static long multiply(String expression) {
        String[] split = expression.split("\\*");
        long result = 1;
        for (String s : split) {
            result *= add(s);
        }
        return result;
    }

    private static long add(String expression) {
        String[] split = expression.split("\\+");
        long result = 0;
        for (String s : split) {
            result += Long.parseLong(s);
        }
        return result;
    }
}
