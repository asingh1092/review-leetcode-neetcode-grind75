package com.singh.neetcode.trie;

public class Trie {

    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
       TrieNode t = root;
       for (int i = 0; i < word.length(); i++) {
           char c = word.charAt(i);
           if (t.children[c - 'a'] == null) {
               t.children[c - 'a'] = new TrieNode();
           }
           t = t.children[c - 'a'];
       }
       t.isWord = true;
    }

    public boolean search(String word) {
        TrieNode t = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (t.children[c - 'a'] == null) {
                return false;
            }
            t = t.children[c - 'a'];
        }
        return t.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode t = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (t.children[c - 'a'] == null) {
                return false;
            }
            t = t.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }
}

class TrieNode {

    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {
    }
}
