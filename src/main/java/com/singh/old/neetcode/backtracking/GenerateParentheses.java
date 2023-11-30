package com.singh.old.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {


    public List<String> generateParens(int n) {
        List<String> ret = new ArrayList<>();
        backtrack(n, 0, ret, "");
        return ret;
    }

    private void backtrack(int left, int right, List<String> ret, String formed) {
        // base case
        if (left == 0 && right == 0) {
            ret.add(formed);
        }

        // choose left
        if (left > 0) {
            backtrack(left - 1, right + 1, ret, formed + "(");
        }

        // choose right
        if (right > 0) {
            backtrack(left, right - 1, ret, formed + ")");
        }
    }

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        System.out.println(g.generateParens(3));
    }
}
