package com.singh.old.google.dsa.trees.bst;

import com.singh.old.google.dsa.trees.BinaryTreeNode;

public class IsBinarySearchTree {

    /*
        Given the root, check if the tree is a binary search tree
            BST is..
                * the data value of every node in a node's left subtree is less than the data value of the that node
                * the data value of every node in a node's right subtree is greater than the data value of that node
                * the data value of every node is distinct

                3
            2       4
        1       5       6

        pre: root -> left, right
        in: left -> root -> right
        post: left, right, root

     */

    public static boolean isValidBST(BinaryTreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(BinaryTreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
