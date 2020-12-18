package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day11Part1 {
    private static final int[] ADJACENT = new int[] {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        System.out.println("Solution: " + Day11Part1.run(Day11Part1.createSeatMatrix(), 4, true));
    }

    public static int run(char[][] seats, int threshold, boolean onlySurrounding) {
        int occupiedSeats = 0;
        int prevOccupiedSeats;
        do {
            List<int[]> seatsToOccupy = new ArrayList<>();
            List<int[]> seatsToClear = new ArrayList<>();
            for (int y = 0; y < seats.length; y++) {
                for (int x = 0; x < seats[y].length; x++) {
                    int seat = seats[y][x];
                    if (seat == '.') {
                        continue;
                    }
                    int occupiedAdjacentSeats = getOccupiedAdjacentSeats(seats, x, y, onlySurrounding);
                    if (seat == '#' && occupiedAdjacentSeats >= threshold) {
                        seatsToClear.add(new int[] {y, x});
                    } else if (seat == 'L' && occupiedAdjacentSeats == 0) {
                        seatsToOccupy.add(new int[] {y, x});
                    }
                }
            }
            fillSeats(seats, seatsToOccupy, '#');
            fillSeats(seats, seatsToClear, 'L');
            prevOccupiedSeats = occupiedSeats;
            occupiedSeats = occupiedSeats + seatsToOccupy.size() - seatsToClear.size();
        } while (prevOccupiedSeats != occupiedSeats);
        return occupiedSeats;
    }

    public static int getOccupiedAdjacentSeats(char[][] seats, int x, int y, boolean onlySurrounding) {
        int occupiedAdjacentSeats = 0;
        for (int addX : ADJACENT) {
            for (int addY : ADJACENT) {
                occupiedAdjacentSeats += isNextSeatOccupied(seats, x, y, addX, addY, onlySurrounding);
            }
        }
        return occupiedAdjacentSeats;
    }

    public static int isNextSeatOccupied(char[][] seats, int x, int y, int addX, int addY, boolean onlySurrounding) {
        int nextX = x + addX;
        int nextY = y + addY;
        if (nextX < 0 || nextY < 0 || (nextX == x && nextY == y) || nextX >= seats[y].length || nextY >= seats.length
            || seats[nextY][nextX] == 'L') {
            return 0;
        } else if (seats[nextY][nextX] == '#') {
            return 1;
        } else {
            return onlySurrounding ? 0 : isNextSeatOccupied(seats, nextX, nextY, addX, addY, false);
        }
    }

    public static char[][] createSeatMatrix() throws IOException {
        List<String> input = InputReader.read(2020, 11);
        char[][] seats = new char[input.get(0).length()][input.size()];
        for (int y = 0; y < input.size(); y++) {
            String line = input.get(y);
            for (int x = 0; x < line.length(); x++) {
                seats[x][y] = line.charAt(x);
            }
        }
        return seats;
    }

    public static void fillSeats(char[][] seats, List<int[]> seatsToFill, char occupationStatus) {
        for (int[] seat : seatsToFill) {
            seats[seat[0]][seat[1]] = occupationStatus;
        }
    }
}
