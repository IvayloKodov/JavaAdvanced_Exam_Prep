package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class CrossFire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] dimentions = sc.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimentions[0]);
        int cols = Integer.parseInt(dimentions[1]);

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int filler=1;
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer>collumns = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                collumns.add(filler);
                filler++;
            }
            matrix.add(collumns);
        }

        String input = sc.nextLine();
        while (!input.equals("Nuke it from orbit")){
            String [] attacks = input.split("\\s+");
            int attackedRow = Integer.parseInt(attacks[0]);
            int attackedCol = Integer.parseInt(attacks[1]);
            int radius = Integer.parseInt(attacks[2]);

            int startRow = attackedRow-radius;
            int endRow = attackedRow+radius;
            int startCol = attackedCol-radius;
            int endCol = attackedCol+radius;

            for (int i = Math.max(0,startRow); i <=Math.min(matrix.size()-1,endRow) ; i++) {
                for (int j = Math.max(0,startCol); j <=Math.min(matrix.get(i).size()-1,endCol) ; j++) {
                    if (i==attackedRow ||j==attackedCol){
                        matrix.get(i).set(j,0);
                    }
                }
            }
            for (int i = 0; i < matrix.size(); i++) {
                for (int j = 0; j < matrix.get(i).size(); j++) {
                    if (matrix.get(i).get(j)==0){
                        matrix.get(i).remove(j);
                        j--;
                    }
                    if (matrix.get(i).size()==0){
                        matrix.remove(i);
                    }
                }
            }
            input=sc.nextLine();
        }
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.printf(" "+matrix.get(i).get(j));
            }
            System.out.println();
        }
    }
}
