package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {

    public static void main(String[] args) {
        List<Integer> list1 = getIntegersFromList(Arrays.asList(1,2,'a','b'));
        System.out.println(list1);
        List<Integer> list2 = getIntegersFromList(Arrays.asList(1,2,'a','b',0,15));
        System.out.println(list2);
        List<Integer> list3 = getIntegersFromList(Arrays.asList(1,2,'a','b',"aasf",'1',"123",231));
        System.out.println(list3);
    }

    public static List<Integer> getIntegersFromList(List<Object> objectList){

        List<Integer> answer = new ArrayList<>();

        for (Object obj: objectList){
            if(obj.getClass().getName().equals("java.lang.Integer")){
                answer.add((Integer) obj);
            }
        }

        return answer;
    }
}
