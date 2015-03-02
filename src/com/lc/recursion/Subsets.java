package com.lc.recursion;

import java.util.*;

		
public class Subsets {

	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> s) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (s == null || s.size() == 0) {
			return rst;
		}
		Collections.sort(s);
		helper(rst, list, s, 0);
		return rst;
	}

	private void helper(ArrayList<ArrayList<Integer>> rst,
			ArrayList<Integer> list, ArrayList<Integer> s, int pos) {
		rst.add(new ArrayList<Integer>(list));
		for (int i = pos; i < s.size(); i++) {
			list.add(s.get(i));
			helper(rst, list, s, i + 1);
			list.remove(list.size() - 1);
		}
	}

}
