package com.flang.sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ShuffleArray {
    int[] nums;
    Random rand;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> shuffled = new LinkedList<Integer>();
        for (int num : nums) {
            int index = rand.nextInt(shuffled.size() + 1);
            shuffled.add(index, num);
        }

        int[] result = new int[shuffled.size()];
        for (int i = 0; i < shuffled.size(); i++)
            result[i] = shuffled.get(i);
        return result;
    }

    public static void main(String[] args) {
        ShuffleArray sa = new ShuffleArray(new int[]{1,2,3,4,5,6,7,8,9,10});
        sa.shuffle();
    }
}
