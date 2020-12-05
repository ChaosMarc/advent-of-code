package de.chaosmarc.aoc.twentytwenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day5Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        int result = 0;
        File myObj = new File("src/de/chaosmarc/aoc/twentytwenty/input/Day5.txt");
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int row = Integer.parseInt(data.substring(0, 7).replace("F", "0").replace("B", "1"), 2);
                int col = Integer.parseInt(data.substring(7).replace("L", "0").replace("R", "1"), 2);
                int id = row * 8 + col;
                result = Math.max(result, id);
            }
        }
        System.out.println("Solution: " + result);
    }
}
