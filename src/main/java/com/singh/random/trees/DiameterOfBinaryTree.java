package com.singh.random.trees;

import com.singh.testing.binarytree.TreeNode;

public class DiameterOfBinaryTree {
    /*
                        1
                    1       1
                1       1
            1       1       1
        1       1
    1


     */

    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root){
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
}
