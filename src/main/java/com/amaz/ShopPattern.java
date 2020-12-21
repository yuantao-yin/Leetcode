package com.amaz;

import java.util.*;

public class ShopPattern {
    private static int getTrioMinimum(int numOfProducts, List<Integer> products_from,
                                      List<Integer> products_to) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i=1; i<= numOfProducts; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i=0; i<products_from.size(); i++) {
            graph.get(products_from.get(i)).add(products_to.get(i));
            graph.get(products_to.get(i)).add(products_from.get(i));
        }
        for (int i=1; i<=numOfProducts; i++) {
            for (int j=i+1; j<=numOfProducts; j++) {
                for (int k=j+1; k<=numOfProducts; k++) {
                    if (graph.get(i).contains(j) && graph.get(j).contains(k) && graph.get(k).contains(i)) {
                        int val = graph.get(i).size() + graph.get(j).size() + graph.get(k).size() - 6;
                        min = Math.min(min, val);
                    }
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<Integer> pFrom = Arrays.asList(1,1,2,2,3,4);
        List<Integer> pTo = Arrays.asList(2,3,3,4,4,5);
        int rst = ShopPattern.getTrioMinimum(5, pFrom, pTo);
        System.out.println(rst);
    }
}
