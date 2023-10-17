package com.singh.grind;

import java.util.Objects;
import java.util.Stack;

public class Polish {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (!Objects.equals(s, "+") && !Objects.equals(s, "-") && !Objects.equals(s, "/") && !Objects.equals(s, "*")) {
                stack.push(Integer.parseInt(s));
            } else {
                int second = stack.pop();
                int first = stack.pop();
                if (Objects.equals(s, "+")) {
                    stack.push(first + second);
                } else if (Objects.equals(s, "-")) {
                    stack.push(first - second);
                } else if (Objects.equals(s, "/")) {
                    stack.push(first / second);
                } else {
                    stack.push(first * second);
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        Polish polish = new Polish();
        System.out.println(polish.evalRPN(tokens));
        tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(polish.evalRPN(tokens));
    }
}
