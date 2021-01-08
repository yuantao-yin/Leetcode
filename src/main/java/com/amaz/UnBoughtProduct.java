package com.amaz;

import java.util.*;

/**
 * Design a method return a list of product that your friend bought but you didn't.
 * Sorted by most bought to least bought of the product numbers.
 */
public class UnBoughtProduct {

    public static List<Integer> productsToBuy(int[] friendProducts, int[] myProducts) {
        List<Integer> rst = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int p : friendProducts) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int p: myProducts) {
            set.add(p);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b).compareTo(map.get(a)));
        for (int key : map.keySet()) {
            if (!set.contains(key)) {
                queue.add(key);
            }
        }
        while (!queue.isEmpty()) {
            rst.add(queue.poll());
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] fp = new int[]{1,2,2,1,1,1,1,5,5,5,7,7,7,7,7,7,7,7,7,10,10, 8,8,8,8};
        int[] mp = new int[]{10,8,2};
        UnBoughtProduct.productsToBuy(fp, mp).stream().forEach(System.out::println);
    }
}
