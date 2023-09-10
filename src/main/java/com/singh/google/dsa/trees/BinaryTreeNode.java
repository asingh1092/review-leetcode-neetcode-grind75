package com.singh.google.dsa.trees;

import com.singh.testing.binarytree.TreeNode;

public class BinaryTreeNode {

    int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
