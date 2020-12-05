package com.lc.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bcabc"
 * Output: "abc"
 * Example 2:
 *
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap();
        LinkedList<Character> list = new LinkedList();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            map.put(s.charAt(i), i);
        }
        for (int i = 0; i < len; i++) {
            if (!list.contains(s.charAt(i))) {
                char c = s.charAt(i);
                while (!list.isEmpty() && c < list.peekLast() && map.get(list.peekLast()) > i) {
                    list.pollLast();
                }
                list.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Character> i = list.listIterator();
        while(i.hasNext()) {
            sb.append(i.next());
        }
        return sb.toString();
    }
}
