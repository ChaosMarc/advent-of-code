package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.Helper;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14Part1 {
    public static final int BITMASK_LENGTH = 36;

    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput(2020, 14);
        char[] mask =
            new char[] {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0',
                '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'};
        Map<Integer, String> memory = new HashMap<>();
        for (String line : input) {
            if (line.startsWith("mask")) {
                String newMask = line.split(" = ")[1];
                for (int i = 0; i < newMask.length(); i++) {
                    mask[i] = newMask.charAt(i);
                }
            } else {
                String[] cmd = line.split("\\]|\\[| = ");
                memory.put(Integer.parseInt(cmd[1]), or(cmd[3], mask));
            }
        }
        BigInteger result = BigInteger.ZERO;
        for (Map.Entry<Integer, String> mem : memory.entrySet()) {
            result = result.add(new BigInteger(mem.getValue(), 2));
        }

        System.out.println("Solution: " + result.toString());
    }

    public static String or(String value, char[] mask) {
        String s = Long.toBinaryString(Long.parseLong(value));
        char[] valueArr = String.format("%0" + (BITMASK_LENGTH - s.length()) + "d%s", 0, s).toCharArray();
        for (int i = 0; i < BITMASK_LENGTH; i++) {
            if (mask[i] == '1' || mask[i] == '0') {
                valueArr[i] = mask[i];
            }
        }
        return new String(valueArr);
    }
}