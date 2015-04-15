package com.lc.highfrequency;

import java.util.*;

public class MinimumSubarray {

    public static int minSubArray(ArrayList<Integer> nums) {
    	if (nums == null || nums.size() == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            min = Math.min(sum, min);
            if (sum > 0) {
                sum = 0;
            }
        }
        return min;
    }

}
