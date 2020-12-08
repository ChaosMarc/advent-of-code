package de.chaosmarc.aoc.twentyfifteen;

import de.chaosmarc.aoc.Helper;

import java.io.IOException;
import java.util.HashMap;

public class Day7Part1 {
    private static final HashMap<String, String> CIRCUIT = new HashMap<>();

    public static void main(String[] args) throws IOException {
        for (String s : Helper.readInput(2015, 7)) {
            String[] instruction = s.split(" -> ");
            CIRCUIT.put(instruction[1], instruction[0]);
        }
        System.out.println("Solution: " + getSignal(CIRCUIT.get("a")));
    }

    public static int getSignal(String instruction) {
        String[] split = instruction.split(" ");
        int signal = 0;
        if (split.length == 1) {
            signal = getValue((split[0]));
        } else if (split[0].equals("NOT")) {
            signal = ~getValue(split[1]);
        } else if (split[1].equals("AND")) {
            signal = getValue(split[0]) & getValue(split[2]);
        } else if (split[1].equals("OR")) {
            signal = getValue(split[0]) | getValue(split[2]);
        } else if (split[1].equals("LSHIFT")) {
            signal = getValue(split[0]) << getValue(split[2]);
        } else if (split[1].equals("RSHIFT")) {
            signal = getValue(split[0]) >>> getValue(split[2]);
        }
        return signal & 0xffff;
    }

    private static int getValue(String id) {
        if (id.matches("\\d+")) {
            return Integer.parseInt(id);
        } else {
            return getSignal(CIRCUIT.get(id));
        }
    }
}
