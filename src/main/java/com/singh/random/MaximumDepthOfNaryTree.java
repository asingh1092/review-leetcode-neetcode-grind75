package com.singh.random;

import java.util.List;
class Node {
    public int val;
    public List<Node> children;

    public Node(int val) {
        val = this.val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}

/*
    Given an n-ary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

   Constraints:
   * total number of nodes is the range [0, 10^4]
   * the depth of the n-ary tree is less than or equal to 1000.

 */
public class MaximumDepthOfNaryTree {

    public int maxDepthRecursive(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 1;

        for (Node child : root.children) {
            max = Math.max(max, 1 + maxDepthRecursive(child));
        }
        return max;
    }

    public int maxDepthBFS(Node root) {

        return -1;
    }

    public static void main(String[] args) {

    }

}


