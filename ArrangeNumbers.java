package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrangeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(", ");
        String result = "";
        String [] convertedNumbers= new String[input.length];

        for (int number = 0; number <input.length; number++) {
            for (int i = 0; i < input[number].length(); i++) {
                switch (input[number].charAt(i)) {
                    case '0':
                        result += "zero";
                        break;
                    case '1':
                        result += "one";
                        break;
                    case '2':
                        result += "two";
                        break;
                    case '3':
                        result += "three";
                        break;
                    case '4':
                        result += "four";
                        break;
                    case '5':
                        result += "five";
                        break;
                    case '6':
                        result += "six";
                        break;
                    case '7':
                        result += "seven";
                        break;
                    case '8':
                        result += "eight";
                        break;
                    case '9':
                        result += "nine";
                        break;
                }
            }
            convertedNumbers[number]=result;
            result="";
        }
        Arrays.sort(convertedNumbers);
        Map<String,String> extractor = new HashMap<>();
        extractor.put("zero","0");
        extractor.put("one","1");
        extractor.put("two","2");
        extractor.put("three","3");
        extractor.put("four","4");
        extractor.put("five","5");
        extractor.put("six","6");
        extractor.put("seven","7");
        extractor.put("eight","8");
        extractor.put("nine","9");

        Pattern pattern = Pattern.compile("zero|one|two|three|four|five|six|seven|eight|nine");
        for (int i = 0; i < convertedNumbers.length; i++) {
            Matcher matcher = pattern.matcher(convertedNumbers[i]);
            String finalResult="";
            while (matcher.find()){
                finalResult+=extractor.get(matcher.group());
            }
            if (i==convertedNumbers.length-1){
                System.out.printf(finalResult);
            }else{
                System.out.printf(finalResult+", ");
                finalResult="";
            }
        }
    }
}

