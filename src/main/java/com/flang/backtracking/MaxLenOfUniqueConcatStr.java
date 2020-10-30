package com.flang.backtracking;

import java.util.List;

/*
Given an array of strings arr. String s is a concatenation of a sub-sequence of arr
which have unique characters. Return the maximum possible length of s.

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
Maximum length is 4.
 */
public class MaxLenOfUniqueConcatStr {

    public int maxLength(List<String> arr) {
        int[] rst = new int[1];
        maxUnique(arr, 0, "", rst);
        return rst[0];
    }
    private void maxUnique(List<String> arr, int index, String current, int[] rst) {
        if (index == arr.size() && uniqueStrCount(current) > rst[0]) {
            rst[0] = current.length();
            return;
        }
        if (index == arr.size()) {
            return;
        }
        // only the current element itself
        maxUnique(arr, index+1, current, rst);
        // the current element plus next element
        maxUnique(arr, index+1, current + arr.get(index), rst);
    }
    // since all letter is lower case so we just need a array with size 26 to count character occurrence
    private int uniqueStrCount(String current) {
        int[] count = new int[26];
        for(char c : current.toCharArray()) {
            if (count[c - 'a']++ > 0) {
                return -1;
            }
        }
        return current.length();
    }
}
