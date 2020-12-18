package de.chaosmarc.aoc.twentyfifteen;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day7Part2 {
    public static void main(String[] args) throws IOException {
        List<String> input = InputReader.read(2015, 7);
        Map<String, String[]> circuit = Day7Part1.buildCircuit(input);
        int a = Day7Part1.getSignal(circuit, "a");

        circuit = Day7Part1.buildCircuit(input);
        circuit.put("b", new String[] {String.valueOf(a)});
        System.out.println("Solution: " + Day7Part1.getSignal(circuit, "a"));
    }
}
