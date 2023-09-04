package com.singh.neetcode.trees.easy;

import com.singh.testing.binarytree.TreeNode;

public class MaximumDepthOfBinaryTree {

   /*
                               5
                    3                      3
                5       7             7         5
            4         2     8      8     2          4

        Given the root of a binary tree, return its maximum depth

        A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the
        farthest leaf node.

    */

    public int maxDepth(TreeNode root) {
        // Base Condition
        if(root == null) return 0;
        // Hypothesis
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // Induction
        return Math.max(left, right) + 1;
    }

}