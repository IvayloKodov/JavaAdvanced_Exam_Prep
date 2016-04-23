package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WeightLifting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfInputs = Integer.parseInt(sc.nextLine());
        //  Person        Exercise  Weights
        Map<String, TreeMap<String, Long>> personInfo = new TreeMap<>();

        for (int i = 0; i < numberOfInputs; i++) {
            String[] info = sc.nextLine().split("\\s+");
            String person = info[0];
            String exercise = info[1];
            long weight = Integer.parseInt(info[2]);

            if (!personInfo.containsKey(person)) {
                personInfo.put(person, new TreeMap<>());
            }
            if (!personInfo.get(person).containsKey(exercise)) {
                personInfo.get(person).put(exercise, 0L);
            }
            long incrementWeights = personInfo.get(person).get(exercise) + weight;
            personInfo.get(person).put(exercise, incrementWeights);
        }

        personInfo.entrySet().stream().forEach(entry -> {
            System.out.printf("%s : ", entry.getKey());
            String[] exercises = new String[personInfo.get(entry.getKey()).size()];
            personInfo.get(entry.getKey()).keySet().toArray(exercises);
            int counter = 0;
            for (String exercise : exercises) {
                if (counter == exercises.length-1) {
                    System.out.printf("%s - %d kg", exercise, personInfo
                            .get(entry.getKey()).get(exercise));
                } else {
                    System.out.printf("%s - %d kg, ", exercise, personInfo
                            .get(entry.getKey()).get(exercise));
                }
                counter++;
            }
            System.out.println();
        });
    }
}
