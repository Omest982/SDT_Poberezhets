package org.example;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        char character1 = first_non_repeating_letter("stress");
        System.out.println(character1);
        char character2 = first_non_repeating_letter("sTreSS");
        System.out.println(character2);
        char character3 = first_non_repeating_letter("gegewesade");
        System.out.println(character3);
        char character4 = first_non_repeating_letter("sss");
        System.out.println(character4);
    }

    public static char first_non_repeating_letter(String str){
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++){
            char currentChar = str.charAt(i);
            char lowChar = Character.toLowerCase(currentChar);
            char highChar = Character.toUpperCase(currentChar);
            if (map.containsKey(lowChar)){
                int val = map.get(lowChar);
                map.put(lowChar, ++val);
            }
            else if (map.containsKey(highChar)){
                int val = map.get(highChar);
                map.put(highChar, ++val);
            }
            else {
                map.put(currentChar, 1);
            }
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if (characterIntegerEntry.getValue() < 2){
                return characterIntegerEntry.getKey();
            }
        }
        return Character.MIN_VALUE;
    }
}
