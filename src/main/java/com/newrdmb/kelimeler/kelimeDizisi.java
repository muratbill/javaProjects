package com.newrdmb.kelimeler;
import java.util.*;
public class kelimeDizisi {
    void kelimeTuretme(){
        //String[] kelimeler = {"Ahmet", "Ayşe", "Hakan", "Menemen", "Tencere", "Lokanta", "Yapar"};
          String[] kelimeler = {"kalem", "elalem", "kelam", "kelime","aa","Betsy"};
        HashSet<String> result = new HashSet<>();

        for (String word : kelimeler) {
            HashSet<Character> charSet = new HashSet<>();
            boolean hasDuplicates = false;

            for (char c : word.toCharArray()) {
                if (!charSet.add(c)) {
                    hasDuplicates = true;
                    break;
                }
            }

            if (hasDuplicates) {
                result.add(word);
                if (result.size() == 2) {
                    break;
                }
            }
        }

        System.out.println("Words with duplicate characters: " + result);
        StringBuilder birlestir = new StringBuilder();
        for (String element : result) {
            if (element.length() % 2 == 0) {
                String partial = element.substring(0, element.length()/2);
                birlestir.append(partial);
            } else {
                String partial = element.substring(0, (element.length()/2) + 1);
                birlestir.append(partial);
            }

        }
        System.out.println(birlestir);
    }
}
