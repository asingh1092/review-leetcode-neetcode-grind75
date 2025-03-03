package com.singh.old.google.dsa.stacksqueues.dfsstack;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public int val;
    public List<Node> neighbors;

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
