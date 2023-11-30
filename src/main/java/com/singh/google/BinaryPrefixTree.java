package com.singh.google;

import java.util.*;

public class BinaryPrefixTree {
    /*
        - ZIP encodes data using binary prefix trees (aka Huffman trees)
        - In a binary prefix tree, values can only appear at the leaves of
          the tree
        - To decode a file, we read bits from the file, use them to follow a
          path in the tree to a leaf, which determines a value:

          1. We start at the root of the tree
          2. When encountering a 0 bit, we descend to the left child, and
             when encountering a 1 bit we descend to the right child
          3. When reaching a leaf, we emit the value stored in the leaf

        Attached below is a sample tree:
          *      0 = left, 1 = right
         / \
        e   *        e = 0
           / \       b = 10
          b   z      z = 11

        To save the tree efficiently in ZIP files, we save a mapping from
        byte-value to bit-length. For example:
        {'b': 2, 'e': 1, 'z': 2} 'r': 3 ->

        To make sure the mapping only represents a single tree, the tree
        must satisfy the following properties:
          1. Short paths (in the tree) are to the left of long paths
          2. Within the same length, smaller values appear to the left of
             larger values (so 'b' to the left of 'z', etc.)

        The main question: Given the encoding (byte->length mapping),
        construct a valid tree. Analyze the runtime complexity.

     */

    /*
                *                              *
            *       *                       *      *
        2      2 2     2                 2    2  2   2


     */
    public HuffmanNode createBinaryPrefixTree(Map<Character, Integer> mapping) {
        HuffmanNode root = new HuffmanNode();
        if (mapping.isEmpty()) {
            return root;
        }
        // sort mapping
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>((a,b) -> (b.val - a.val));
        for (Map.Entry<Character, Integer> map : mapping.entrySet()) {
            char key = map.getKey();
            int value = map.getValue();
            pq.add(new HuffmanNode(key, value));
        }

        while (pq.size() != 1) {
            // get values value
            HuffmanNode small = pq.peek();
            pq.poll();
            HuffmanNode large = pq.peek();
            pq.poll();

            int combinedVal = large == null ? small.val : small.val + large.val;
            HuffmanNode node = new HuffmanNode('*', combinedVal, small, large);
            pq.add(node);
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('z', 2);
        mapping.put('b', 2);
        mapping.put('e', 2);
        mapping.put('g', 2);
        BinaryPrefixTree b = new BinaryPrefixTree();
        System.out.println(b.createBinaryPrefixTree(mapping));
        /*
        HuffmanNode{key=*, val=5,
            left=HuffmanNode{key=*, val=4,
                left=HuffmanNode{key=b, val=2, left=null, right=null},
                right=HuffmanNode{key=z, val=2, left=null, right=null}},
            right=HuffmanNode{key=e, val=1, left=null, right=null}}

                            *
                        *       e
                   b       z



         */
    }

}

class HuffmanNode {

    char key = '*';
    int val = -1;
    HuffmanNode left;
    HuffmanNode right;


    public HuffmanNode() {
    }
    public HuffmanNode(char key, int val) {
        this.key = key;
        this.val = val;
    }

    public HuffmanNode(char key, int val, HuffmanNode left, HuffmanNode right) {
        this(key, val);
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

