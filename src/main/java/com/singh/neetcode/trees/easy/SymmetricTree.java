package com.singh.neetcode.trees.easy;


import com.singh.google.dsa.trees.BinaryTreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class SymmetricTree {

    /*
        go down leftmost side of tree
        go down rightmost side of tree
        check if equal
        go opposite direction


     */

    // recursive pre order dfs
    public boolean isSymmetric(BinaryTreeNode root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(BinaryTreeNode left, BinaryTreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    // iterative dfs with stack

}
