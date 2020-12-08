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
        return readInput(year, day, false);
    }

    public static List<String> readInput(int year, int day, boolean example) throws IOException {
        String fileName = "input/" + year + "/Day" + day + ".txt";
        if (example) {
            fileName = "input/" + year + "/Day" + day + ".example.txt";
        }
        FileReader fileReader = new FileReader(fileName);
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            return reader.lines().collect(Collectors.toList());
        }
    }
}
