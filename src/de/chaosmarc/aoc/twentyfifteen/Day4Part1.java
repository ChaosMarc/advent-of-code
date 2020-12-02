package de.chaosmarc.aoc.twentyfifteen;

import org.apache.commons.codec.digest.DigestUtils;

public class Day4Part1 {

    private static final String INPUT = "iwrupvqb";

    public static void main(String[] args) {
        int i = 1;
        while (!DigestUtils.md5Hex(INPUT + i).startsWith("00000")) {
            i++;
        }
        System.out.println("Solution: " + i);
    }
}