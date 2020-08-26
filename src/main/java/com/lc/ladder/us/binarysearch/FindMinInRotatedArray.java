package com.lc.ladder.us.binarysearch;

public class FindMinInRotatedArray {

	public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        while (start+1 < end) {
            int mid = start + (end-start)/2;
            if (num[mid] < num[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (num[start] < num[end]) {
            return num[start];
        } else {
            return num[end];
        }
    }
	
}
