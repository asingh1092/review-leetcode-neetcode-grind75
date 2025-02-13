package com.singh.old.google.dsa.trees.redo;

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
