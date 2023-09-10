package com.singh.google.dsa.trees;

public class BinaryTreeTraversal {

    StringBuilder preOrder = new StringBuilder();
    StringBuilder inOrder = new StringBuilder();
    StringBuilder postOrder = new StringBuilder();


    public void preOrderTraversal(BinaryTreeNode root) {
        // visit root first, then children
        if (root != null) {
            preOrder.append(root.val);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void inOrderTraversal(BinaryTreeNode root) {
        // visit left first, then root, then right
        if (root != null) {
            inOrderTraversal(root.left);
            inOrder.append(root.val);
            inOrderTraversal(root.right);
        }
    }

    public void postOrderTraversal(BinaryTreeNode root) {
        // visit children first, then root
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            postOrder.append(root.val);
        }
    }

    public static void main(String[] args) {
        BinaryTreeTraversal btt = new BinaryTreeTraversal();
        BinaryTreeNode root = new BinaryTreeNode(1,
                new BinaryTreeNode(2, new BinaryTreeNode(4), new BinaryTreeNode(5)),
                new BinaryTreeNode(3, new BinaryTreeNode(6), new BinaryTreeNode(7)));
        btt.preOrderTraversal(root);
        System.out.println(btt.preOrder);
        btt.inOrderTraversal(root);
        System.out.println(btt.inOrder);
        btt.postOrderTraversal(root);
        System.out.println(btt.postOrder);
    }
}
