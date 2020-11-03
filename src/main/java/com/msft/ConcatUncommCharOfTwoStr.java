package com.msft;

public class ConcatUncommCharOfTwoStr {
    public String concatenetedString(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len1; i++) {
            if (!s2.contains(String.valueOf(s1.charAt(i)))) {
                sb.append(s1.charAt(i));
            }
        }
        for (int i = 0; i < len2; i++) {
            if (!s1.contains(String.valueOf(s2.charAt(i)))) {
                sb.append(s2.charAt(i));
            }
        }
        return sb.toString();
    }
}
