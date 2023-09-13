package com.singh.google.dsa.trees;

public class BalancedBinaryTree {
    private boolean result = true;

    // DFS -> Post order traversal
    public boolean isBalanced(BinaryTreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(BinaryTreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1)
            result = false;
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
