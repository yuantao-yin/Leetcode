package com.jiuzhang;

import java.util.Arrays;

public class PrefixSum {
    public static int[] getPrefixSum(int[] nums) {
        int[] rst = new int[nums.length + 1];
        rst[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            rst[i + 1] = rst[i] + nums[i];
        }
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(PrefixSum.getPrefixSum(new int[]{2, -3, 4, -1, 2})));
    }
}
