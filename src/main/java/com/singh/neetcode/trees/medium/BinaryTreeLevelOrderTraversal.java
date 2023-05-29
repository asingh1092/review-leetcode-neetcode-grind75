package com.singh.neetcode.trees.medium;

import com.singh.testing.binarytree.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    // using BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    level.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right !=null) {
                        queue.add(node.right);
                    }
                }
            }
            ret.add(level);

        }
        return ret;
    }

    // DFS
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
        dfsHelper(ret, root.left, height+1);
        dfsHelper(ret, root.right, height+1);
    }

}
