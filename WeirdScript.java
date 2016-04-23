package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeirdScript {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int keyNumber = Integer.parseInt(sc.nextLine());
        String bounderies = keyGenerator(keyNumber);
        StringBuilder text = new StringBuilder();
        String regex = bounderies + "\\s*(.*?)\\s*" + bounderies;
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            String input = sc.nextLine();
            if (input.equals("End")) {
                break;
            }
            text.append(input);
        }
        Matcher matcher = pattern.matcher(text.toString());
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }

    private static String keyGenerator(int keyInput) {
        String key = "";

        if (keyInput % 52 > 26) {
            for (char j = 'A', counter = 27; j <= 'Z'; j++, counter++) {
                if (counter == keyInput % 52) {
                    key = "" + j + j;
                    break;
                }
            }
        } else if (keyInput % 52 == 0) {
            key = "ZZ";
        } else {
            for (char j = 'a', counter = 1; j <= 'z'; j++, counter++) {
                if (counter == keyInput % 52) {
                    key = "" + j + j;
                    break;
                }
            }
        }
        return key;
    }
}
