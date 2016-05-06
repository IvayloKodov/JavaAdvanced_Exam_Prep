package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
        String key = keyGenerator(number);
        String regex = key+"\\s*(.*?)\\s*"+key;
        Pattern pattern= Pattern.compile(regex);
        StringBuilder sb= new StringBuilder();
        while (true) {
            String text = sc.nextLine();
            if (text.equals("End")) {
                break;
            }
            sb.append(text);
        }
        Matcher matcher = pattern.matcher(sb.toString());
        while (matcher.find()){
            System.out.println(matcher.group(1));
        }
    }

    private static String keyGenerator(int number) {
        number = number % 52;
        if (number == 0) {
            number=52;
        }
        String key = "";
        if (number <= 26) {
            key += (char) (number + 96);
        } else {
            key += (char) (number + 38);
        }
        return key + key;
    }
}