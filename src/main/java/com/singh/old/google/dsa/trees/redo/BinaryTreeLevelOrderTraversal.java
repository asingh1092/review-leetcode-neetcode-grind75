package com.singh.old.google.dsa.trees.redo;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    /*
        Time: O(n)
        Space: 1,2,4,8,16
               0 1 2 3 4 5 6
               O(2^h)
     */

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // set fixed length of queue
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    level.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            ret.add(level);
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        BinaryTreeLevelOrderTraversal t = new BinaryTreeLevelOrderTraversal();
        System.out.println(t.levelOrderTraversal(root));
    }
}
