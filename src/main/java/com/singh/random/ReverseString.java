package com.singh.random;

import java.util.Arrays;
import java.util.Stack;

public class ReverseString {

    /*
        reverse -> esrever
        Stack -> push each char and then pop until empty into sb
        time: o(n)
        space: o(n) + o(n) = o(2n) = O(n)

        to char array -> [r, e, v, e, r, s, e]
                                            ^

     */

    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static String reverseString2(String s) {
        char[] ret = new char[s.length()];
        char[] sArray = s.toCharArray();
        int pointer = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            ret[pointer] = sArray[i];
            pointer++;
        }
        return Arrays.toString(ret);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("reverse"));
        System.out.println(reverseString2("reverse"));
    }
}
