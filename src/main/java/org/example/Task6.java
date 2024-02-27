package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task6 {
    public static void main(String[] args) {
        int bigger1 = nextBigger(12);   // returns 21
        System.out.println(bigger1);
        int bigger2 = nextBigger(513);  //  returns 531
        System.out.println(bigger2);
        int bigger3 = nextBigger(2017);  //  returns 2071
        System.out.println(bigger3);
        int bigger4 = nextBigger(639212);
        System.out.println(bigger4);
        int bigger5 = nextBigger(253);
        System.out.println(bigger5);
        int bigger6 = nextBigger(10002);
        System.out.println(bigger6);
    }

    public static int nextBigger(int num){
        List<Integer> digits = new ArrayList<>();

        while(num > 0){
            digits.add(num % 10);
            num = num / 10;
        }

        Collections.reverse(digits);

        Integer lastSmallNumIndex = null;
        Integer bigNumIndex = null;

        for (int i = 0; i < digits.size(); i++){
            int currentNum = digits.get(i);
            for (int j = i; j < digits.size(); j++){
                if (currentNum < digits.get(j)){
                    bigNumIndex = j;
                    lastSmallNumIndex = i;
                }
            }
        }

        if (bigNumIndex != null){
            StringBuilder answer = new StringBuilder();
            int temp = digits.get(bigNumIndex);
            digits.set(bigNumIndex, digits.get(lastSmallNumIndex));
            digits.set(lastSmallNumIndex, temp);
            for (int digit: digits){
                answer.append(digit);
            }
            return Integer.parseInt(answer.toString());
        }

        return -1;
    }
}
