package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day8Part1 {

    public static void main(String[] args) throws IOException {
        run(InputReader.read(2020, 8));
    }

    public static boolean run(List<String> instructions) {
        List<Integer> pastInstructions = new ArrayList<>();
        int ptr = 0;
        int acc = 0;
        while (true) {
            if (pastInstructions.contains(ptr)) {
                System.out.println("Infinite Loop. acc= " + acc);
                return false;
            }
            pastInstructions.add(ptr);
            String[] instruction = instructions.get(ptr).split(" ");
            if ("acc".equals(instruction[0])) {
                acc += Integer.parseInt(instruction[1]);
                ptr++;
            } else if ("nop".equals(instruction[0])) {
                ptr++;
            } else if ("jmp".equals(instruction[0])) {
                ptr += Integer.parseInt(instruction[1]);
            }
            if (ptr == instructions.size() - 1) {
                System.out.println("Solution: " + acc);
                return true;
            }
        }
    }
}
