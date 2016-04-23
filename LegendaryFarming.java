package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    static int Shadowmourne = 250;
    static int Valanyr = 250;
    static int Dragonwrath = 250;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> materials = new TreeMap<>();
        materials.put("shards",0);
        materials.put("fragments",0);
        materials.put("motes",0);

        Map<String, Integer> junks = new TreeMap<>();

        int shardsQuanty = 0;
        int fragmentsQuanty = 0;
        int motesQuanty = 0;

        while (true) {
            int quantity = sc.nextInt();
            String material = sc.next().toLowerCase();
            if (material.equals("shards")) {
                shardsQuanty += quantity;
                if (shardsQuanty >= Shadowmourne) {
                    shardsQuanty -= Shadowmourne;
                    System.out.println("Shadowmourne obtained!");
                    materials.put(material, shardsQuanty);
                    break;
                } else {
                    materials.put(material, shardsQuanty);
                }
            } else if (material.equals("fragments")) {
                fragmentsQuanty += quantity;
                if (fragmentsQuanty >= Valanyr) {
                    fragmentsQuanty -= Valanyr;
                    System.out.println("Valanyr obtained!");
                    materials.put(material, fragmentsQuanty);
                    break;
                } else {
                    materials.put(material, fragmentsQuanty);
                }
            } else if (material.equals("motes")) {
                motesQuanty += quantity;
                if (motesQuanty >= Dragonwrath) {
                    motesQuanty -= Dragonwrath;
                    System.out.println("Dragonwrath obtained!");
                    materials.put(material, motesQuanty);
                    break;
                } else {
                    materials.put(material, motesQuanty);
                }
            } else {
                if (!junks.containsKey(material)) {
                    junks.put(material, 0);
                }
                junks.put(material, junks.get(material) + quantity);
            }
        }
        materials.entrySet().stream()
                .sorted((q1,q2)-> Integer.compare(q2.getValue(),q1.getValue()))
                .forEach(entry ->{
                    System.out.printf("%s: %d\n", entry.getKey(),entry.getValue());
                });
        junks.entrySet().stream().forEach(entry->{
            System.out.printf("%s: %d\n",entry.getKey(),entry.getValue());
        });
    }
}
