package com.singh.old.google.dsa.trees;

public class CloneTree {

    public BinaryTreeNode cloneTree(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode clone = new BinaryTreeNode(root.val);
        clone.left = cloneTree(root.left);
        clone.right = cloneTree(root.right);
        return clone;
    }
}
