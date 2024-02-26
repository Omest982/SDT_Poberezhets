package org.example;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Character character1 = first_non_repeating_letter("stress");
        System.out.println(character1);
        Character character2 = first_non_repeating_letter("sTreSS");
        System.out.println(character2);
        Character character3 = first_non_repeating_letter("gegewesade");
        System.out.println(character3);
        Character character4 = first_non_repeating_letter("sss");
        System.out.println(character4);
    }

    public static Character first_non_repeating_letter(String str){
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++){
            Character currentChar = str.charAt(i);
            Character lowChar = Character.toLowerCase(currentChar);
            Character highChar = Character.toUpperCase(currentChar);
            if (map.containsKey(lowChar)){
                Integer val = map.get(lowChar);
                map.put(lowChar, ++val);
            }
            else if (map.containsKey(highChar)){
                Integer val = map.get(highChar);
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
