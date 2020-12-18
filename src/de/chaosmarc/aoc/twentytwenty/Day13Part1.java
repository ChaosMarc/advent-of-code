package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Day13Part1 {
    public static void main(String[] args) throws IOException {
        List<String> input = InputReader.read(2020, 13);
        int start = Integer.parseInt(input.get(0));
        int[] busLines =
            Arrays.stream(input.get(1).split(",")).filter(x -> !x.equals("x")).mapToInt(Integer::valueOf).toArray();
        int nextBus = 0;
        int waitingTime = 0;
        while (nextBus == 0) {
            int curTime = start + waitingTime;
            for (int bus : busLines) {
                if (curTime % bus == 0) {
                    nextBus = bus;
                    System.out.println("Solution: " + nextBus * waitingTime);
                    break;
                }
            }
            waitingTime++;
        }
    }
}
