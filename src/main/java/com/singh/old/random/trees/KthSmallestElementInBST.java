package com.singh.old.random.trees;

import com.singh.testing.binarytree.TreeNode;

import java.util.Stack;

public class KthSmallestElementInBST {

    // check left, check root, check right

    public int value = 0;
    public int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return value;
    }

    public void helper(TreeNode node) {
        if (node.left != null) helper(node.left);
        count--;
        if (count == 0) {
            value = node.val;
            return;
        }
        if (node.right != null) helper(node.right);
    }

    public int kthSmallestIterative(TreeNode root, int k) {
        if (root == null) {
            return  -1;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode left = root.left;
        while (left != null) {
            stack.push(left);
            left = left.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            k--;
            if (k == 0) {
                return node.val;
            }
            TreeNode right = node.right;
            while (right != null) {
                stack.push(right);
                right = right.right;
            }
        }
        return -1;
    }
}
