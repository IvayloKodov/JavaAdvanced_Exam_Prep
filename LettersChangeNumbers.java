package com.company;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split("\\s+");
        double result = 0;

        for (int word = 0; word < words.length; word++) {
            double currentResult = 0;
            char firstChar = words[word].charAt(0);
            char secondChar = words[word].charAt(words[word].length() - 1);
            int number = Integer.parseInt(words[word].substring(1, words[word].length() - 1));

            if (Character.isUpperCase(firstChar)) {
                currentResult += number / ((double) firstChar - 64);
            } else {
                currentResult += number * ((double) firstChar - 96);
            }

            if (Character.isUpperCase(secondChar)) {
                currentResult -= ((double) secondChar - 64);
            } else {
                currentResult += ((double) secondChar - 96);
            }
            result += currentResult;
            currentResult = 0;
        }
        System.out.printf("%.2f", result);
    }
}
