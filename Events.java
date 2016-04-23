package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Events {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfEvents = sc.nextInt();
        sc.nextLine();
        Pattern pattern = Pattern.compile(
                "^#([A-Za-z]+):\\s*@([A-Za-z]+)\\s*(([0-1]?[0-9]|[2][0-3]):([0-5][0-9]))$");
        Map<String, TreeMap<String, List<String>>> eventsProgram = new HashMap<>();

        for (int i = 0; i < numberOfEvents; i++) {
            String event = sc.nextLine();
            Matcher matcher = pattern.matcher(event);

            if (matcher.find()) {
                String name = matcher.group(1);
                String city = matcher.group(2);
                String time = matcher.group(3);
                if (!eventsProgram.containsKey(city)) {
                    eventsProgram.put(city, new TreeMap<>());
                }
                if (!eventsProgram.get(city).containsKey(name)) {
                    eventsProgram.get(city).put(name, new ArrayList<>());
                }
                eventsProgram.get(city).get(name).add(time);
            }
        }
        String[] requests = sc.nextLine().split(",");
        Arrays.sort(requests);
        for (String request: requests){
            if(eventsProgram.containsKey(request)){
                System.out.println(request+":");
                String[] names = new String[eventsProgram.get(request).size()];
                eventsProgram.get(request).keySet().toArray(names);
                int counter = 1;
                for (String name:names){
                    System.out.printf("%d. %s -> ", counter, name);
                    List<String> times = eventsProgram.get(request).get(name);
                    times.sort(String::compareTo);
                    String listTimes = times.toString().replace("[","").replace("]","").trim();
                    System.out.println(listTimes);
                    counter++;
                }
            }
        }
    }
}
