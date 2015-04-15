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
	
	// use char array since string is immutable
	public String reverseWords2(String words) {
		if (words == null  || words.length() == 0) {
			return "";
		}
		char[] s = words.toCharArray();
		reverse(s, 0, s.length - 1);
		System.out.println(String.valueOf(s));
		for (int i = 0, j = 0; j <= s.length; j ++) {
			if (j == s.length || s[j] == ' ') {
				reverse(s, i, j-1);
				i = j + 1;
			}
		}
		return String.valueOf(s);
		
	}
	
	private void reverse(char[] s, int begin, int end) {
		while ( begin < end) {
			char tmp = s[begin];
			s[begin] = s[end];
			s[end] = tmp;
			begin++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(reverseWords(" i ekil siht"));

	}

}
