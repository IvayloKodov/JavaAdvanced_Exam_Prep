package com.company;

import java.util.Scanner;

public class TinySporebat {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int health = 5800;
        int glowcaps = 0;

        while (true) {
            String input = console.nextLine();
            if (input.equals("Sporeggar") || health <= 0) {
                break;
            }
            for (int i = 0; i < input.length()-1; i++) {
                if (health <= 0) {
                    break;
                }
                switch (input.charAt(i)) {
                    case 'L':
                        health += 200;
                        break;
                    default:
                        health -= input.charAt(i);
                        break;
                }
            }
            if (health>0){
                glowcaps += Character.getNumericValue(input.charAt(input.length()-1));
            }
        }

        if (health > 0) {
            System.out.printf("Health left: %d\n", health);
            if (glowcaps >= 30) {
                System.out.printf("Bought the sporebat. Glowcaps left: %d", glowcaps - 30);
            } else {
                System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.", 30 - glowcaps);
            }
        } else {
            System.out.printf("Died. Glowcaps: %d", glowcaps);
        }
    }
}
