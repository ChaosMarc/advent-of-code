package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day5Part2 {
    public static void main(String[] args) throws IOException {
        List<Integer> ids = new ArrayList<>();
        for (String data : InputReader.read(2020, 5)) {
            int row = Integer.parseInt(data.substring(0, 7).replace("F", "0").replace("B", "1"), 2);
            int col = Integer.parseInt(data.substring(7).replace("L", "0").replace("R", "1"), 2);
            int id = row * 8 + col;
            ids.add(id);
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
