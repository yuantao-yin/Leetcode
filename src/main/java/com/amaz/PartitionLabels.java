package com.amaz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 *
 *  
 *
 * Example 1:
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 *
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int len = S.length();
        for (int i = 0; i < len; i++) {
            // save each letter's end position
            last[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int scannedMaxPos = 0;
        List<Integer> rst = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            scannedMaxPos = Math.max(scannedMaxPos, last[S.charAt(i) - 'a']);
            // when the index arrive the max pos of scanned letter
            if (i == scannedMaxPos) {
                rst.add(i - start + 1);
                start = i + 1;
            }
        }
        return rst;
    }

    public List<Integer> partitionLabels2(String S) {
        Map<Character,Integer> last = new HashMap<>();
        int len = S.length();
        for (int i = 0; i < len; i++) {
            // save each letter's end position
            last.put(S.charAt(i), i);
        }
        int start = 0;
        int scannedMaxPos = 0;
        List<Integer> rst = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            scannedMaxPos = Math.max(scannedMaxPos, last.get(S.charAt(i)));
            // when the index arrive the max pos of scanned letter
            if (i == scannedMaxPos) {
                rst.add(i - start + 1);
                start = i + 1;
            }
        }
        return rst;
    }
}
