package com.lc.ladder.us.string;

public class CompareStrings {
    /**
     * Compare two strings A and B, determine whether A contains all of the characters in B.
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        if (A.length() < B.length()) {
            return false;
        }
        int count[] = new int[256];
        for (int i = 0; i < A.length(); i++) {
            count[A.charAt(i) + '0']++;
        }
        for (int i = 0; i < B.length(); i++) {
            count[B.charAt(i) + '0']--;
            if (count[B.charAt(i) + '0'] < 0) {
                return false;
            }
        }
        return true;
    }
}
