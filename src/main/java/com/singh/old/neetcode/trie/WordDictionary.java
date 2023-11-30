package com.singh.old.neetcode.trie;

public class WordDictionary {


    /*
                         -
                 a*      b*       c*




     */
    // TODO

    DictTrieNode root;

    public WordDictionary() {
        root = new DictTrieNode();
    }

    public void addWord(String word) {
        DictTrieNode d = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (d.children[c - 'a'] == null) {
                d.children[c - 'a'] = new DictTrieNode();
                if (d.star == null) {
                    d.star = new DictTrieNode();
                }
                d.star.children[c - 'a'] = new DictTrieNode();
            }
            d = d.children[c - 'a'];
        }
        d.isWord = true;
    }

    public boolean search(String word) {
        DictTrieNode d = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (DictTrieNode ch : d.children)
                    if (ch != null && search(word.substring(i + 1))) {
                        return true;
                    }
                return false;
            }
            if (d.children[c - 'a'] == null) {
                return false;
            }
            d = d.children[c - 'a'];
        }
        return d != null && d.isWord;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("dad");
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}

class DictTrieNode {

    public boolean isWord;
    public DictTrieNode star;
    public DictTrieNode[] children = new DictTrieNode[26];

    public DictTrieNode() {
    }
}
