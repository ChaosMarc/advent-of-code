package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.Helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day11Part1 {

    public static void main(String[] args) throws IOException {
        List<String> input = Helper.readInput(2020, 11);
        int[][] seats = new int[input.get(0).length()][input.size()];
        for (int y = 0; y < input.size(); y++) {
            String line = input.get(y);
            for (int x = 0; x < line.length(); x++) {
                seats[x][y] = line.charAt(x);
            }
        }
        int prevOccupiedSeats = -1;
        int occupiedSeats = 0;
        List<int[]> seatsToOccupy = new ArrayList<>();
        List<int[]> seatsToClear = new ArrayList<>();
        do {
            seatsToOccupy.clear();
            seatsToClear.clear();
            for (int y = 0; y < seats.length; y++) {
                for (int x = 0; x < seats[y].length; x++) {
                    int occupiedAdjacentSeats = getOccupiedAdjacentSeats(seats, x, y);
                    if (seats[y][x] == '#' && occupiedAdjacentSeats >= 4) {
                        seatsToClear.add(new int[] {y, x});
                    } else if (seats[y][x] == 'L' && occupiedAdjacentSeats == 0) {
                        seatsToOccupy.add(new int[] {y, x});
                    }
                }
            }
            for (int[] seat : seatsToOccupy) {
                seats[seat[0]][seat[1]] = '#';
            }
            for (int[] seat : seatsToClear) {
                seats[seat[0]][seat[1]] = 'L';
            }
            prevOccupiedSeats = occupiedSeats;
            occupiedSeats = occupiedSeats + seatsToOccupy.size() - seatsToClear.size();
        } while (prevOccupiedSeats != occupiedSeats);

        System.out.println("Solution: " + occupiedSeats);
    }

    public static int getOccupiedAdjacentSeats(int[][] seats, int x, int y) {
        int occupiedAdjacentSeats = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                occupiedAdjacentSeats +=
                    (i < 0 || j < 0 || (i == x && j == y) || i >= seats[y].length || j >= seats.length
                        || seats[j][i] != '#') ? 0 : 1;
            }
        }

        return occupiedAdjacentSeats;
    }
}
