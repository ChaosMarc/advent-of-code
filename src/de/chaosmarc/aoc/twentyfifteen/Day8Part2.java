package de.chaosmarc.aoc.twentyfifteen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        int result = 0;
        File myObj = new File("src/de/chaosmarc/aoc/twentyfifteen/input/Day8.txt");
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String newData = data.replaceAll("\\\\\\\\|\\\\\"", "____")
                    .replaceAll("\\\\x(\\d|[a-z])(\\d|[a-z])|\\\\\\\\|\\\\\"", "_____").replace("\"", "___");
                result += newData.length() - data.length();
            }
        }
        System.out.println("Solution: " + result);
    }
}
