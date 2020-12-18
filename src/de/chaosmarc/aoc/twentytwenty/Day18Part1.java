package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.List;

public class Day18Part1 {
    public static void main(String[] args) throws IOException {
        List<String> input = InputReader.read(2020, 18);
        long result = 0;
        for (String line : input) {
            result += Long.parseLong(evaluate(line.replace(" ", "")));
        } System.out.println("Solution: " + result);
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
            int firstOp = getNextOp(expression);
            long result = Long.parseLong(expression.substring(0, firstOp));
            int nextOp = firstOp + 1 + getNextOp(expression.substring(firstOp + 1));
            long parsed;
            while (firstOp != nextOp) {
                parsed = Long.parseLong(expression.substring(firstOp + 1, nextOp));
                if (expression.charAt(firstOp) == '+') {
                    result += parsed;
                } else {
                    result *= parsed;
                }
                firstOp = nextOp;
                nextOp = firstOp + 1 + getNextOp(expression.substring(firstOp + 1));
            }

            parsed = Long.parseLong(expression.substring(firstOp + 1));
            if (expression.charAt(firstOp) == '+') {
                result += parsed;
            } else {
                result *= parsed;
            }

            return String.valueOf(result);
        }
    }

    public static int getNextOp(String expression) {
        int nextOp;
        int nextPlus = expression.indexOf('+');
        int nextMulti = expression.indexOf('*');
        if (nextPlus > -1 && nextMulti > -1) {
            nextOp = Math.min(expression.indexOf('+'), expression.indexOf('*'));
        } else if (nextPlus == -1 && nextMulti > -1) {
            nextOp = nextMulti;
        } else {
            nextOp = nextPlus;
        }
        return nextOp;
    }
}
