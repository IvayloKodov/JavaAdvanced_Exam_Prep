package com.company;

import java.util.Scanner;

public class MelrahShake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        StringBuilder pattern = new StringBuilder(sc.nextLine());

        while (pattern.length() != 0 && pattern.length() <= text.length()) {
            int startFirstWord = text.indexOf(pattern.toString());
            int startLastWord = text.lastIndexOf(pattern.toString());

            if (startFirstWord >= 0 && startLastWord >= 0) {
                System.out.println("Shaked it.");
                text = text.substring(0, startLastWord) + text.substring(startLastWord + pattern.length(), text.length());
                text = text.substring(0, startFirstWord) + text.substring(startFirstWord + pattern.length(), text.length());
                pattern.deleteCharAt(pattern.length() / 2);
            } else {
                break;
            }
        }
        System.out.println("No shake.");
        System.out.println(text);
    }
}
