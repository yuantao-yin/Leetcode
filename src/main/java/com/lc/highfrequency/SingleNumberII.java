package com.lc.highfrequency;

public class SingleNumberII {
	public int getSingleNumberII(int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int[] count = new int[32];
		int rst = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				count[i] += (A[j] >> i) & 1;  // add up ith bit for every integer in the array 
				count[i] %= 3;	// mod 3 for each bit in count[i]
			}
			rst |= count[i] << i;
		}
		return rst;
	}
}
