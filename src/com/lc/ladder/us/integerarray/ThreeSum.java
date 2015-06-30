package com.lc.ladder.us.integerarray;
import java.util.*;


public class ThreeSum {
	/**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length < 3) {
            return res;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length-2; i++) {
            // skip duplicate 
            if (i != 0 && numbers[i] == numbers[i -1]) {
                continue;
            }
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(numbers[i]);
                    list.add(numbers[left]);
                    list.add(numbers[right]);
                    res.add(list);
                    left++;
                    right--;
                    // to skip duplicate
                    while (left < right && numbers[left] == numbers[left-1]) {
                        left++;
                    }
                    // to skip duplicate
                    while (left < right && numbers[right] == numbers[right+1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return res;
    }
}
