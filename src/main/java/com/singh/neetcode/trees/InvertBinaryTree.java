package com.singh.neetcode.trees;

import com.singh.testing.binarytree.TreeNode;

public class InvertBinaryTree {

    /*
         Given the root of a binary tree, invert the tree, and return its root

                    4                     4
                  /   \
                 2     7     ->        7    2
               /  \  /   \
              1   3 6    9           9  6  3  1

              2             2
            1  3   ->   3     1

             parent -> switch right and left
                       TreeNode temp = right
                       right = left;
                       left = right;
             PRE ORDER!!!!!!!!!!!!!
     */


    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode root) {
        if (root != null) {
            // do a thing with root
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            helper(root.left);
            helper(root.right);
        }
    }
}
