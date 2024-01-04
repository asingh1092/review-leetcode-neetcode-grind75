package com.singh.grind75.week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class ValidParentheses {
    /*


     */

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        char[] sArray = s.toCharArray();
        for (char c : sArray) {
            if (c == '(' || c == '[' || c =='{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                else if (map.get(c) != stack.peek()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
