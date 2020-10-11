package com.flang.hashmap;

import java.util.HashMap;
import java.util.Map;

/*
In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only
if the given words are sorted lexicographicaly in this alien language.


Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app",
 because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 */

public class VerifyAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> dict = new HashMap();
        for (int i = 0; i < order.length(); i++) {
            dict.put(order.charAt(i), i);
        }

        int len = words.length;
        for (int i = 0; i < len - 1; i++) {
            int rst = 0;
            String s1 = words[i];
            String s2 = words[i+1];
            int j = s1.length();
            int k = s2.length();
            // get the shorter word
            int min = Math.min(j, k);
            for (int z = 0; z < min && rst == 0; z++) {
                // if the subtraction of two characters location is -1, the order is correct, continue
                rst = dict.get(s1.charAt(z)) - dict.get(s2.charAt(z));
            }
            // if the subtraction larger than 0 or equals to 0 and second string length is smaller than first
            // one (example 3), it means the words are not in order
            if (rst > 0 || (rst == 0 && min == k)) {
                return false;
            }
        }

        return true;
    }
}
