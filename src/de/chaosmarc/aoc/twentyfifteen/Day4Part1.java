package de.chaosmarc.aoc.twentyfifteen;

import org.apache.commons.codec.digest.DigestUtils;

public class Day4Part1 {

    private static final String INPUT = "iwrupvqb";

    public static void main(String[] args) {
        System.out.println("Solution: " + findHashWithPrefix("00000"));
    }

    public static int findHashWithPrefix(String prefix) {
        int i = 1;
        while (!DigestUtils.md5Hex(INPUT + i).startsWith(prefix)) {
            i++;
        }
        return i;
    }
}
