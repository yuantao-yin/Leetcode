package com.lc.ladder.us.integerarray;
import java.util.*;

public class TwoSum {
	/*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        int[] rst = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                rst[0] = map.get(target - numbers[i]) + 1;
                rst[1] = i + 1;
            } else {
                map.put(numbers[i], i);
            }
        }
        return rst;
    }
}
