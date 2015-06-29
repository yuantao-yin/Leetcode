package com.lc.ladder.us.string;

public class TwoStringsAreAnagrams {
    /**
     * if two strings are anagrams or not.
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int count[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) + '0']++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) + '0']--;
            if (count[t.charAt(i) + '0'] < 0) {
                return false;
            }
        }
        return true;
    }
}
