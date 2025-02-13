package com.singh.old.random.trees;

import com.singh.testing.binarytree.TreeNode;

public class SameTree {

    /*
                    p               q
                 /     \       /        \


     */


    public boolean sameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }
}
