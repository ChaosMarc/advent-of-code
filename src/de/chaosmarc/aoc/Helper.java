package de.chaosmarc.aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Helper {
    private Helper() {
    }

    public static List<String> readInput(int year, int day) throws IOException {
        FileReader fileReader = new FileReader("input/" + year + "/Day" + day + ".txt");
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            return reader.lines().collect(Collectors.toList());
        }
    }
}
