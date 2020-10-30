package com.flang.sort;

import java.util.*;
import java.util.stream.Collectors;

public class MapSortByValue {

    public static void firstWay() {

        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);

        List list = unsortMap.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toList());
        System.out.println(list);
    }

    public static void secondWay() {
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);

        List<Map.Entry<String, Integer>> list = new LinkedList(unsortMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println(list);
    }

    public static void main(String[] args) {
        firstWay();
        secondWay();

    }
}
