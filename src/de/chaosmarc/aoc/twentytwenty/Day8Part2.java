package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.Helper;

import java.io.IOException;
import java.util.List;

public class Day8Part2 {
    public static void main(String[] args) throws IOException {
        List<String> instructions = Helper.readInput(2020, 8);
        for (int i = 0; i < instructions.size(); i++) {
            String instruction = instructions.get(i);
            if (instruction.matches("(jmp|nop).*")) {
                instructions.set(
                    i, instruction.startsWith("nop") ? instruction.replace("nop", "jmp") :
                        instruction.replace("jmp", "nop"));
                if (Day8Part1.run(instructions)) {
                    return;
                }
                instructions.set(i, instruction);
            }
        }
    }
}
