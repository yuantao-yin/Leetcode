package com.lc.ninechapter;

public class BinarySearch {

    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public static int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        int firstOccur = Integer.MIN_VALUE;
        while (start <= end) {
            mid = start + ((end - start) >>> 1);
            if (nums[mid] == target) {
                firstOccur = mid;
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (firstOccur != Integer.MIN_VALUE) {
            return firstOccur;
        }
        return -1;
    }

}
