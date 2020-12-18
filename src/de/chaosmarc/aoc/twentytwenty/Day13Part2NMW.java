package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day13Part2NMW {

    public static void main(String[] args) throws IOException {
        List<String> input = InputReader.read(2020, 13);

        String[] busses = input.get(1).split(",");

        List<Integer> ns = new ArrayList<>(); // n[i] == busID
        List<Integer> bs = new ArrayList<>(); // b[i] == (-1*i)%busID + busID
        List<Long> Ns = new ArrayList<>(); // N[i] == N/n[i] given N == prod of all n[i]
        List<Integer> xs = new ArrayList<>(); // xs == inverse of N[i]... found manually by getInverse()
        // function

        long N = 1; // N == product of all ns
        for (int i = 0; i < busses.length; i++) {
            if (!busses[i].equals("x")) {
                ns.add(Integer.parseInt(busses[i]));
                bs.add((-1 * i) % Integer.parseInt(busses[i]) + Integer.parseInt(busses[i]));
                N *= Integer.parseInt(busses[i]);
            }
        }

        // populate Ns[] and xs[]
        for (int i = 0; i < ns.size(); i++) {
            Ns.add(N / ns.get(i));
            xs.add(getInverse(Ns.get(i), ns.get(i)));
        }

        // time to get an answer
        long sum = 0;
        for (int i = 0; i < ns.size(); i++) {
            sum += bs.get(i) * Ns.get(i) * xs.get(i);
        }
        sum %= N;
        System.out.println(sum);
    }

    private static int getInverse(long Ni, int ni) {
        // Ni * xi == 1 (mod ni)
        // incrememnt xi until solution is found
        int xi = 1;
        while ((Ni * xi) % ni != 1) {
            xi++;
        }
        return xi;
    }
}