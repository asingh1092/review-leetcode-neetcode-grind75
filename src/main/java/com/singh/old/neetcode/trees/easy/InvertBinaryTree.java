package com.singh.old.neetcode.trees.easy;

import com.singh.google.dsa.trees.BinaryTreeNode;

public class InvertBinaryTree {

    // pre order dfs
    public BinaryTreeNode invertTreePREORDER(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        // Swap children
        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreePREORDER(root.left);
        invertTreePREORDER(root.right);
        return root;
    }

    // post order dfs
    public BinaryTreeNode invertTreePOSTORDER(BinaryTreeNode root) {
        if (root != null) {
            // do something to left
            BinaryTreeNode left = invertTreePOSTORDER(root.left);
            // do something to right
            BinaryTreeNode right = invertTreePOSTORDER(root.right);
            root.right = left;
            root.left = right;

        }
        return root;
    }
}
