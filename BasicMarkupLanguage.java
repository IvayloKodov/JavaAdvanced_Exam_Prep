package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicMarkupLanguage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\s*<\\s*([a-z]+)\\s+(?:value\\s*=" +
                "\\s*\"\\s*(\\d+)\\s*\"\\s+)?[a-z]+\\s*=\\s*\"([^\"]*)\"\\s*\\/>\\s*");
        int counter = 1;

        String input = sc.nextLine();
        while (!input.equals("<stop/>")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String command = matcher.group(1);
                String content = matcher.group(3);
                if (command.equals("repeat")) {
                    int repeat = Integer.parseInt(matcher.group(2));
                    for (int i = 0; i < repeat; i++) {
                        System.out.printf("%d. %s\n", counter, content);
                        counter++;
                    }
                } else if (command.equals("inverse")) {
                    if (!content.isEmpty()) {
                        System.out.printf("%d. %s\n", counter, inversedCharacters(content));
                        counter++;
                    }
                } else if (command.equals("reverse")) {
                    if (!content.isEmpty()) {
                        System.out.printf("%d. %s\n", counter, reversedCharacters(content));
                        counter++;
                    }
                }
            }
            input = sc.nextLine();
        }
    }

    private static String inversedCharacters(String word) {
        char[] chars = word.toCharArray();
        String result = "";

        for (int i = 0; i < chars.length; i++) {
            if (Character.isLowerCase(chars[i])) {
                result += Character.toUpperCase(chars[i]);
            } else {
                result += Character.toLowerCase(chars[i]);
            }
        }
        return result;
    }

    private static String reversedCharacters(String word) {
        String result = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            result += word.charAt(i);
        }
        return result;
    }
}
