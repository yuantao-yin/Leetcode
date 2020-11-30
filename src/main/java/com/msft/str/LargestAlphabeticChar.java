package com.msft.str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string S, find the largest alphabetic character, whose both uppercase
 * and lowercase appear in S. The uppercase character should be returned. For example,
 * for S = "admeDCAB", return "D". If there is no such character, return "NO"
 */
public class LargestAlphabeticChar {
    public static String findStr(String s) {
        Set<Character> set = new HashSet<>();
        char maxChar = '0';
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c) && set.contains(Character.toUpperCase(c))) {
                if (c > maxChar) {
                    maxChar = c;
                }
            }
        }

        return maxChar == '0' ? "NO" : String.valueOf(Character.toUpperCase(maxChar));
    }

    public static void main(String[] args) {
        System.out.println(findStr("admeDCAB"));
    }
}
