package com.basic;

public class ReverseWordsInString {

	public static String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		StringBuilder rst = new StringBuilder();
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ') {
				rst.append(arr[i]);
			} else {
				int j = i;
				StringBuilder tmp = new StringBuilder();
				while (j < arr.length && Character.isLetter(arr[j])) {
					tmp.append(arr[j]);
					j++;
				}
				tmp.reverse();
				rst.append(tmp);
				i = j - 1;
			}
		}
		return rst.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(reverseWords(" i ekil siht"));

	}

}
