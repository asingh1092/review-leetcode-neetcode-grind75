package com.singh.old.google.dsa.trees.redo;

public class SymmetricTree {

    /*
        check root
        check

     */

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
}
