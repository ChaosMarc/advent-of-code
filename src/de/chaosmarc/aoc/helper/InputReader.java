package de.chaosmarc.aoc.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {
    private InputReader() {
    }

    public static List<String> read(int year, int day) throws IOException {
        return read(year, day, false);
    }

    public static List<String> read(int year, int day, boolean example) throws IOException {
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
