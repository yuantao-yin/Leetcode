package com.flang.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
 */
public class ReorganizeString {
    // we need count each charater's occurrence and then we can constantly
    // separate most frequently occuring character. If we could do that, that means
    // we can create a string such that no two adjacent characters are same.
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // the maxHeap has all the characters in it organized such that the root of the heap
        // contains the most frequently occuring character
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        StringBuilder rst = new StringBuilder();
        // the loop will continue greedily taking the most frequently occurring between characters
        // and placing them one after another. Decrement how many times you have left to use them
        // and putting them back into heap as necessary
        while(maxHeap.size() > 1) {
            char current = maxHeap.remove();
            char next = maxHeap.remove();
            rst.append(current);
            rst.append(next);
            map.put(current, map.get(current) - 1);
            map.put(next, map.get(next) - 1);
            if (map.get(current) > 0) {
                maxHeap.add(current);
            }
            if (map.get(next) > 0) {
                maxHeap.add(next);
            }
        }
        // if the heap is not empty, take the last one out.
        // if the last one count is larger than 1, return ""
        // otherwise we append it to the end of result string.
        if (!maxHeap.isEmpty()) {
            char last = maxHeap.remove();
            if (map.get(last) > 1) {
                return "";
            } else {
                rst.append(last);
            }
        }
        return rst.toString();
    }
}
