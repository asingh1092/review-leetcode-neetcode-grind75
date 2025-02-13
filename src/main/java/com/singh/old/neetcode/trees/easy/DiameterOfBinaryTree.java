package com.singh.old.neetcode.trees.easy;

import com.singh.old.google.dsa.trees.BinaryTreeNode;

public class DiameterOfBinaryTree {

    /*
        Given the root of a binary tree, return the length of the diameter of the tree

        The diameter of a binary tree is the length of the longest path between any two nodes in a tree

        The length of a path between two nodes is represented by the number of edges between them

        e.g.   1
             2   3
           4  5

           longest = 3; 4->2->1->3 or 5->2->1->3

             1
          2
          longest = 1

          // post order dfs

     */

    int diameter = 0;
    public int diameterOfBinaryTree(BinaryTreeNode root) {
        if (root == null) return 0;
        height(root);
        return diameter;
    }

    public int height(BinaryTreeNode root) {
        // Base case: if the root is null, the height is 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of the left and right subtrees
        int left = height(root.left);
        int right = height(root.right);

        // Update the diameter by taking the maximum diameter that passes through the current node
        diameter = Math.max(diameter, left + right);

        // Return the maximum depth of the current node by adding 1 to the maximum depth of its deepest subtree
        return Math.max(left, right) + 1;
    }
}
