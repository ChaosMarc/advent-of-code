package de.chaosmarc.aoc.twentytwenty;

import java.io.IOException;
import java.util.List;

public class Day8Part2 {
    public static void main(String[] args) throws IOException {
        List<String> instructions = Day8Part1.readInput();
        for (int i = 0; i < instructions.size(); i++) {
            if (instructions.get(i).matches("(jmp|nop).*") && runWithSwappedInstruction(instructions, i)) {
                return;
            }
        }
    }

    private static boolean runWithSwappedInstruction(List<String> instructions, int i) {
        String instruction = instructions.get(i);
        if (instruction.startsWith("nop")) {
            instructions.set(i, instruction.replace("nop", "jmp"));
        } else {
            instructions.set(i, instruction.replace("jmp", "nop"));
        }
        boolean result = Day8Part1.run(instructions);
        instructions.set(i, instruction);
        return result;
    }
}
