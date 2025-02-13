package com.singh.old.google.dsa.trees;

public class SameTree {

    /*
        Given the roots of two binary trees p and q, write a function to check if they are the same or not

        Two binary trees are considered the same if they are structurally identical and the nodes have the same value

        PRE ORDER: root, left, right
        IN ORDER: left, root, right
        POST ORDER: left, right, root

        preOrder traversal -> check root/parent of both to see if they are same, then go down left of both, then right

           1. check if roots are same
           2. check if left is same
           3. check if right is same
           4. recurse
           5. base == check if both roots are null & both vals are the same && if either or are null

                1                     1
            2       3            2        3
         4                    4
     */

    public static boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;

        }
    }

    public static void main(String[] args) {
        BinaryTreeNode p = new BinaryTreeNode(1, new BinaryTreeNode(2), null);
        BinaryTreeNode q = new BinaryTreeNode(1, null, new BinaryTreeNode(2));
        System.out.println(isSameTree(p, q));
    }

}
