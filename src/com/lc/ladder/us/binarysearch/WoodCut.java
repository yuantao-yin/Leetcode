package com.lc.ladder.us.binarysearch;
import java.util.*;


public class WoodCut {

	public static int woodCut(int[] L, int k) {
		int all = 0;
		for (int s : L) {
			all += s;
		}
		if (Math.abs(all) < k) {
			return 0;
		}
		Arrays.sort(L);
		int start = 0;
		int end = L[L.length - 1];
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int sum = 0;
			for (int num : L) {
				sum += num / mid;
			}
			if (sum < k) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return start -1;
	}

	public static void main(String[] args) {
		System.out.println(woodCut(new int[]{2147483644,2147483645,2147483646,2147483647}, 4));

	}

}
