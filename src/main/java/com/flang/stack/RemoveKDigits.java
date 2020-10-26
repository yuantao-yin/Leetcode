package com.flang.stack;

import java.util.Stack;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack();
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            while(!stack.isEmpty() && stack.peek() > num.charAt(i) && count < k) {
                stack.pop();
                count++;
            }
            stack.push(num.charAt(i));
        }
        while(count < k) {
            stack.pop();
            count++;
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        sb = sb.reverse();
        int i = 0;
        while(i < sb.length() && sb.length() > 1 && sb.charAt(i) == '0') {
            i++;
        }
        sb.replace(0, i, "");
        if(sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String r = RemoveKDigits.removeKdigits("10200", 1);
        String r2 = RemoveKDigits.removeKdigits("1432219", 3);
        String r3 = RemoveKDigits.removeKdigits("10000", 1);
        System.out.println(r);
        System.out.println(r2);
        System.out.println(r3);
    }
}
