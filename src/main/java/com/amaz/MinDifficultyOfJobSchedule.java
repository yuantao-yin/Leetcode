package com.amaz;

import java.util.Arrays;

public class MinDifficultyOfJobSchedule {

    public static int minDifficulty(int[] jobDifficulty, int d) {
        int jLen = jobDifficulty.length;
        if (jLen < d) return -1;
        int[][] dp = new int[d][jLen];
        Arrays.stream(dp).forEach(a-> Arrays.fill(a, Integer.MAX_VALUE));
        int max = 0;
        for (int i = 0; i <= jLen - d; i++) {
            max = Math.max(max, jobDifficulty[i]);
            dp[0][i] = max;
        }
        for (int i = 1; i < d; i++) {
            for (int j = i; j <= jLen-d+i; j++) {
                max = 0;
                for (int k = j; k <= jLen-d+i; k++) {
                    max = Math.max(max, jobDifficulty[k]);
                    dp[i][k] = Math.min(dp[i][k], max + dp[i-1][j-1]);
                }
            }
        }
        return dp[d-1][jLen-1];
    }

    public static void main(String[] args) {
        System.out.println(MinDifficultyOfJobSchedule.minDifficulty(new int[]{6,5,4,3,2,1}, 3));
    }

}
