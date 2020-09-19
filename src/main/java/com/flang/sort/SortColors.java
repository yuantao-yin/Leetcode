package com.flang.sort;

public class SortColors {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums.length == 1 || nums.length == 0) return;

        // set the index where 0 should go
        int start = 0;
        // set the index where 2 should go
        int end = nums.length - 1;
        int index = 0;

        while (index <= end && start < end) {
            if (nums[index] == 0) {
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
                index++;
            } else if (nums[index] == 2) {
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
            } else {
                index++;
            }
        }
    }
}
