package com.company;

import java.util.Scanner;

public class MagicCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String [] cards = sc.nextLine().split("\\s+");
        String type = sc.nextLine();
        String magicCard = sc.nextLine();
        String magicCardFace = magicCard.substring(0,magicCard.length()-1);
        char magicCardSuite = magicCard.charAt(magicCard.length()-1);
        int step =0;
        if (type.equals("odd")){
            step=1;
        }
        int valueOfHand = 0;

        for (int card = step; card < cards.length; card+=2) {
            String cardFace = cards[card].substring(0,cards[card].length()-1);
            char cardSuite = cards[card].charAt(cards[card].length()-1);
            int multiplier =1;

            if (cardFace.equals(magicCardFace)){
                multiplier=3;
            }else if(cardSuite==magicCardSuite){
                multiplier=2;
            }
            //region Hand multiplier
            switch (cardFace){
                case "2":
                    valueOfHand+=20*multiplier;
                    break;
                case "3":
                    valueOfHand+=30*multiplier;
                    break;
                case "4":
                    valueOfHand+=40*multiplier;
                    break;
                case "5":
                    valueOfHand+=50*multiplier;
                    break;
                case "6":
                    valueOfHand+=60*multiplier;
                    break;
                case "7":
                    valueOfHand+=70*multiplier;
                    break;
                case "8":
                    valueOfHand+=80*multiplier;
                    break;
                case "9":
                    valueOfHand+=90*multiplier;
                    break;
                case "10":
                    valueOfHand+=100*multiplier;
                    break;
                case "J":
                    valueOfHand+=120*multiplier;
                    break;
                case "Q":
                    valueOfHand+=130*multiplier;
                    break;
                case "K":
                    valueOfHand+=140*multiplier;
                    break;
                case "A":
                    valueOfHand+=150*multiplier;
                    break;
            }
            //endregion
        }
        System.out.println(valueOfHand);
    }
}
