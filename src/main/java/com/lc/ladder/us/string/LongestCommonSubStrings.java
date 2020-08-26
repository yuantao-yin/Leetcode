package com.lc.ladder.us.string;

public class LongestCommonSubStrings {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     * @bigO: O(AB)
     */
    public int longestCommonSubstring(String A, String B) {
        int maxLen = 0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                int len = 0;
                while (i + len < A.length() && j + len < B.length() && A.charAt(i + len) == B.charAt(j + len)) {
                    len++;
                    if (len > maxLen) {
                        maxLen = len;
                    }
                }
            }
        }
        return maxLen;
    }
}
