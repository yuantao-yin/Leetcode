package com.flang.search;

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // [left, mid]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // [mid + 1, right]
                right = mid;
            }
        }
        return left;
    }
}
