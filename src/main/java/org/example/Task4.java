package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Task4 {
    public static void main(String[] args) {
        int target = 5;
        int[] arr1 = {1, 3, 6, 2, 2, 0, 4, 5, 1};
        int num11 = numberOfPairs(arr1, target);
        int num12 = numberOfPairsWithStream(arr1, target);
        System.out.println(num11);
        System.out.println(num12);
        System.out.println();
        int[] arr2 = {-3, 8, 0, 3, 1 ,4, 7, -2};
        int num21 = numberOfPairs(arr2, target);
        int num22 = numberOfPairsWithStream(arr2, target);
        System.out.println(num21);
        System.out.println(num22);
        System.out.println();
        int[] arr3 = {0, 0};
        int num31 = numberOfPairs(arr3, target);
        int num32 = numberOfPairs(arr3, target);
        System.out.println(num31);
        System.out.println(num32);
    }

    public static int numberOfPairs(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> answer = new HashMap<>();

        for (int i : arr){
            if (map.containsKey(i)){
                answer.put(i, map.get(i));
            }else if (!map.containsValue(i)){
                map.put(target - i, i);
            }
        }
        return answer.entrySet().size();
    }

    public static int numberOfPairsWithStream(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> answer = new HashMap<>();

        IntStream.range(0, arr.length).forEach(i -> {
            if (map.containsKey(arr[i])){
                answer.put(arr[i], map.get(arr[i]));
            }else if (!map.containsValue(arr[i])){
                map.put(target - arr[i], arr[i]);
            }
        });

        return answer.entrySet().size();
    }
}
