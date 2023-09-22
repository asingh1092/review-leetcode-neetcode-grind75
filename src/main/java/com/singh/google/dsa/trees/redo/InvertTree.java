package com.singh.google.dsa.trees.redo;

import com.singh.google.dsa.trees.BinaryTreeNode;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        // base case
        if (root == null) {
            return null;
        }
        // invert
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // recurse through
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


}
