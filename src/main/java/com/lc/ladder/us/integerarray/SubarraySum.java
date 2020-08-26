package com.lc.ladder.us.integerarray;

import java.util.*;

public class SubarraySum {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // get sum from 0 to i
            sum += nums[i];
            if (nums[i] == 0) {
                res.add(i);
                res.add(i);
                return res;
            }
            if (sum == 0) {
                res.add(0);
                res.add(i);
                return res;
            }
            // if we find two sum have same value, we know sum from index q+1 to p is zero
            if (map.containsKey(sum)) {
                res.add(map.get(sum)+1);
                res.add(i);
                return res;
            }
            map.put(sum, i);
        }
        return res;
    }
}
