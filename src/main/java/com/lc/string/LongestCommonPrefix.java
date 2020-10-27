package com.lc.string;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String rst = "";
        int index = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (index >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return rst;
                }
            }
            index++;
            rst += strs[0].charAt(i);
        }
        return rst;
    }
}
