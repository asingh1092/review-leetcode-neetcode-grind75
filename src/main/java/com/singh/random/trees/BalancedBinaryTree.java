package com.singh.random.trees;

import com.singh.testing.binarytree.TreeNode;

public class BalancedBinaryTree {


    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return balanced;
        }
        height(root);
        return balanced;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);

        if (Math.abs(left - right) >= 2) {
            balanced = false;
        }
        return Math.max(left, right) + 1;
    }
}
