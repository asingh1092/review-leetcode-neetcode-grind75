package com.singh.old.random.trees;

import com.singh.old.google.dsa.trees.redo.TreeNode;

public class LowestCommentAncestorOfABinaryTree {
    /*
        Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

        According to the definition of LCA on Wikipedia:
        “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q
        as descendants (where we allow a node to be a descendant of itself).”

        // post order traversal

        // base case is root

                                                                   3
                                                             5           1
                                                         6      2   0       8
                                                             7    4

                                                       1. check if q is under p
                                                       2. check if p is under q
                                                       3.


        if (root != null) {
            dfs(root.left);
            dfs(root.right);
            System.out.println(root);
        }

        1.  see if
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

}
