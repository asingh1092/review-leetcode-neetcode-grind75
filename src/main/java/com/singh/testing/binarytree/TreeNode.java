package com.singh.testing.binarytree;

public class TreeNode {

    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {};

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
