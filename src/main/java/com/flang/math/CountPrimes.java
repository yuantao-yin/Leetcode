package com.flang.math;

import com.flang.topological.CourseSchedule;

import java.util.Arrays;

public class CountPrimes {
    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (i % 2 == 0) {
                return false;
            }
        }
        return true;
    }
    public static int countPrimesSlow(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public static int countPrimes(int n) {
        boolean[] ans = new boolean[n];
        Arrays.fill(ans,true);
        for (int i = 2; i * i < n; i++) {
            if (ans[i]) {
                for (int j = 2; j * i < n; j++) {
                    ans[i * j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (ans[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(CountPrimes.countPrimes(10)); // 2,3,5,7
        System.out.println(CountPrimes.countPrimes(20)); // 2,3,5,7,11,13,17,19
    }
}
