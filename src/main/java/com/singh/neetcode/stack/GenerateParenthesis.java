package com.singh.neetcode.stack;

import java.util.Collections;
import java.util.List;

public class GenerateParenthesis {

    /*
        nums = 0 -> []
        nums = 1 -> ["()"] ->
            (
        )
        nums = 2 -> ["()()", "(())"] ->
                    (                   )x
                )          (
            (     )x   x(       )
        )     (x             x(   )

       nums = 3 ->

     */

    public List<String> generateParens(int n) {
        if (n > 0) {
            generateParens(n - 1);
        }
        return Collections.emptyList();
    }

}
