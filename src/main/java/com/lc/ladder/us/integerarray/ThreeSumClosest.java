package com.lc.ladder.us.integerarray;
import java.util.*;

public class ThreeSumClosest {
	/**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        if (numbers == null || numbers.length < 3) {
            return Integer.MAX_VALUE;
        }
        // sort the array and use two pointer inside the for loop
        Arrays.sort(numbers);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length-2; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            
            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                min = Math.abs(sum - target) < Math.abs(min - target) ? sum : min;
            }
        }
        
        return min;
    }
}
