package de.chaosmarc.aoc.twentyfifteen;

public class Day11Part1 {
    public static void main(String[] args) {
        System.out.println("Solution: " + getNextValidPassword("vzbxkghb"));
    }

    public static String getNextValidPassword(String password) {
        do {
            password = getNextPassword(password);
        } while (!isValid(password));
        return password;
    }

    public static boolean isValid(String password) {
        boolean isValid = password.matches(".*([a-z])\\1.*([a-z])\\2.*") && !password.matches(".*[iol].*");
        if (isValid) {
            char[] split = password.toCharArray();
            for (int i = 0; i < split.length - 2; i++) {
                if (split[i] == (split[i + 1] - 1) && split[i] == (split[i + 2] - 2)) {
                    isValid = true;
                    break;
                }
                isValid = false;
            }
        }
        return isValid;
    }

    public static String getNextPassword(String password) {
        String[] pwArr = password.split("");
        for (int i = pwArr.length - 1; i >= 0; i--) {
            if (!pwArr[i].equals("z")) {
                pwArr[i] = String.valueOf((char) (pwArr[i].charAt(0) + 1));
                break;
            } else {
                pwArr[i] = "a";
            }
        }
        return String.join("", pwArr);
    }
}
