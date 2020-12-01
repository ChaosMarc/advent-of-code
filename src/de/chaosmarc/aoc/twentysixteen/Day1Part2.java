package de.chaosmarc.aoc.twentysixteen;

import java.util.ArrayList;
import java.util.List;

public class Day1Part2 {

    private static final String[] INPUT =
        new String[] {"R5", "L2", "L1", "R1", "R3", "R3", "L3", "R3", "R4", "L2", "R4", "L4", "R4", "R3", "L2", "L1",
            "L1", "R2", "R4", "R4", "L4", "R3", "L2", "R1", "L4", "R1", "R3", "L5", "L4", "L5", "R3", "L3", "L1", "L1",
            "R4", "R2", "R2", "L1", "L4", "R191", "R5", "L2", "R46", "R3", "L1", "R74", "L2", "R2", "R187", "R3", "R4",
            "R1", "L4", "L4", "L2", "R4", "L5", "R4", "R3", "L2", "L1", "R3", "R3", "R3", "R1", "R1", "L4", "R4", "R1",
            "R5", "R2", "R1", "R3", "L4", "L2", "L2", "R1", "L3", "R1", "R3", "L5", "L3", "R5", "R3", "R4", "L1", "R3",
            "R2", "R1", "R2", "L4", "L1", "L1", "R3", "L3", "R4", "L2", "L4", "L5", "L5", "L4", "R2", "R5", "L4", "R4",
            "L2", "R3", "L4", "L3", "L5", "R5", "L4", "L2", "R3", "R5", "R5", "L1", "L4", "R3", "L1", "R2", "L5", "L1",
            "R4", "L1", "R5", "R1", "L4", "L4", "L4", "R4", "R3", "L5", "R1", "L3", "R4", "R3", "L2", "L1", "R1", "R2",
            "R2", "R2", "L1", "L1", "L2", "L5", "L3", "L1"};

    private static final List<List<Integer>> positions = new ArrayList<>();

    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int direction = 0;
        for (String i : INPUT) {
            int blocks = Integer.parseInt(i.substring(1));
            char rotate = i.charAt(0);
            if (direction == 0 && rotate == 'R' || direction == 2 && rotate == 'L') {
                direction = 1;
                for (int j = 1; j <= blocks; j++) {
                    x++;
                    if (add(x, y)) {
                        return;
                    }
                }
            } else if (direction == 0 && rotate == 'L' || direction == 2 && rotate == 'R') {
                direction = 3;
                for (int j = 1; j <= blocks; j++) {
                    x--;
                    if (add(x, y)) {
                        return;
                    }
                }
            } else if (direction == 1 && rotate == 'R' || direction == 3 && rotate == 'L') {
                direction = 2;
                for (int j = 1; j <= blocks; j++) {
                    y--;
                    if (add(x, y)) {
                        return;
                    }
                }
            } else if (direction == 1 && rotate == 'L' || direction == 3 && rotate == 'R') {
                direction = 0;
                for (int j = 1; j <= blocks; j++) {
                    y++;
                    if (add(x, y)) {
                        return;
                    }
                }
            }
        }
    }

    private static boolean add(int x, int y) {
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(x);
        tmp.add(y);
        if (!positions.contains(tmp)) {
            positions.add(tmp);
            return false;
        }
        System.out.println(Math.abs(x) + Math.abs(y));
        return true;
    }
}
