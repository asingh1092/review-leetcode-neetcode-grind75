package com.singh.old.google.dsa.stacksqueues.dfsstack;

import java.util.*;

public class CloneGraph {

    /*
        1                     2



       3                      4

       1: 2,3        1 -> 3 -> 4 -> 2
       2: 1,4
       3: 1,4
       4: 2,3
       1 -> 2,3
       3 -> 2,1,4
       4 -> 2
       2 ->
     */


    public Node cloneGraph(Node root) {
        if (root == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        return dfs(root, map);
    }

    private Node dfs(Node node, Map<Node, Node> map){
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node copy = new Node(node.val);
        map.put(node, copy);
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, map));
        }
        return copy;
    }
}
