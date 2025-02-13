package com.singh.old.google.dsa.trees.redo;

public class TreeHeight {

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right) + 1);
    }
}
