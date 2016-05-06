package com.company;

import java.util.Scanner;
import java.util.TreeMap;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Integer> treasures = new TreeMap<>();
        TreeMap<String, Integer> junkes = new TreeMap<>();
        int shards = 0;
        int fragments = 0;
        int motes = 0;

        while (true) {
            if (shards >= 250) {
                System.out.println("Shadowmourne obtained!");
                shards -= 250;
                break;
            } else if (fragments >= 250) {
                System.out.println("Valanyr obtained!");
                fragments -= 250;
                break;
            } else if (motes >= 250) {
                System.out.println("Dragonwrath obtained!");
                motes -= 250;
                break;
            }
            String[] materials = sc.nextLine().toLowerCase().trim().split("\\s+");
            for (int item = 0; item < materials.length; item += 2) {
                int quantity = Integer.parseInt(materials[item]);
                String material = materials[item + 1];
                if (shards >= 250 || fragments >= 250 || motes >= 250) {
                    break;
                }
                switch (material) {
                    case "shards":
                        shards += quantity;
                        break;
                    case "fragments":
                        fragments += quantity;

                        break;
                    case "motes":
                        motes += quantity;
                        break;
                    default:
                        if (!junkes.containsKey(material)) {
                            junkes.put(material, 0);
                        }
                        junkes.put(material, junkes.get(material) + quantity);
                        break;
                }
            }
        }
        treasures.put("shards", shards);
        treasures.put("fragments", fragments);
        treasures.put("motes", motes);

        treasures.entrySet().stream()
                .sorted((m1, m2) -> m2.getValue().compareTo(m1.getValue()))
                .forEach(material -> System.out.printf("%s: %d\n", material.getKey(), material.getValue()));

        junkes.entrySet().stream()
                .forEach(junk -> System.out.printf("%s: %d\n", junk.getKey(), junk.getValue()));
    }
}