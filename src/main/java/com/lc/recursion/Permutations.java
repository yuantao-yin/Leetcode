package com.lc.recursion;

import java.util.*;

public class Permutations {

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {

		ArrayList<ArrayList<Integer>> perm = new ArrayList<ArrayList<Integer>>();
		if (nums == null || nums.size() == 0) {
			return perm;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(perm, list, nums);
		return perm;
	}

	private void helper(ArrayList<ArrayList<Integer>> perm,
			ArrayList<Integer> list, ArrayList<Integer> nums) {
		if (list.size() == nums.size()) {
			perm.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.size(); i++) {
			if (list.contains(nums.get(i))) {
				continue;
			}
			list.add(nums.get(i));
			helper(perm, list, nums);
			list.remove(list.size() - 1);
		}
	}
}
