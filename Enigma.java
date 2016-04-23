package com.company;

import java.util.Scanner;

public class Enigma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfInputs = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numberOfInputs; i++) {
            String message = sc.nextLine();
            int lenght = message.replaceAll("\\s*\\d*", "").length();

            for (int j = 0; j < message.length(); j++) {
                char encryptedChar = message.charAt(j);
                if (Character.isWhitespace(encryptedChar) || Character.isDigit(encryptedChar)) {
                    System.out.print(encryptedChar);
                } else {
                    char decryptedCharX = (char) (encryptedChar + lenght / 2);
                    System.out.print(decryptedCharX);
                }
            }
            System.out.println();
        }
    }
}
