package com.flang.twopointer;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public static int totalFruit(int[] tree) {
        if (tree.length == 0) return 0;
        int max = 0;
        int left = 0;
        // use hashmap to track how many types of fruits we can have
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < tree.length; right++) {
            map.put(tree[right], map.getOrDefault(tree[right], 0) + 1);
            // if the map size bigger than 2, we know there are 3 type of fruits in the map
            // so we need to remove the element start from left pointer
            while (map.size() > 2) {
                if (map.get(tree[left]) == 1) {
                    map.remove(tree[left]);
                } else {
                    map.put(tree[left], map.get(tree[left]) - 1);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int rst = FruitIntoBaskets.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4});
        System.out.println(rst);
    }
}
