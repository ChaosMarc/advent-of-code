package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.InputReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day13Part2 {
    //Not Working in a reasonable time...
    public static void main(String[] args) throws IOException {
        List<String> input = InputReader.read(2020, 13);
        long curTime = 100000000000000L;
        List<String> busLines = Arrays.stream(input.get(1).split(",")).collect(Collectors.toList());
        Map<Integer, Integer> buss = new HashMap<>();
        for (int i = 0; i < busLines.size(); i++) {
            String b = busLines.get(i);
            if (!b.equals("x")) {
                buss.put(i, Integer.parseInt(b));
            }
        }

        while (true) {
            boolean match = true;
            for (Map.Entry<Integer, Integer> b : buss.entrySet()) {
                if ((curTime + b.getKey()) % b.getValue() != 0) {
                    match = false;
                    break;
                }
            }
            if (match) {
                System.out.println("Solution: " + curTime);
                break;
            }
            curTime++;
        }
    }
}
