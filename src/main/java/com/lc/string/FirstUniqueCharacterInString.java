package com.lc.string;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

    public static int firstUniqCharBetter(String s) {
        int[] count = new int[26];
        Arrays.fill(count, 0);
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        Map<Character, Integer> map = new LinkedHashMap();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        char firstUnique = '0';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                firstUnique = entry.getKey();
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == firstUnique) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //System.out.println(FirstUniqueCharacterInString.firstUniqChar("dddccdbba"));
        System.out.println(FirstUniqueCharacterInString.firstUniqChar("leetcode"));
    }
}
