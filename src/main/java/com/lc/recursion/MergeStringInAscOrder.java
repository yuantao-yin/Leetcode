package com.lc.recursion;

public class MergeStringInAscOrder {
    private static String alphabeticMerge(String one, String two) {
        if (one == null || one.equals("")) {
            return two == null ? one : two;
        } else if (two == null || two.equals("")) {
            return one == null ? two : one;
        } else if (one.charAt(0) < two.charAt(0)) {
            return one.charAt(0) + alphabeticMerge(one.substring(1), two);
        } else {
            return two.charAt(0) + alphabeticMerge(one, two.substring(1));
        }
    }
    public static void main( String args[] ) {
        String one = "adz";
        String two = "bfx";
        String answer = alphabeticMerge(one, two);
        System.out.println(answer);
    }

}
