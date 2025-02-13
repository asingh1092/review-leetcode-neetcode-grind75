package com.singh.old.random.trees;

import com.singh.testing.binarytree.TreeNode;

public class CloneTree {

    public TreeNode cloneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode clone = new TreeNode(root.val);
        clone.left = cloneTree(root.left);
        clone.right = cloneTree(root.right);
        return clone;
    }
}
