package com.singh.old.random.trees;

import com.singh.testing.binarytree.TreeNode;

public class SubtreeOfAnotherTree {

    public boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSameTree(root.left, subRoot) || isSameTree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        return root.val == subRoot.val && isSameTree(root.left, subRoot.left) && isSameTree(root.left, subRoot.right);
    }
}
