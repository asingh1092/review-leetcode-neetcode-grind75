package com.singh.random.trees;

import com.singh.testing.binarytree.TreeNode;

public class LowestCommonAncestorOfBST {

    TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            // check left side
            lca = lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val){
            lca = lowestCommonAncestor(root.right, p, q);
        } else {
            // if node is lca of both
            lca = root;
        }
        return lca;
    }
}
