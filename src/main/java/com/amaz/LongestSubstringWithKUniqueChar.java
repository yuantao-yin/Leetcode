package com.amaz;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueChar {

    public static int getLongestSubstringKDistinct(String s, int k) {
        int rst = 0;
        int j = 0; // start
        Map<Character, Integer> map = new HashMap();
        // move pointer i
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while (j <= i && map.size() > k) {
                char chj = s.charAt(j);
                if (map.get(chj) == 1) {
                    map.remove(chj);
                } else {
                    map.put(chj, map.get(chj) - 1);
                }
                // move pointer j, shrink the window [i to j]
                j++;
            }
            rst = Math.max(rst, i-j+1);
        }
        return rst;
    }


    public static void main(String[] args) {
        int rst = LongestSubstringWithKUniqueChar.getLongestSubstringKDistinct("eceba", 3);
        System.out.println(rst);
    }
}
