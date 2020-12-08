package de.chaosmarc.aoc.twentyfifteen;

import de.chaosmarc.aoc.Helper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day7Part1NotWorking {
    private static final HashMap<String, Integer> WIRES = new HashMap<>();

    public static void main(String[] args) throws IOException {
        for (String s : Helper.readInput(2015, 7)) {
            String[] instructionArr = s.split(" -> ");
            String target = instructionArr[1];
            String[] instruction = instructionArr[0].split(" ");
            int val = 0;
            if (instruction.length == 1) {
                val = getValue((instruction[0]));
            } else if (instruction[0].equals("NOT")) {
                val = ~getValue(instruction[1]);
            } else if (instruction[1].equals("AND")) {
                val = getValue(instruction[0]) & getValue(instruction[2]);
            } else if (instruction[1].equals("OR")) {
                val = getValue(instruction[0]) | getValue(instruction[2]);
            } else if (instruction[1].equals("LSHIFT")) {
                val = getValue(instruction[0]) << getValue(instruction[2]);
            } else if (instruction[1].equals("RSHIFT")) {
                val = getValue(instruction[0]) >>> getValue(instruction[2]);
            }
            val += val < 0 ? 65536 : 0;
            System.out.println(val + " -> " + target);
            WIRES.put(target, val);
        }
        for (Map.Entry<String, Integer> wire : WIRES.entrySet()) {
            System.out.println(wire.getKey() + ": " + wire.getValue());
        }

        System.out.println("Solution: " + WIRES.get("a"));
    }

    private static int getValue(String id) {
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            if (WIRES.containsKey(id)) {
                return WIRES.get(id);
            } else {
                WIRES.put(id, 0);
                return 0;
            }
        }
    }
}
