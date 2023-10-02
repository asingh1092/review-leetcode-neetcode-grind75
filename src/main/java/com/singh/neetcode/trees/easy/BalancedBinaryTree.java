package com.singh.neetcode.trees.easy;

import com.singh.google.dsa.trees.BinaryTreeNode;

public class BalancedBinaryTree {
    /*
          Given a binary tree, check if it is height balanced; meaning that the left and right subtrees height difference
          is no more than 1.

                        3
                    9       20
                        15      7

                    true

                        1
                    2       2
                3       3
            4       4

                    false

                    pre-order traversal? dfs

                        1. What do you want to know? if not null, check if height left or height of right > 1 at that point
                        2. | height(root.left) - height(root.right) | > 1



     */
    private boolean result = true;

    // DFS -> Post order traversal
    public boolean isBalanced(BinaryTreeNode root) {
        height(root);
        return result;
    }

    public int height(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            result = false;
        }
        return 1 + Math.max(left, right);
    }

}
