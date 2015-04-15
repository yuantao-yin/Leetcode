package com.lc.highfrequency;

public class SingleNumber {
	public int getSingleNumber(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int sum = A[0];
		for (int i = 1; i < A.length; i++) {
			sum = sum ^ A[i];
		}
		return sum;
	}
}
