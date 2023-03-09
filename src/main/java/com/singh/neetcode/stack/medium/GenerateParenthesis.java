package com.singh.neetcode.stack.medium;

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
    public List<String> generateParens(int n) {
        List<String> ret = new ArrayList<>();
        if (n <= 0) {
            return ret;
        } else {
            helper(n, 0, "", ret);
        }
        return ret;
    }

    public void helper(int left, int right, String res, List<String> ret) {
        if (left == 0 && right == 0) {
            ret.add(res);
        }
        if (left > 0) {
            helper(left - 1, right + 1,  res + "(", ret);
        }
        if (right > 0) {
            helper(left, right - 1, res + ")", ret);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParens(5));
    }

}
