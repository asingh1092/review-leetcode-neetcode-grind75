package com.singh.google.dsa.trees.bst;

import com.singh.google.dsa.trees.BinaryTreeNode;

import java.util.Stack;

public class KthSmallestElementInBST {

    // iterative process
    public static BinaryTreeNode kthSmallestElement(BinaryTreeNode root, int k) {
        if (root == null) {
            return null;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) break;
            root = root.right;
        }
        return root;
    }
}
