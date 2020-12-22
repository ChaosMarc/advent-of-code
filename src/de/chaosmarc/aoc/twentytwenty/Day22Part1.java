package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day22Part1 {
    public static void main(String[] args) throws IOException {
        Queue<Integer> player1 = new LinkedList<>();
        Queue<Integer> player2 = new LinkedList<>();
        splitCards(player1, player2);
        play(player1, player2);
        System.out.println("Result: " + calculateScore(player1, player2));
    }

    public static void splitCards(Queue<Integer> player1, Queue<Integer> player2) throws IOException {
        List<String> input = InputReader.read(2020, 22);
        boolean isPlayer1 = true;
        for (String s : input) {
            if (s.equals("Player 2:")) {
                isPlayer1 = false;
            } else {
                if (s.matches("\\d+")) {
                    if (isPlayer1) {
                        player1.add(Integer.parseInt(s));
                    } else {
                        player2.add(Integer.parseInt(s));
                    }
                }
            }
        }
    }

    public static void play(Queue<Integer> player1, Queue<Integer> player2) {
        while (!player1.isEmpty() && !player2.isEmpty()) {
            int p1 = player1.poll();
            int p2 = player2.poll();
            if (p1 > p2) {
                player1.add(p1);
                player1.add(p2);
            } else {
                player2.add(p2);
                player2.add(p1);
            }
        }
    }

    public static int calculateScore(Queue<Integer> player1, Queue<Integer> player2) {
        int result = 0;
        Queue<Integer> winner = !player1.isEmpty() ? player1 : player2;
        while (!winner.isEmpty()) {
            result += winner.size() * winner.poll();
        }
        return result;
    }
}