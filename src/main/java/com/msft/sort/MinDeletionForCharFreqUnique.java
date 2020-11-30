package com.msft.sort;

import java.util.HashSet;
import java.util.Set;

/**
 * A string s is called good if there are no two different characters in s that have the same frequency.
 *
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 *
 * The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: 0
 * Explanation: s is already good.
 * Example 2:
 *
 * Input: s = "aaabbbcc"
 * Output: 2
 * Explanation: You can delete two 'b's resulting in the good string "aaabcc".
 * Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
 */
public class MinDeletionForCharFreqUnique {

    public int minDeletions(String s) {
        // build the frequency array [3, 3, 2]
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Set<Integer> set = new HashSet();
        int rst = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) continue;
            if (!set.contains(freq[i])) {
                set.add(freq[i]);
            } else {
                while (set.contains(freq[i])) {
                    freq[i]--;
                    rst++;
                }
                if (freq[i] != 0) {
                    set.add(freq[i]);
                }
            }
        }
        return rst;
    }
}
