package com.company;

import java.util.Scanner;

public class CollectResources {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] field = sc.nextLine().split("\\s+");
        int maxQuantity = 0;
        int lenght = field.length;
        int numberOfPaths = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numberOfPaths; i++) {
            int start = sc.nextInt();
            int step = sc.nextInt();
            sc.nextLine();
            String[] clonedField = field.clone();
            int currentQuantity = 0;

            for (int j = start; true; j = (j + step) % lenght) {
                String resource = field[j].split("_")[0];
                if (clonedField[j].equals("")) {
                    break;
                }
                int quantity = 0;
                try {
                    quantity = Integer.parseInt(field[j].split("_")[1]);
                } catch (IndexOutOfBoundsException e) {
                    quantity = 1;
                }
                switch (resource.toLowerCase()) {
                    case "stone":
                    case "gold":
                    case "wood":
                    case "food":
                        currentQuantity += quantity;
                        clonedField[j] = "";
                        break;
                }
            }
            if (currentQuantity >= maxQuantity) {
                maxQuantity = currentQuantity;
            }
        }
        System.out.println(maxQuantity);
    }
}
