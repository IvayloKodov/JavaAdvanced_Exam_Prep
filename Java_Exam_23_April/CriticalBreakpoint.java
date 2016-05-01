package com.company;

import java.math.BigDecimal;
import java.util.*;

public class CriticalBreakpoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Long> criticalRatios = new ArrayList<>();
        List<String> resultMatrix = new ArrayList<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("Break it.")) {
                break;
            }
            //Read the input and directly split and parse it in long array
            Long[] lineCoordinations = Arrays.stream(input.split("\\s+"))
                    .map(Long::parseLong).toArray(Long[]::new);
            //Fill the matrix with ", " between the numbers
            resultMatrix.add(String.join(", ", input.split("\\s+")));
            long x1 = lineCoordinations[0];
            long y1 = lineCoordinations[1];
            long x2 = lineCoordinations[2];
            long y2 = lineCoordinations[3];
            //We find the current critical ratio of each line and add it to the list.
            long lineCriticalRatio = Math.abs((x2 + y2) - (x1 + y1));
            criticalRatios.add(lineCriticalRatio);
        }
        //If the critical ratio of the line is !=0, we get the first different ratio
        long criticalRatio = 0;
        for (int i = 0; i < criticalRatios.size(); i++) {
            if (criticalRatios.get(i) != 0) {
                criticalRatio = criticalRatios.get(i);
                break;
            }
        }
        //Find if there is a critical breakpoint
        BigDecimal criticalBreakpoint;
        for (int i = 0; i < criticalRatios.size(); i++) {
            if (criticalRatios.get(i) != 0 && criticalRatios.get(i) != criticalRatio) {
                //They don't create a critical breakpoint
                System.out.println("Critical breakpoint does not exist.");
                break;
            }
            if (i == criticalRatios.size() - 1) {
                BigDecimal result = new BigDecimal(criticalRatio);
                criticalBreakpoint = result.pow(criticalRatios.size()).divideAndRemainder(new BigDecimal(criticalRatios.size()))[1];
                for (int j = 0; j < resultMatrix.size(); j++) {
                    System.out.println("Line: " + "[" + resultMatrix.get(j) + "]");
                }
                System.out.println("Critical Breakpoint: " + criticalBreakpoint);
            }
        }
    }
}
