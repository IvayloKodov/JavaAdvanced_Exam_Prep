package com.company;

import java.util.Scanner;

public class Monopoly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();
        Character[][] monopoly = new Character[rows][cols];

        //Reading the info and filling the matrix Monopoly
        for (int row = 0; row < rows; row++) {
            String input = sc.nextLine();
            for (int col = 0; col < cols; col++) {
                monopoly[row][col] = input.charAt(col);
            }
        }

        //Logic of the game Monopoly
        //It must start the loops by 1, you earn 10 money on every move , even when you're in jail
        int money = 50;
        int totalHotels = 0;
        int moneySpentAtShop = 0;
        int turns = 0;

        for (int row = 1; row <= rows; row++) {
            if (row % 2 != 0) {
                for (int col = 1; col <= cols; col++) {
                    switch (monopoly[row - 1][col - 1]) {
                        case 'H':
                            totalHotels++;
                            System.out.printf("Bought a hotel for %d. Total hotels: %d.\n"
                                    , money, totalHotels);
                            money = 0;
                            break;
                        case 'J':
                            System.out.printf("Gone to jail at turn %d.\n", turns);
                            money += totalHotels * 10 * 2;
                            turns += 2;
                            break;
                        case 'F':
                            break;
                        case 'S':
                            int requiredMoney = row * col;
                            if (money >= requiredMoney) {
                                System.out.printf("Spent %d money at the shop.\n", requiredMoney);
                                money -= requiredMoney;
                                moneySpentAtShop += requiredMoney;

                            } else {
                                System.out.printf("Spent %d money at the shop.\n", money);
                                moneySpentAtShop += money;
                                money = 0;
                            }
                            break;
                    }
                    money += totalHotels * 10;
                    turns++;
                }
            } else {
                for (int col = cols; col >= 1; col--) {
                    switch (monopoly[row - 1][col - 1]) {
                        case 'H':
                            totalHotels++;
                            System.out.printf("Bought a hotel for %d. Total hotels: %d.\n"
                                    , money, totalHotels);
                            money = 0;
                            break;
                        case 'J':
                            System.out.printf("Gone to jail at turn %d.\n", turns);
                            //When you're in jail,skip 2 moves,but you collect money.
                            money += totalHotels * 10 * 2;
                            turns += 2;
                            break;
                        case 'F':
                            break;
                        case 'S':
                            int requiredMoney = row * col;
                            if (money >= requiredMoney) {
                                System.out.printf("Spent %d money at the shop.\n", requiredMoney);
                                money -= requiredMoney;
                                moneySpentAtShop += requiredMoney;

                            } else {
                                System.out.printf("Spent %d money at the shop.\n", money);
                                moneySpentAtShop += money;
                                money = 0;
                            }
                            break;
                    }
                    money += totalHotels * 10;
                    turns++;
                }
            }
        }
        System.out.printf("Turns %d\n", turns);
        System.out.printf("Money %d", money);
    }
}
