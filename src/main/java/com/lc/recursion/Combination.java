package com.lc.recursion;

import java.util.*;

/**
 * Given an array of size n, generate and print all possible combinations of r elements in array.
 * For example, if input array is {1, 2, 3, 4} and r is 2, then output should be {1, 2}, {1, 3},
 * {1, 4}, {2, 3}, {2, 4} and {3, 4}
 */
public class Combination {
    static void combinationUtil(int arr[], int data[], int start,
                                int end, int index, int r) {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            for (int j=0; j<r; j++)
                System.out.print(data[j]+" ");
            System.out.println("");
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }

    static void printCombination(int arr[], int n, int r) {
        // A temporary array to store all combination one by one
        int data[]=new int[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n-1, 0, r);
    }

    /*Driver function to check for above function*/
    public static void main (String[] args) {
        int arr[] = {1, 2, 3, 4};
        int r = 3;
        int n = arr.length;
        //printCombination(arr, n, r);

        List<List<Integer>> rst = permutation(arr, r);
        rst.forEach(x -> {
           System.out.println(Arrays.asList(x));
        });
    }


    public static List<List<Integer>> permutation(int[] arr, int r) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(arr, r, 0, path, res);
        return res;
    }

    private static void dfs(int[] arr, int r, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == r) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < arr.length; i++) {
            path.addLast(arr[i]);
            dfs(arr, r, i + 1, path, res);
            path.removeLast();
        }
    }
}
