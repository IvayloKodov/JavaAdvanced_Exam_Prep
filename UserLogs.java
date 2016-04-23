package com.company;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("IP=(.+?)\\s.*user=(.+)");
        TreeMap<String, LinkedHashMap<String, Integer>> userLog = new TreeMap<>();
        String input = sc.nextLine();

        while (!input.equals("end")) {
            Matcher matcher=pattern.matcher(input);

            while (matcher.find()) {
                String ipAdress = matcher.group(1);
                String user = matcher.group(2);

                if (!userLog.containsKey(user)) {
                    userLog.put(user, new LinkedHashMap<>());
                }
                if (!userLog.get(user).containsKey(ipAdress)) {
                    userLog.get(user).put(ipAdress, 0);
                }
                int incrementMessages = userLog.get(user).get(ipAdress);
                userLog.get(user).put(ipAdress, incrementMessages + 1);
            }
            input = sc.nextLine();
        }
        userLog.entrySet().stream().forEach(entry -> {
            String userName = entry.getKey();
            System.out.printf("%s:\n", userName);
            String[] adresses = new String[userLog.get(userName).size()];
            userLog.get(userName).keySet().toArray(adresses);
            int counter=0;
            for (String ip :adresses) {
                if (counter==adresses.length-1){
                    System.out.printf("%s => %d.\n",ip, userLog.get(userName).get(ip));
                }else{
                    System.out.printf("%s => %d, ",ip, userLog.get(userName).get(ip));
                }
                counter++;
            }
        });
    }
}

