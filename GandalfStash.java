package com.company;

import java.util.Scanner;

public class GandalfStash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mood = Integer.parseInt(sc.nextLine());
        String [] foods = sc.nextLine().toLowerCase().replaceAll("_","").split("\\W+");

        for (int food = 0; food < foods.length; food++) {
            switch (foods[food]){
                case "melon":
                case "apple":
                    mood+=1;
                    break;
                case "cram":
                    mood+=2;
                    break;
                case "lembas":
                    mood+=3;
                    break;
                case "honeycake":
                    mood+=5;
                    break;
                case "mushrooms":
                    mood-=10;
                    break;
                default:
                    mood--;
                    break;
            }
        }
        System.out.println(mood);
        if (mood<-5){
            System.out.println("Angry");
        }else if(mood>=-5 && mood<=0){
            System.out.printf("Sad");
        }else if (mood>0 && mood<=15){
            System.out.printf("Happy");
        }else{
            System.out.printf("Special JavaScript mood");
        }
    }
}
