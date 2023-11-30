package com.singh.old.neetcode.stack.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    /*
        Given a string s containing just the chracters '(', ')', '{', '}', '[', ']'

        Determine if the input string is valid.
            1. Open brackets must be closed by the same type of brackets.
            2. Open brackets must be closed in the correct order.
            3. Every close bracket has a corresponding open bracket of the same type.

        "()" = true
        "()[]{}" = true
        "{]" = false
        {[()]} ->  )([{

     */
    public boolean isValidParentheses(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '('  || c == '[' || c == '{') {
                stack.push(map.get(c));
            } else {
                if (stack.isEmpty() || stack.peek() != c) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValidParentheses("()"));
        System.out.println(validParentheses.isValidParentheses("()[]{}"));
        System.out.println(validParentheses.isValidParentheses("(]"));
        System.out.println(validParentheses.isValidParentheses("{[()]}"));
        System.out.println(validParentheses.isValidParentheses("("));
        System.out.println(validParentheses.isValidParentheses("]"));

    }

}
