package de.chaosmarc.aoc.twentytwenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day5Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> ids = new ArrayList<>();
        File myObj = new File("src/de/chaosmarc/aoc/twentytwenty/input/Day5.txt");
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int row = Integer.parseInt(data.substring(0, 7).replace("F", "0").replace("B", "1"), 2);
                int col = Integer.parseInt(data.substring(7).replace("L", "0").replace("R", "1"), 2);
                int id = row * 8 + col;
                ids.add(id);
            }
        }
        Collections.sort(ids);
        for (int i = 0; i < ids.size() - 1; i++) {
            int shouldBeNext = ids.get(i) + 1;
            if (ids.get(i + 1) != shouldBeNext) {
                System.out.println("Solution: " + shouldBeNext);
            }
        }
    }
}
