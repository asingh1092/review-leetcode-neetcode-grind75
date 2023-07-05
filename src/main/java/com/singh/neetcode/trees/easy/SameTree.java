package com.singh.neetcode.trees.easy;

import com.singh.testing.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

    /*
        Given the roots of two bianry trees p and q, write a fucntion to check if they are the same or not

        Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

                    1                 1
               2         3       2          3

                    3                      3
                5       7             7         5
            4         2     8      8     2          4

                    3
                5       7
            4         2     8


                    3
                5       7
            4         2     8


                    1               1
                2                        2

            // check if null
            // check node -> pre order traversal
            // check left
            // check right
     */


    // recursive
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // both are null, then they are the same tree
        if (p == null && q == null) return true;
        // if only one of p and q is null then they are not the same tree
        if (p == null || q == null) return false;
        // if return vals of p and q are different, then they are not the same tree
        if (p.val != q.val) return false;
        // recursively check the lef+t and right subtrees of p and q
        // if both the left and right subtrees are the same , then p and q are the same tree
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // iterative
    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()){
            TreeNode f = queue.poll();
            TreeNode s = queue.poll();
            if(f == null && s == null){
                continue;
            }else if(f == null || s == null || f.val != s.val){
                return false;
            }
            queue.add(f.left);
            queue.add(s.left);
            queue.add(f.right);
            queue.add(s.right);
        }
        return true;
    }
}
