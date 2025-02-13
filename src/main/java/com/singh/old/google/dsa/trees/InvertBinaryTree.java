package com.singh.old.google.dsa.trees;

public class InvertBinaryTree {

    public static BinaryTreeNode invertTree(BinaryTreeNode root) {
        if (root != null) {
            // do something to left
            BinaryTreeNode left = invertTree(root.left);
            // do something to right
            BinaryTreeNode right = invertTree(root.right);
            root.right = left;
            root.left = right;

        }
        return root;
    }
}
