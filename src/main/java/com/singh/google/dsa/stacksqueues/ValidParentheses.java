package com.singh.google.dsa.stacksqueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    /*
        ()
        {}
        []
     */
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // for ), }, & ]
                if (stack.isEmpty()) {
                    return  false;
                }
                if (map.get(c) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
