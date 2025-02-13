package com.singh.old.google.dsa.trees.redo;

public class SameTree {
    /*
           1. check if roots are same
           2. check if left is same
           3. check if right is same
           4. recurse
           5. base == check if both roots are null & both vals are the same && if either or are null

                1                     1
            2       3            2        3
         4                    4
     */

    public boolean sameTree(TreeNode first, TreeNode second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }
        return first.val == second.val && sameTree(first.left, second.left) && sameTree(first.right, second.right);
    }
}
