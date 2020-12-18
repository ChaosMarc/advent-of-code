package de.chaosmarc.aoc.twentyfifteen;

import de.chaosmarc.aoc.InputReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day7Part1 {
    public static void main(String[] args) throws IOException {
        System.out.println("Solution: " + getSignal(buildCircuit(InputReader.read(2015, 7)), "a"));
    }

    public static Map<String, String[]> buildCircuit(List<String> input) {
        Map<String, String[]> circuit = new HashMap<>();
        for (String line : input) {
            String[] split = line.split(" -> ");
            circuit.put(split[1], split[0].split(" "));
        }
        return circuit;
    }

    public static int getSignal(Map<String, String[]> circuit, String wire) {
        String[] instruction = circuit.get(wire);
        int signal = 0;
        if (instruction.length == 1) {
            signal = getValue(circuit, instruction[0]);
        } else if (instruction[0].equals("NOT")) {
            signal = ~getValue(circuit, instruction[1]);
        } else if (instruction[1].equals("AND")) {
            signal = getValue(circuit, instruction[0]) & getValue(circuit, instruction[2]);
        } else if (instruction[1].equals("OR")) {
            signal = getValue(circuit, instruction[0]) | getValue(circuit, instruction[2]);
        } else if (instruction[1].equals("LSHIFT")) {
            signal = getValue(circuit, instruction[0]) << getValue(circuit, instruction[2]);
        } else if (instruction[1].equals("RSHIFT")) {
            signal = getValue(circuit, instruction[0]) >>> getValue(circuit, instruction[2]);
        }
        signal = signal & 0xffff;
        circuit.put(wire, new String[] {String.valueOf(signal)});
        return signal;
    }

    private static int getValue(Map<String, String[]> circuit, String wire) {
        if (wire.matches("\\d+")) {
            return Integer.parseInt(wire);
        } else {
            return getSignal(circuit, wire);
        }
    }
}
