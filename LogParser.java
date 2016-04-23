package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\[\"(.+?)\"\\].*\\[\"(.+?)\"\\].*\\[\"(.+?)\"\\]");
        Map<String, Integer> totalMap = new TreeMap<>();
        Map<String, ArrayList<String>> criticalMap = new HashMap<>();
        Map<String, ArrayList<String>> warningMap = new HashMap<>();

        String input = sc.nextLine();
        while (!input.equals("END")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String projectName = matcher.group(1);
                String typeError = matcher.group(2);
                String errorMessage = matcher.group(3);

                if (!totalMap.containsKey(projectName)) {
                    totalMap.put(projectName, 0);
                    criticalMap.put(projectName, new ArrayList<>());
                    warningMap.put(projectName, new ArrayList<>());
                }
                int incrementor = totalMap.get(projectName) + 1;
                totalMap.put(projectName, incrementor);

                if (typeError.equals("Critical")) {
                    criticalMap.get(projectName).add(errorMessage);
                } else {
                    warningMap.get(projectName).add(errorMessage);
                }
            }
            input = sc.nextLine();
        }
        totalMap.entrySet().stream().sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue()))
                .forEach(entry -> {
                    String projectName = entry.getKey();
                    System.out.printf("%s:\n", projectName);
                    System.out.printf("Total Errors: %d\n", entry.getValue());
                    System.out.printf("Critical: %d\n", criticalMap.get(projectName).size());
                    System.out.printf("Warnings: %d\n", warningMap.get(projectName).size());

                    System.out.println("Critical Messages:");
                    ArrayList<String> criticals = criticalMap.get(projectName);
                    criticals.sort(Comparator.naturalOrder());
                    criticals.sort((str1, str2) -> Integer.compare(str1.length(), str2.length()));
                    for (String message : criticals) {
                        System.out.printf("--->%s\n", message);
                    }
                    if (criticals.size() == 0) {
                        System.out.println("--->None");
                    }

                    System.out.println("Warning Messages:");
                    ArrayList<String> warnings = warningMap.get(projectName);
                    warnings.sort(Comparator.naturalOrder());
                    warnings.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

                    for (String message : warnings) {
                        System.out.printf("--->%s\n", message);
                    }
                    if (warnings.size() == 0) {
                        System.out.println("--->None");
                    }

                    System.out.println();
                });
    }
}
