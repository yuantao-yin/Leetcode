package com.flang.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * LC 356
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.
 *
 * Example 1:
 * Input: [[1,1],[-1,1]]
 * Output: true
 *
 * Example 2:
 * Input: [[1,1],[-1,-1]]
 * Output: false
 */
public class LineReflection {

    public static boolean isReflected(int[][] points) {
        if(points == null || points.length < 2) {
            return true;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Map<Integer, HashSet<Integer>> map = new HashMap();
        for (int[] p : points) {
            max = Math.max(max, p[0]);
            min = Math.min(min, p[0]);
            HashSet<Integer> set = map.get(p[0]);
            if (set == null) {
                set = new HashSet<>();
                map.put(p[0], set);
            }
            set.add(p[1]);
        }
        int y = max + min;
        for (int[] p : points) {
            int right = y - p[0];
            if (!map.get(right).contains(p[1]) || map.get(right) == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{5,1}, {1,1}};
        System.out.println(isReflected(points));
        //System.out.println(isReflected(new int[][]{{1,1}, {-1,-1}}));
    }
}
