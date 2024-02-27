package org.example;

import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        String str1 = "Fred:Corwill;Wilfred:Corwill;Braney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        String answer1 = sortGuests(str1);
        System.out.println(answer1);
    }

    public static String sortGuests(String guests){
        String guestsUpper = guests.toUpperCase();
        List<String> everyGuest = List.of(guestsUpper.split(";"));

        List<String> uniqueLastNames = getUniqueLastNames(everyGuest);
        Collections.sort(uniqueLastNames);

        Map<String, List<String>> dictionary = new LinkedHashMap<>();
        for (String lastname: uniqueLastNames){
            dictionary.put(lastname, new ArrayList<>());
        }

        for (String guest: everyGuest){
            String firstName = guest.split(":")[0];
            String lastName = guest.split(":")[1];

            List<String> names = dictionary.get(lastName);
            names.add(firstName);
            Collections.sort(names);
            dictionary.put(lastName, names);
        }

        StringBuilder answer = new StringBuilder();

        for (Map.Entry<String, List<String>> entry: dictionary.entrySet()){
            String lastName = entry.getKey();
            List<String> names = entry.getValue();
            for (String name: names){
                answer.append(String.format("(%s, %s) ", lastName, name));
            }
        }

        return answer.toString();
    }

    public static List<String> getUniqueLastNames(List<String> guests){
        Set<String> uniqueLastNames = new HashSet<>();
        for (String guest: guests){
            String lastName = guest.split(":")[1];
            uniqueLastNames.add(lastName);
        }
        return new ArrayList<>(uniqueLastNames);
    }
}
