package com.flang.fb;

import java.util.HashMap;
import java.util.Map;

class PairSums {

    int numberOfWays(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int rst = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(k - arr[i])) {
                rst += map.get(k - arr[i]);
            }
            if (k-arr[i] == arr[i]) {
                rst--;
            }
        }
        return rst/2;
    }

    private static String rotationalCipher(String input, int rotationFactor) {
        if (input == null || input.length() == 0) return null;
        if (rotationFactor == 0) return input;
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char cipher = (char) ((c - 'A' + rotationFactor) % 26 + 'A');
                sb.append(cipher);
            } else if (Character.isLowerCase(c)) {
                char cipher = (char) ((c - 'a' + rotationFactor) % 26 + 'a');
                sb.append(cipher);
            } else if (Character.isDigit(c)) {
                char cipher = (char) ((c - '0' + rotationFactor) % 10 + '0');
                sb.append(cipher);
            } else {
                sb.append(c);
            }

        }
        return sb.toString();
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        int k_1 = 6;
        int[] arr_1 = {1, 2, 3, 4, 3};
        int expected_1 = 2;
        int output_1 = numberOfWays(arr_1, k_1);
        check(expected_1, output_1);

        int k_2 = 6;
        int[] arr_2 = {1, 5, 3, 3, 3};
        int expected_2 = 4;
        int output_2 = numberOfWays(arr_2, k_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new PairSums().run();
        System.out.println(0%10);
    }
}