package com.singh.neetcode.trees.easy;

import com.singh.testing.binarytree.TreeNode;

public class SubtreeOfAnotherTree {
    /*
        find in root tree where subroot begins if it does at all
        check if same tree moving forward, i.e if root at that point are same, and left, and right

        base: if (root != subRoot)
     */

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null){
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        return root.val == subRoot.val && isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }
}
