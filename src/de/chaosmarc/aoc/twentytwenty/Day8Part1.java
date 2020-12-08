package de.chaosmarc.aoc.twentytwenty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day8Part1 {

    public static void main(String[] args) throws IOException {
        run(readInput());
    }

    public static List<String> readInput() throws IOException {
        FileReader fileReader = new FileReader("src/de/chaosmarc/aoc/twentytwenty/input/Day8.txt");
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            return reader.lines().collect(Collectors.toList());
        }
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
