package de.chaosmarc.aoc.twentyfifteen;

public class Day25Part1 {
    public static void main(String[] args) {
        int targetRow = 2947;
        int targetCol = 3029;
        int curRow = 0;
        int maxRow = 0;
        int curCol = 0;
        int maxCol = 0;
        long val = 20151125;
        while (true) {
            if (curRow == targetRow - 1 && curCol == targetCol - 1) {
                System.out.println("Solution: " + val);
                break;
            }
            if (curCol == maxCol) {
                maxRow++;
                maxCol++;
                curRow = maxRow;
                curCol = 0;
            } else {
                curRow--;
                curCol++;
            }
            val = (val * 252533) % 33554393;
        }
    }
}
