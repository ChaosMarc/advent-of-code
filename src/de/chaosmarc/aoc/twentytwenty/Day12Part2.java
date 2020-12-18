package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.List;

public class Day12Part2 {
    public static void main(String[] args) throws IOException {
        List<String> input = InputReader.read(2020, 12);
        int[] ship = new int[] {0, 0};
        int[] waypoint = new int[] {10, 1};
        for (String s : input) {
            String cmd = s.substring(0, 1);
            int value = Integer.parseInt(s.substring(1));
            if (cmd.matches("[LR]")) {
                rotateWaypoint(waypoint, cmd, value);
            } else if (cmd.equals("F")) {
                Day12Part1.moveToDirection(ship, 90, waypoint[0] * value);
                Day12Part1.moveToDirection(ship, 0, waypoint[1] * value);
            } else {
                Day12Part1.moveToDirection(waypoint, Day12Part1.getDegreesFromString(cmd), value);
            }
        }
        System.out.println("Solution: " + (Math.abs(ship[0]) + Math.abs(ship[1])));
    }

    private static void rotateWaypoint(int[] waypoint, String cmd, int value) {
        if (value == 180) {
            waypoint[0] *= -1;
            waypoint[1] *= -1;
        } else if ((cmd.equals("R") && value == 90) || cmd.equals("L") && value == 270) {
            int tmp = waypoint[0];
            waypoint[0] = waypoint[1];
            waypoint[1] = tmp * -1;
        } else {
            int tmp = waypoint[1];
            waypoint[1] = waypoint[0];
            waypoint[0] = tmp * -1;
        }
    }
}
