package com.lc.ladder.us.integerarray;

public class RemoveDupFromSortedArray {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[p]) {
                // if two pointer's value are not equaled then move forward the p
                p++;
                nums[p] = nums[i];
            }
        }
        return p + 1;
    }
}
