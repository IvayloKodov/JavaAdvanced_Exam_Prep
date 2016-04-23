package com.company;

import java.util.Scanner;

public class SoftUniPalatkaConf {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int people = console.nextInt();
        int numberOfLines = console.nextInt();
        int beds = 0;
        int meals = 0;
        console.nextLine();

        for (int i = 0; i < numberOfLines; i++) {
            String[] input = console.nextLine().split("\\s");
            String sleepOrEat = input[0];
            int quantity = Integer.parseInt(input[1]);
            String type = input[2];

            switch (sleepOrEat) {
                case "tents":
                    if (type.equals("normal")) {
                        beds += quantity * 2;
                    } else {
                        beds += quantity * 3;
                    }
                    break;
                case "rooms":
                    if (type.equals("single")) {
                        beds +=quantity*1;
                    } else if (type.equals("double")) {
                        beds += quantity * 2;
                    } else {
                        beds += quantity * 3;
                    }
                    break;
                case "food":
                    if (type.equals("musaka")) {
                        meals += quantity * 2;
                    }
                    break;
            }
        }
        if (beds>=people){
            System.out.printf("Everyone is happy and sleeping well. Beds left: %d",beds-people);
        }else{
            System.out.printf("Some people are freezing cold. Beds needed: %d",people-beds);
        }
        System.out.println();
        if (meals>=people){
            System.out.printf("Nobody left hungry. Meals left: %d",meals-people);
        }else{
            System.out.printf("People are starving. Meals needed: %d",people-meals);
        }
    }
}
