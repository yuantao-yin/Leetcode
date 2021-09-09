package com.lc.binarysearch;

import java.util.Arrays;

/**
 * LC 475
 * Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.
 *
 * Every house can be warmed, as long as the house is within the heater's warm radius range.
 *
 * Given the positions of houses and heaters on a horizontal line, return the minimum radius standard of heaters so that those heaters could cover all houses.
 *
 * Notice that all the heaters follow your radius standard, and the warm radius will the same.
 *
 * Example 1:
 *
 * Input: houses = [1,2,3], heaters = [2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 * Example 2:
 *
 * Input: houses = [1,2,3,4], heaters = [1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 * Example 3:
 *
 * Input: houses = [1,5], heaters = [2]
 * Output: 3
 *
 */
public class Heater {
    public int findRadius(int[] houses, int[] heaters) {
        // sort all the heaters
        Arrays.sort(heaters);
        int minHeatRadius = 0;
        for (int house: houses) {
            // get minHeatRadius for each house
            int radius = getMinRadius(house, heaters);
            // to keep every house has heat, get max value between minHeatRadius
            minHeatRadius = Math.max(radius, minHeatRadius);
        }
        return minHeatRadius;
    }

    private int getMinRadius(int house, int[] heaters) {
        int start = 0;
        int end = heaters.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (house == heaters[mid]) {
                return 0;
            } else if (house < heaters[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int left = Math.abs(heaters[start] - house);
        int right = Math.abs(heaters[end] - house);
        return Math.min(left, right);
    }

    public static void main(String[] args) {
        Heater h = new Heater();
        System.out.println(h.findRadius(new int[]{1,2,3}, new int[]{2}));
    }
}
