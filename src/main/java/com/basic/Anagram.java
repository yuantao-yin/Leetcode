package com.basic;

import java.util.Arrays;

/*
 * check whether two given strings are anagram of each other or not. 
 * For example, “Abcd ee” and “edabce” are anagram of each other.
 */
public class Anagram {
	
	//Method: 1 count characters
	// it is assumed that the characters 
	// are stored using 8 bit and there can be 256 possible characters.
	public static boolean isAnagram(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		s1 = s1.toLowerCase().replaceAll(" ", "");
		s2 = s2.toLowerCase().replaceAll(" ", "");
		int len1 = s1.length();
		int len2 = s1.length();
		if (len1 != len2) {
			return false;
		}
		int[] a1 = new int[256];
		int[] a2 = new int[256];
		for (int i = 0; i < len1; i++) {
			a1[Character.getNumericValue(s1.charAt(i))]++;
			a2[Character.getNumericValue(s2.charAt(i))]++;		
		}
		if (Arrays.equals(a1, a2)) {
			return true;
		}
		return false;
		
	}
	
	//Method 2: sort
	public static boolean isAnagram2(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		s1 = s1.toLowerCase().replaceAll(" ", "");
		s2 = s2.toLowerCase().replaceAll(" ", "");
		int len1 = s1.length();
		int len2 = s1.length();
		if (len1 != len2) {
			return false;
		}
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		mergesort(arr1, 0, len1 -1);
		mergesort(arr2, 0, len2 -1);
		return Arrays.equals(arr1, arr2);
	}
	private static void mergesort(char[] arr, int low, int high) {
		if (low < high) {
			int mid = (low + high)/2;
			mergesort(arr, low, mid);
			mergesort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}
	
	private static void merge(char[] arr, int low, int mid, int high) {
		int j = mid + 1;
		int k = low;
		char[] helper = new char[high+1];
		for (int i = 0; i <= high; i++) {
			helper[i] = arr[i]; 
		}
		// Copy the smallest values from either the left or the right side back
	    // to the original array
		while (low <= mid && j <= high) {
			if (helper[low] <=helper[j]) {
				arr[k] = helper[low];
				low++;
			} else {
				arr[k] = helper[j];
				j++;
			}
			k++;
		}
		/* We need to copy any remaining elements from the helper array into the original array. Note that
         * either the left or right half may have remaining elements, but not both. If the left half has
         * remaining elements, we copy them (as shown below). Any remaining right side elements are already
         * in the right place in our array. To demonstrate this, imagine an array like 
         * [1, 4, 5 |MIDPOINT| 2, 8, 9]. The last two elements of the helper array (8, 9) will
         * already be in place in the original array. There is no need to copy them.
         */
		while (low <= mid) {
			arr[k] = helper[low];
			low++;
			k++;
		}
		
	}
	public static void main(String[] args) {
		String x = "Abcd ee";
		String y = "edabce";
		System.out.println(isAnagram(x, y));
		System.out.println(isAnagram2(x, y));

	}

}
