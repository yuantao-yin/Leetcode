package com.lc.dp;

public class LongestCommonSubstringDP {

	   /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     * @bigO: O(AB)
     */
    public int longestCommonSubstring(String A, String B) {
        if (A.length() == 0 || B.length() == 0) {
            return 0;
        }    
        int aLen = A.length();
        int bLen = B.length();
        return helper(A, B, aLen, bLen);
    }
    
    private int helper(String A, String B, int m, int n) {
        int max = 0;
        int dp[][] = new int[m+1][n+1];
        dp[0][0] = 0;
        for (int i = 0; i <=m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = dp[i][j] > max ? dp[i][j] : max;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= m; i++) {
        	System.out.println();
            for (int j = 1; j <= n; j++) {
                System.out.print(dp[i][j]);
            }
        }
        return max;
    }	
	public static void main(String[] args) {
		LongestCommonSubstringDP test = new LongestCommonSubstringDP();
		String A = "lintcode.com code";
		String B = "echapter.com code";
		test.longestCommonSubstring(A, B);

	}

}
