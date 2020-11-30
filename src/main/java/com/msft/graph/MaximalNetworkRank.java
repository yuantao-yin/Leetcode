package com.msft.graph;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * There is an infrastructure of n cities with some number of roads connecting these cities. Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.
 *
 * The network rank of two different cities is defined as the total number of directly connected roads to either city. If a road is directly connected to both cities, it is only counted once.
 *
 * The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.
 *
 * Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.
 */
public class MaximalNetworkRank {

    public static int maximalNetworkRank(int n, int[][] roads) {
        if (roads.length == 0) return 0;
        int[][] matrix = new int[n][n];
        int[] degrees = new int[n];
        for (int[] road : roads) {
            matrix[road[0]][road[1]]++;
            matrix[road[1]][road[0]]++;
            degrees[road[0]]++;
            degrees[road[1]]++;
        }
        Stream.of(matrix)
            .flatMap(Stream::of)
            .forEach(x -> System.out.println(Arrays.toString(x)));
        System.out.println();
        System.out.println(Arrays.toString(degrees));

        int rst = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = degrees[i] + degrees[j] - matrix[i][j];
                rst = Math.max(rst, rank);
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[][] roads = new int[][] {
            {0,1},{0,3},{1,2},{1,3}
        };
        int[][] roads2 = new int[][] {
            {0,1}
        };
        //maximalNetworkRank(4, roads);
        maximalNetworkRank(2, roads2);
    }
}
