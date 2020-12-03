package de.chaosmarc.aoc.twentysixteen;

public class Day1Part1 {

    private static final String[] INPUT = //new String[]{"R5", "L5", "R5", "R3"};
        new String[] {"R5", "L2", "L1", "R1", "R3", "R3", "L3", "R3", "R4", "L2", "R4", "L4", "R4", "R3", "L2", "L1",
            "L1", "R2", "R4", "R4", "L4", "R3", "L2", "R1", "L4", "R1", "R3", "L5", "L4", "L5", "R3", "L3", "L1", "L1",
            "R4", "R2", "R2", "L1", "L4", "R191", "R5", "L2", "R46", "R3", "L1", "R74", "L2", "R2", "R187", "R3", "R4",
            "R1", "L4", "L4", "L2", "R4", "L5", "R4", "R3", "L2", "L1", "R3", "R3", "R3", "R1", "R1", "L4", "R4", "R1",
            "R5", "R2", "R1", "R3", "L4", "L2", "L2", "R1", "L3", "R1", "R3", "L5", "L3", "R5", "R3", "R4", "L1", "R3",
            "R2", "R1", "R2", "L4", "L1", "L1", "R3", "L3", "R4", "L2", "L4", "L5", "L5", "L4", "R2", "R5", "L4", "R4",
            "L2", "R3", "L4", "L3", "L5", "R5", "L4", "L2", "R3", "R5", "R5", "L1", "L4", "R3", "L1", "R2", "L5", "L1",
            "R4", "L1", "R5", "R1", "L4", "L4", "L4", "R4", "R3", "L5", "R1", "L3", "R4", "R3", "L2", "L1", "R1", "R2",
            "R2", "R2", "L1", "L1", "L2", "L5", "L3", "L1"};

    public static void main(String[] args) {
        int[] blocks = new int[] {0, 0, 0, 0};
        int direction = 0;
        for (String i : INPUT) {
            char rotate = i.charAt(0);
            if (direction == 0 && rotate == 'R' || direction == 2 && rotate == 'L') {
                direction = 1;
            } else if (direction == 0 && rotate == 'L' || direction == 2 && rotate == 'R') {
                direction = 3;
            } else if (direction == 1 && rotate == 'R' || direction == 3 && rotate == 'L') {
                direction = 2;
            } else if (direction == 1 && rotate == 'L' || direction == 3 && rotate == 'R') {
                direction = 0;
            }
            blocks[direction] += Integer.parseInt(i.substring(1));
        }
        System.out.println("Solution: " + (Math.abs(blocks[0] - blocks[2]) + Math.abs(blocks[1] - blocks[3])));
    }
}
