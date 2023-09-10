package com.singh.google.dsa.trees;

public class SameTree {

    /*
        Given the roots of two binary trees p and q, write a function to check if they are the same or not

        Two binary trees are considered the same if they are structurally identical and the nodes have the same value

        PRE ORDER: root, left, right
        IN ORDER: left, root, right
        POST ORDER: left, right, root

        preOrder traversal -> check root/parent of both to see if they are same, then go down left of both, then right
     */

    public static boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }

    public static void main(String[] args) {
        BinaryTreeNode p = new BinaryTreeNode(1, new BinaryTreeNode(2), null);
        BinaryTreeNode q = new BinaryTreeNode(1, null, new BinaryTreeNode(2));
        System.out.println(isSameTree(p, q));
    }

}
