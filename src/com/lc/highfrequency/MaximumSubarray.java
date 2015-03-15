package com.lc.highfrequency;

public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        //loop the array to sum each integer, when sum < 0, reset sum to 0.
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : A) {
            sum += i;
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
