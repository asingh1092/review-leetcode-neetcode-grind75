package com.singh.old.neetcode.stack.medium;

import java.util.ArrayList;
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

       nums = 3 -> ["((()))", "(()())", "(())()", "()(())", "()()()" ]

                                                   (                                          )x
                                       (                               )
                              (                   )                   (                         )
                     (                 )  (              )         (       )              (         )
                (         )     (        )(       )   (     )    (   )   (     )        (    )   (       )
            (        ) (     )  ()      ()()      () ()     ()   ()  ()  ()   (  )     (  ) ( ) (  )    ( )

     */

    public static List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        backtrack(n, 0, ret, "");
        return ret;
    }

    private static void backtrack(int left, int right, List<String> ret, String formed) {
        if (left == 0 && right == 0) {
            ret.add(formed);
        }

        if (left > 0) {
            backtrack(left - 1, right + 1, ret, formed + "(");
        }

        if (right > 0) {
            backtrack(left,right - 1, ret,formed + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }

}
