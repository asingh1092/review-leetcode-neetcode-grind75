package com.singh.random;

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

    public static void main(String[] args) {
        System.out.println(reverseString("reverse"));
    }
}
