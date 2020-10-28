package com.flang.array;

import java.util.Arrays;

/**
 * LC:1470
 */
public class ShuffleTheArray {
    public static int[] shuffle(int[] nums, int n) {
        int [] ret = new int[2*n];
        for(int i=0;i<n;i++){
            ret[i*2]=nums[i];
            ret[i*2+1]= nums[n+i];
        }
        return ret;

    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        int[] b = a.clone();
        b[0] = 5;
        System.out.println(Arrays.toString(a));
        System.out.println(shuffle(new int[]{2,5,1,3,4,7}, 3));
    }

}
