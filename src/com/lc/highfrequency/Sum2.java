package com.lc.highfrequency;
import java.util.HashMap;

public class Sum2 {

	/*
	 * @param numbers : An array of Integer
	 * @param target : target = numbers[index1] + numbers[index2]
	 * @return : [index1 + 1, index2 + 1] (index1 < index2)
	 */
	public static int[] twoSum(int[] numbers, int target) {
		// Can’t use the sort method here, since the question asks for indexes.
		int[] rst = new int[2];
		if (numbers == null || numbers.length == 0) {
			return rst;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// create a hashmap, save each element in the array as key in the
		// hashmap,
		// save each index of element as value in the hashmap.
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i + 1);
		}
		for (int i = 0; i < numbers.length; i++) {

			if (map.containsKey(target - numbers[i])) {
				int idx1 = i + 1;
				int idx2 = map.get(target - numbers[i]);
				if (idx1 == idx2) {
					continue;
				}
				rst[0] = idx1;
				rst[1] = idx2;
				return rst;
			}
		}
		return rst;
	}

}
