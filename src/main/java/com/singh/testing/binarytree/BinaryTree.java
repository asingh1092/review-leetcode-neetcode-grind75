package com.singh.testing.binarytree;

public class BinaryTree {
    private TreeNode root;
    public BinaryTree() {};

    public static void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            inOrderTraversal(node);
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(TreeNode node) {
        if (node != null) {
            preOrderTraversal(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            postOrderTraversal(node);
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1, new TreeNode(2, new TreeNode(4)), new TreeNode(3))
    }
}
