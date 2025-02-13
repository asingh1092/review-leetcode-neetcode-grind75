package com.singh.old.random.trees;

import com.singh.old.google.dsa.trees.redo.TreeNode;

public class MaximumDepthOfBinaryTree {

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
