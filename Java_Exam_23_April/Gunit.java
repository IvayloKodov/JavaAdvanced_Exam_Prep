package com.company;

import java.util.*;
import java.util.regex.*;

public class Gunit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^([A-Z]+[a-zA-Z0-9]+)\\s+\\|\\s+([A-Z]+[a-zA-Z0-9]+)\\s+\\|\\s+([A-Z]+[a-zA-Z0-9]+)$");
        TreeMap<String, TreeMap<String, ArrayList<String>>> data = new TreeMap<>();

        //Here We are reading the input until We receive as input text "It's testing time"
        String input = sc.nextLine();
        while (!input.equals("It's testing time!")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String className = matcher.group(1);
                String methodName = matcher.group(2);
                String testName = matcher.group(3);

                if (!data.containsKey(className)) {
                    data.put(className, new TreeMap<>());
                }
                if (!data.get(className).containsKey(methodName)) {
                    data.get(className).put(methodName, new ArrayList<>());
                }
                if (!data.get(className).get(methodName).contains(testName)) {
                    data.get(className).get(methodName).add(testName);
                }
            }
            input = sc.nextLine();
        }
        data.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(
                        entry1.getValue().keySet().size(), entry2.getValue().keySet().size()))
                .sorted((entry1, entry2) -> {
                            int allTests1 = data.get(entry1.getKey()).entrySet().stream().mapToInt((x) -> x.getValue().size()).sum();
                            int allTests2 = data.get(entry2.getKey()).entrySet().stream().mapToInt((x) -> x.getValue().size()).sum();
                            int result = Integer.compare(allTests2, allTests1);
                            return result;
                        }
                ).forEach(entry -> {
            System.out.printf("%s:\n", entry.getKey());

            data.get(entry.getKey()).entrySet().stream()
                    .sorted((method1, method2) -> Integer.compare(method2.getValue().size(), method1.getValue().size()))
                    .forEach(method -> {
                        System.out.printf("##%s\n", method.getKey());

                        data.get(entry.getKey()).get(method.getKey()).stream()
                                .sorted(Comparator.naturalOrder())
                                .sorted((test1, test2) -> Integer.compare(test1.length(), test2.length()))
                                .forEach(test -> System.out.printf("####%s\n", test));
                    });
        });
    }
}
