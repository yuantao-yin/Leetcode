package com.lc.recursion;
import java.util.*;

public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
        List<List<String>> rst = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return rst;
        }
        List<String> list = new ArrayList<String>();
        helper(rst, list, s, 0);
        return rst;
    }
    
    private void helper(List<List<String>> rst, List<String> list, String s, int pos) {
        if (pos == s.length()) { 
        	rst.add(new ArrayList<String>(list));
            return;
        }
        for (int i = pos + 1; i <= s.length(); i++) {
            String prefix = s.substring(pos, i);
            if (!isPalindrome(prefix)) {
                continue;
            }
            list.add(prefix);
            helper(rst, list, s, i);
            list.remove(list.size() - 1);
        }
    }
    
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		System.out.println(pp.partition("abb").toString());
	}

}
