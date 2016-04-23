package com.company;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Nuts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfInputs = Integer.parseInt(sc.nextLine());
        TreeMap<String, LinkedHashMap<String, Integer>> list = new TreeMap<>();


        for (int i = 0; i < numberOfInputs; i++) {
            String[] input = sc.nextLine().replace("kg", "").split("\\s+");
            String company = input[0];
            String nuts = input[1];
            int kilos = Integer.parseInt(input[2]);

            if (!list.containsKey(company)) {
                list.put(company, new LinkedHashMap<>());
            }
            if (!list.get(company).containsKey(nuts)) {
                list.get(company).put(nuts, 0);
            }
            int incrementKilos = list.get(company).get(nuts);
            list.get(company).put(nuts, incrementKilos + kilos);
        }
        list.entrySet().stream().forEach(entry -> {
            String companyName = entry.getKey();
            System.out.printf("%s: ", companyName);
            String[] typeOfNuts = new String[list.get(companyName).size()];
            list.get(companyName).keySet().toArray(typeOfNuts);
            int counter = 0;
            for (String typeOfNut : typeOfNuts) {
                if (counter == typeOfNuts.length - 1) {
                    System.out.printf("%s-%dkg\n", typeOfNut, list.get(companyName).get(typeOfNut));
                } else {
                    System.out.printf("%s-%dkg, ", typeOfNut, list.get(companyName).get(typeOfNut));
                }
                counter++;
            }
        });
    }
}
