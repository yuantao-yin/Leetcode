package com.lc.highfrequency;

import java.util.ArrayList;

public class PartitionArray {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
	public static int partitionArray(ArrayList<Integer> nums, int k) {
	    if (nums == null || nums.size() == 0) {
	        return 0;
	    }
	    int left = 0;
	    int right = nums.size() - 1;
	    while (left < right) {
	        // get the left point that value big than k
	        while (left < right && nums.get(left) < k) {
	            left++;
	        }
	        // get the right point that value less than k
	        while (right >= 0 && nums.get(right) >= k) {
	            right--;
	        }
	        if (left > right) {
	            break;
	        } else {
	            // swap left and right point
	            int tmp = nums.get(left);
	            nums.set(left, nums.get(right));
	            nums.set(right, tmp);
	            left++;
	            right--;
	        }
	    }
	    if (left == nums.size()) {
	        return nums.size();
	    } else {
	        return left;
	    }
    }

}
