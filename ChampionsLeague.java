package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChampionsLeague {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^([a-zA-Z].+)\\s\\|\\s([a-zA-Z].+)\\s\\|\\s(\\d:\\d)\\s\\|\\s(\\d:\\d)$");
        Map<String, Integer> winMap = new TreeMap<>();
        Map<String, ArrayList<String>> opponentsMap = new HashMap<>();

        String input = sc.nextLine();
        while (!input.equals("stop")) {

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String firstTeam = matcher.group(1);
                String secondTeam = matcher.group(2);
                String firstMatch = matcher.group(3);
                String secondMatch = matcher.group(4);

                if (!winMap.containsKey(firstTeam)) {
                    winMap.put(firstTeam, 0);
                    opponentsMap.put(firstTeam, new ArrayList<>());
                }
                opponentsMap.get(firstTeam).add(secondTeam);
                if (!winMap.containsKey(secondTeam)) {
                    winMap.put(secondTeam, 0);
                    opponentsMap.put(secondTeam, new ArrayList<>());
                }
                opponentsMap.get(secondTeam).add(firstTeam);

                String winner = whoWin(firstTeam, secondTeam, firstMatch, secondMatch);
                int incrementorWins = winMap.get(winner) + 1;
                winMap.put(winner, incrementorWins);
            }
            input = sc.nextLine();
        }
        winMap.entrySet().stream()
                .sorted((team1, team2) -> Integer.compare(team2.getValue(), team1.getValue()))
                .forEach(entry -> {
                    System.out.printf("%s\n", entry.getKey());
                    System.out.printf("- Wins: %d\n", entry.getValue());

                    ArrayList<String> opponents = opponentsMap.get(entry.getKey());
                    opponents.sort(Comparator.naturalOrder());
                    String opponentsPrint = opponents.toString().replace("[", "").replace("]", "").trim();
                    System.out.printf("- Opponents: %s\n", opponentsPrint);
                });
    }

    private static String whoWin(String firstTeam, String secondTeam,
                                 String firstMatch, String secondMatch) {
        String[] firstResult = firstMatch.split(":");
        String[] secondResult = secondMatch.split(":");

        int firstTeamGoalOnSoil = Integer.parseInt(firstResult[0]);
        int firstTeamGoalAwaySoil = Integer.parseInt(secondResult[1]);

        int secondTeamGoalOnSoil = Integer.parseInt(secondResult[0]);
        int secondTeamGoalAwaySoil = Integer.parseInt(firstResult[1]);

        int goalsFirstTeam = firstTeamGoalOnSoil + firstTeamGoalAwaySoil;
        int goalsSecondTeam = secondTeamGoalOnSoil + secondTeamGoalAwaySoil;
        if (goalsFirstTeam > goalsSecondTeam) {
            return firstTeam;
        } else if(goalsSecondTeam>goalsFirstTeam){
            return secondTeam;
        } else {
            if (firstTeamGoalAwaySoil > secondTeamGoalAwaySoil) {
                return firstTeam;
            }else{
                return secondTeam;
            }
        }
    }
}
