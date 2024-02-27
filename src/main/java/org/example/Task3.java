package org.example;

public class Task3 {

    public static void main(String[] args) {
        int sum1 = digital_root(16);
        System.out.println(sum1);
        int sum2 = digital_root(942);
        System.out.println(sum2);
        int sum3 = digital_root(132189);
        System.out.println(sum3);
        int sum4 = digital_root(493193);
        System.out.println(sum4);

    }
    public static int digital_root(int num){
        int sum = 0;

        while (num > 0){
            int currentNum = num % 10;
            num = num / 10;
            sum += currentNum;
        }

        if (sum > 10){
            sum = digital_root(sum);
        }

        return sum;
    }
}
