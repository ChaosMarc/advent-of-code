package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.Helper;

import java.io.IOException;
import java.util.List;

public class Day12Part1 {
    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput(2020, 12);
        int[] pos = new int[] {0, 0};
        int direction = 90;
        for (String s : input) {
            String cmd = s.substring(0, 1);
            int value = Integer.parseInt(s.substring(1));
            if (cmd.matches("[LR]")) {
                direction = getNewDirection(direction, cmd, value);
            } else if (cmd.equals("F")) {
                moveToDirection(pos, direction, value);
            } else {
                moveToDirection(pos, getDegreesFromString(cmd), value);
            }
        }
        System.out.println("Solution: " + (Math.abs(pos[0]) + Math.abs(pos[1])));
    }

    public static int getDegreesFromString(String cmd) {
        switch (cmd) {
            default:
            case "N":
                return 0;
            case "E":
                return 90;
            case "S":
                return 180;
            case "W":
                return 270;
        }
    }

    public static void moveToDirection(int[] pos, int direction, int value) {
        switch (direction) {
            default:
            case 0:
                pos[1] += value;
                break;
            case 90:
                pos[0] += value;
                break;
            case 180:
                pos[1] -= value;
                break;
            case 270:
                pos[0] -= value;
                break;
        }
    }

    public static int getNewDirection(int direction, String cmd, int value) {
        direction = cmd.equals("R") ? direction + value : direction - value;
        if (direction >= 360) {
            direction -= 360;
        } else if (direction < 0) {
            direction += 360;
        }
        return direction;
    }
}
