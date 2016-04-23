package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrangeNumbersSecondWay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String []numbers = sc.nextLine().split(",\\s*");

        List<String> parsed = Arrays.stream(numbers)
                .map(number->
                    number.replaceAll("0","zero")
                            .replaceAll("1","one")
                            .replaceAll("2","two")
                            .replaceAll("3","three")
                            .replaceAll("4","four")
                            .replaceAll("5","five")
                            .replaceAll("6","six")
                            .replaceAll("7","seven")
                            .replaceAll("8","eight")
                            .replaceAll("9","nine")).collect(Collectors.toList());

        parsed.sort(Comparator.naturalOrder());
        List<String> transfered = parsed.stream().map(
                number->
                        number.replaceAll("zero","0")
                                .replaceAll("one","1")
                                .replaceAll("two","2")
                                .replaceAll("three","3")
                                .replaceAll("four","4")
                                .replaceAll("five","5")
                                .replaceAll("six","6")
                                .replaceAll("seven","7")
                                .replaceAll("eight","8")
                                .replaceAll("nine","9")).collect(Collectors.toList());
        System.out.println(String.join(", ",transfered));
    }
}
