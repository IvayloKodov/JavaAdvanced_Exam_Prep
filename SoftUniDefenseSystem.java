package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniDefenseSystem {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String text = console.nextLine();

        double summaryLitres = 0;

        while (!text.equals("OK KoftiShans")) {
            Pattern pattern = Pattern.compile("([A-Z][a-z]+).*?([A-Z][a-z]*[A-Z]).*?(\\d+)L");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                String name = matcher.group(1);
                String alcohol = matcher.group(2);
                int litres = Integer.parseInt(matcher.group(3));
                summaryLitres += litres;
                System.out.printf("%s brought %d liters of %s!", name, litres, alcohol.toLowerCase());
                System.out.println();
            }
            text = console.nextLine();
        }
        System.out.printf("%.3f softuni liters", summaryLitres / 1000.0);

    }
}
