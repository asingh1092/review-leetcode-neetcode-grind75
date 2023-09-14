package com.singh.neetcode.trees.medium;

import com.singh.google.dsa.trees.BinaryTreeNode;
import com.singh.testing.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    /*
         Given the root of a binary tree, return the level order traversal of its nodes' values (i.e from left to right, level by level)

                3

            9      20

              15         7

          = [[3],[3,20],[15,7]

          // use iterative / recursive BFS

     */

    // iterative
    public List<List<Integer>> levelOrder(BinaryTreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return ret;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> newLevel = new ArrayList<>();
            int nodesInLevel = queue.size();
            for (int i = 0; i < nodesInLevel; i++) {
                BinaryTreeNode node = queue.poll();
                if (node != null) {
                    newLevel.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            ret.add(newLevel);
        }
        return ret;
    }

    // DFS using recursion
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        dfsHelper(ret, root, 0);
        return ret;
    }

    public void dfsHelper(List<List<Integer>> ret, TreeNode root, int height) {
        if (root == null) return;
        if (height >= ret.size()) {
            ret.add(new ArrayList<>());
        }
        ret.get(height).add(root.val);
        dfsHelper(ret, root.left, height + 1);
        dfsHelper(ret, root.right, height + 1);
    }
}
