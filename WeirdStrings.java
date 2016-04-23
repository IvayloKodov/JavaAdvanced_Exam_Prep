package com.company;

import java.util.Scanner;

public class WeirdStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().replaceAll("[\\s\\/\\(\\)\\|]+", "").split("[^a-zA-Z]+");
        int maxSum = 0;
        String[] result = new String[2];

        for (int couple = 0; couple < input.length-1; couple ++) {
            int currentSum = 0;
            for (int i = 0; i < input[couple].length(); i++) {
                currentSum += (input[couple].toLowerCase().charAt(i) - 96);
            }
            for (int i = 0; i < input[couple + 1].length(); i++) {
                currentSum += (input[couple+1].toLowerCase().charAt(i) - 96);
            }
            if (currentSum >= maxSum) {
                maxSum=currentSum;
                result[0] = input[couple];
                result[1] = input[couple + 1];
            }
        }
        for (String word : result) {
            System.out.printf("%s\n", word);
        }
    }
}
