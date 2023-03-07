package com.singh.testing.binarytree;

public class BinaryTree {
    private TreeNode root;
    public BinaryTree() {};

    public StringBuilder inOrderSb = new StringBuilder();
    public StringBuilder preOrderSb = new StringBuilder();
    public StringBuilder postOrderSb = new StringBuilder();

    public void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            inOrderSb.append(node.value);
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(TreeNode node) {
        if (node != null) {
            preOrderSb.append(node.value);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            postOrderSb.append(node.value);
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4, null, null),
                                new TreeNode(5, null, null)),
                        new TreeNode(3,
                                new TreeNode(6, null, null),
                                new TreeNode(7, null, null)
                 )
        );
        /*
                                1
                           2        3
                         4   5    6   7
         */
        bt.inOrderTraversal(bt.root);
        System.out.println(bt.inOrderSb.toString());
        bt.preOrderTraversal(bt.root);
        System.out.println(bt.preOrderSb.toString());
        bt.postOrderTraversal(bt.root);
        System.out.println(bt.postOrderSb.toString());
    }
}
