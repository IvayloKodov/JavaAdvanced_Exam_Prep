package com.company;

import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] data = console.nextLine().split(" ");
        int matrixRows = Integer.parseInt(data[0]);
        int matrixCols = Integer.parseInt(data[1]);
        boolean[][] matrix = new boolean[matrixRows][matrixCols];
        String input = console.nextLine();

        while (!input.equals("stop")) {
            int stepsCounter = 1;
            data = input.split(" ");
            int startRow = Integer.parseInt(data[0]);
            int parkRow = Integer.parseInt(data[1]);
            if (isRowFull(matrix, parkRow)) {
                System.out.printf("Row %d full\n", parkRow);
            } else {
                int parkCol = Integer.parseInt(data[2]);
                stepsCounter += Math.abs(parkRow - startRow);
                if (!matrix[parkRow][parkCol]) {
                    stepsCounter += parkCol;
                    matrix[parkRow][parkCol] = true;
                    System.out.println(stepsCounter);
                } else {
                    int distance = Math.max(parkCol - 1, matrixCols - 1 - parkCol);
                    for (int i = 1; i <= distance; i++) {
                        int leftIndex = Math.max(1, parkCol - i);
                        int rightIndex = Math.min(matrixCols - 1, parkCol + i);
                        if (!matrix[parkRow][leftIndex]) {
                            matrix[parkRow][leftIndex] = true;
                            stepsCounter += leftIndex;
                            break;
                        } else if (!matrix[parkRow][rightIndex]) {
                            matrix[parkRow][rightIndex] = true;
                            stepsCounter += rightIndex;
                            break;
                        }
                    }
                    System.out.println(stepsCounter);
                }
            }
            input = console.nextLine();
        }
    }

    static boolean isRowFull(boolean[][] matrix, int row) {
        for (int i = 1; i < matrix[row].length; i++) {
            if (matrix[row][i] == false) {
                return false;
            }
        }
        return true;
    }
}