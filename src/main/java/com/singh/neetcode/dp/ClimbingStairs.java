package com.singh.neetcode.dp;

public class ClimbingStairs {
    /*
        You are climbing stairs. It takes n steps to reach the top
        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

        input: n = 2                                     1                   2-
        output: 2                                   1-

          input: n = 3                                 1                     2
          output:3                                   1    2-                -1   2x
                                                 1-
         n =4
                                                         1                    2
                                                    1       2           1            2-
                                                1     2-   1-   2x   1-    2x
                                             1-  2x

            n = 5                                   1                                         2
                                          1                  2                       1              2
                                    1         2           1     2-              1      2-        1-      2x
                              1        2-  1-    2x    1-    2x              1-    2x
                          1-

                 stairs(n=0) -> 0
                 stairs(n=1) -> 1    n < 2 -> n
                 stairs(n=2) -> 2
                 stairs(n=3) -> 3 = stairs(2) + stairs(1)
                 stairs(n=4) -> 5 = stairs(3) + stairs(2)
                 stairs(n=5) -> 8 = stairs(4) + stairs(3)
                 stiars(n) = stairs(n-1) + stairs(n-2)
     */

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        ClimbingStairs c = new ClimbingStairs();
        System.out.println(c.climbStairs(2));
        System.out.println(c.climbStairs(3));
        System.out.println(c.climbStairs(4));
        System.out.println(c.climbStairs(5));
    }
}
