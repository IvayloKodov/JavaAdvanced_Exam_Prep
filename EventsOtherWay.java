package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventsOtherWay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^#([a-zA-Z]+):\\s*@([a-zA-Z]+)\\s*(([01][0-9]|[2]*[0-3]):([0-5][0-9]))$");
        TreeMap<String, TreeMap<String, List<String>>> events = new TreeMap<>();

        int numberEvents = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberEvents; i++) {
            String input = sc.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String person = matcher.group(1);
                String location = matcher.group(2);
                String hour = matcher.group(3);

                if (!events.containsKey(location)) {
                    events.put(location, new TreeMap<>());
                }
                if (!events.get(location).containsKey(person)) {
                    events.get(location).put(person, new ArrayList<>());
                }
                events.get(location).get(person).add(hour);
            }
        }
        String[] requests = sc.nextLine().split(",");
        Arrays.sort(requests);

        for (String request : requests) {
            if (events.containsKey(request)) {
                System.out.printf("%s:\n", request);
                int counter = 1;
                for (String person : events.get(request).keySet()) {
                    events.get(request).get(person).sort(Comparator.naturalOrder());
                    System.out.printf("%d. %s -> %s\n",
                            counter, person, String.join(", ", events.get(request).get(person)));
                    counter++;
                }
            }
        }
    }
}
