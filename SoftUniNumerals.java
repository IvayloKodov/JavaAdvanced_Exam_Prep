package com.company;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniNumerals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> extractor = new HashMap<>();
        extractor.put("aa", "0");
        extractor.put("aba", "1");
        extractor.put("bcc", "2");
        extractor.put("cc", "3");
        extractor.put("cdc", "4");

        Pattern pattern = Pattern.compile("aa|aba|bcc|cc|cdc");
        Matcher matcher = pattern.matcher(sc.nextLine());
        StringBuilder inFiveNumerical = new StringBuilder();

        while (matcher.find()) {
            inFiveNumerical.append(extractor.get(matcher.group()));
        }
        BigInteger inDecimal = new BigInteger(inFiveNumerical.toString(), 5);
        System.out.println(inDecimal);
    }
}
