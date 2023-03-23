package com.singh.neetcode.trees;

import com.singh.testing.binarytree.TreeNode;

public class MaximumDepthOfBinaryTree {
    /*
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
