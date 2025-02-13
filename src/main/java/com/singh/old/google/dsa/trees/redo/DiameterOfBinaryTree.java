package com.singh.old.google.dsa.trees.redo;

public class DiameterOfBinaryTree {

    /*
                  1
               2     3
             5  2      4
           2      6
                4
              5


     */
    int diameter = 0;
    public int diameterOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepthSoFar(root);
        return diameter;
    }

    private int maxDepthSoFar(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepthSoFar(node.left);
        int right = maxDepthSoFar(node.right);

        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }

    // calculate depth
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
