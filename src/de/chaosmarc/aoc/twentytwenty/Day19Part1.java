package de.chaosmarc.aoc.twentytwenty;

import de.chaosmarc.aoc.helper.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day19Part1 {
    public static void main(String[] args) throws IOException {
        List<String> input = InputReader.read(2020, 19);
        List<String> messages = new ArrayList<>();
        Map<Integer, String> rules = new HashMap<>();
        for (String s : input) {
            if (s.contains(":")) {
                String[] split = s.split(": ");
                rules.put(Integer.parseInt(split[0]), split[1]);
            } else {
                messages.add(s);
            }
        }

        while (rules.get(0).matches(".*\\d+.*")) {
            String[] splitByPipe = rules.get(0).split("\\|");
            for (int j = 0; j < splitByPipe.length; j++) {
                String[] splitBySpace = splitByPipe[j].split(" ");
                for (int i = 0; i < splitBySpace.length; i++) {
                    if (splitBySpace[i].matches("\\d*")) {
                        splitBySpace[i] = rules.get(Integer.parseInt(splitBySpace[i]));
                    }
                }
                splitByPipe[j] = String.join(" ", splitBySpace);
            }
            rules.put(0, String.join(" ", splitByPipe));
        }
        String ruleZero = rules.get(0).replace("\"", "").replace(" ", "");

        System.out.println("Solution: " + ruleZero);
//        System.out.println("Solution: " + messages.stream().filter(x -> x.matches(ruleZero)).count());
    }

    public static String buildRegex(String str) {
        while (str.matches(".*\\d+.*")) {
            String[] split = str.split("\\|");
            for (String s : split) {
                if (s.contains(" ")) {

                }
            }
        }
        return "";
    }

    public static String splitByPipe(String str) {
        String[] split = str.split("\\|");
        for (String s : split) {
            if (s.matches(".*\\d+.*")) {

            }
        }
        return String.join(" ", split);
    }

    public static String splitBySpace(String str) {
        String[] split = str.split("");
        for (String s : split) {

        }
        return String.join(" ", split);
    }
}

// Rule 0: 
// ^(((((b(a|b)(a|b)a|(b(bb|(a|b)a)|abb)b)a|((aab|((a|b)b|ba)a)a|(a(aa|bb)|b(ba|a(a|b)))b)b)b|(((abb|((a|b)b|aa)a)b|(aba|(aa|bb)b)a)a|((bba|a(aa|ab))b|(bab|(aa|ab)a)a)b)a)b|((((a(a|b)(a|b)|bab)a|(bba|bab)b)a|(b(a|b)(a|b)a|(a((a|b)b|ba)|b(ba|a(a|b)))b)b)b|((b((aa|bb)b|(bb|(a|b)a)a)|a(abb|((a|b)b|aa)a))a|((b((a|b)b|ba)|aba)b|(((a|b)b|aa)a|bab)a)b)a)a)a|(a((((aab|baa)b|(aba|bbb)a)a|(a((a|b)(a|b)b|(aa|bb)a)|b(((a|b)b|ba)b|baa))b)b|(((abb|aaa)b|b(a|b)(a|b)a)a|((((a|b)b|aa)a|(ba|a(a|b))b)b|(bba|abb)a)b)a)|b(a((a((a|b)(a|b)a|(ba|a(a|b))b)|b(b(bb|(a|b)a)|abb))a|(a(abb|((a|b)b|ba)a)|b((aa|bb)a|abb))b)|b(b(((ba|a(a|b))b|(bb|(a|b)a)a)a|((ba|a(a|b))a|abb)b)|a((bab|aaa)b|(a(aa|ab)|b(a|b)(a|b))a))))b)(((((b(a|b)(a|b)a|(b(bb|(a|b)a)|abb)b)a|((aab|((a|b)b|ba)a)a|(a(aa|bb)|b(ba|a(a|b)))b)b)b|(((abb|((a|b)b|aa)a)b|(aba|(aa|bb)b)a)a|((bba|a(aa|ab))b|(bab|(aa|ab)a)a)b)a)b|((((a(a|b)(a|b)|bab)a|(bba|bab)b)a|(b(a|b)(a|b)a|(a((a|b)b|ba)|b(ba|a(a|b)))b)b)b|((b((aa|bb)b|(bb|(a|b)a)a)|a(abb|((a|b)b|aa)a))a|((b((a|b)b|ba)|aba)b|(((a|b)b|aa)a|bab)a)b)a)a)a|(a((((aab|baa)b|(aba|bbb)a)a|(a((a|b)(a|b)b|(aa|bb)a)|b(((a|b)b|ba)b|baa))b)b|(((abb|aaa)b|b(a|b)(a|b)a)a|((((a|b)b|aa)a|(ba|a(a|b))b)b|(bba|abb)a)b)a)|b(a((a((a|b)(a|b)a|(ba|a(a|b))b)|b(b(bb|(a|b)a)|abb))a|(a(abb|((a|b)b|ba)a)|b((aa|bb)a|abb))b)|b(b(((ba|a(a|b))b|(bb|(a|b)a)a)a|((ba|a(a|b))a|abb)b)|a((bab|aaa)b|(a(aa|ab)|b(a|b)(a|b))a))))b)(((a(b(b(((a|b)b|aa)a|bab)|a((ba|a(a|b))b|(bb|(a|b)a)a))|a(a(a(aa|ba)|b(aa|ab))|b(aab|((a|b)b|ba)a)))|b(a(((a|b)(a|b)a|(ab|bb)b)b|((aa|bb)a|bab)a)|b((a((a|b)b|aa)|b(bb|(a|b)a))b|(aba|((a|b)b|aa)b)a)))b|(a((b(a|b)(a|b)b|a(b(ba|a(a|b))|a(bb|(a|b)a)))a|((baa|bbb)b|((ba|a(a|b))a|(bb|(a|b)a)b)a)b)|b((a(abb|b(aa|ba))|b(bbb|aab))b|(abaa|(b(aa|ba)|aba)b)a))a)b|(a((a(((aa|bb)a|bab)a|(b(bb|(a|b)a)|a(ba|a(a|b)))b)|b((((a|b)b|ba)b|baa)a|(b(aa|ab)|a(bb|(a|b)a))b))b|((b(b((a|b)b|ba)|a(aa|ba))|a(aba|((a|b)b|ba)b))a|((a|b)(a|b)ba|(aab|(a|b)(a|b)a)b)b)a)|b((((aba|(ba|ab)b)a|(bba|a(aa|ab))b)a|(bbbb|((aa|bb)b|(bb|(a|b)a)a)a)b)a|((((ba|a(a|b))a|((a|b)b|aa)b)a|(a((a|b)b|aa)|b(bb|(a|b)a))b)a|(bb(ab|bb)|a(bba|bab))b)b))a)$

// Solution:
// 114