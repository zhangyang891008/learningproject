package com.no208;

import java.util.HashMap;
import java.util.Map;

public class TrieTest{

    public static void main(String[] args) {
        /*
        String word = "helloword";
        String prefix = "hell8";
        Trie obj = new Trie();
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith(prefix);
        System.out.println(param_2);
        System.out.println(param_3);

         */

        Trie obj =  new Trie();
        obj.insert("Trie");
        obj.insert("insert");
    }
}

class Trie {

    TrieNode root;

    /** Initialize your data structure here. */

    public Trie() {
        root = new TrieNode('0');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if(cur.constains(c)){
                cur = cur.get(c);
                continue;
            }
            TrieNode node = new TrieNode(c);
            cur.insert(c, node);
            cur = node;
        }
        cur.setEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if(!cur.constains(c))
                return false;
            cur = cur.get(c);
        }
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if(!cur.constains(c))
                return false;
            cur = cur.get(c);
        }
        return true;
    }
}

class TrieNode{
    char ch;
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;

    public TrieNode(char ch){
        this.ch = ch;
    }

    public boolean constains(char ch){
        return children.containsKey(ch);
    }

    public void insert(char ch, TrieNode node){
        children.put(ch, node);
    }

    public TrieNode get(char ch){
        return children.get(ch);
    }

    public Trie[] getAll(){
        return (Trie[])children.values().toArray();
    }

    public void setEnd(boolean flag){
        isEnd = flag;
    }

    public boolean isEnd(){
        return isEnd;
    }

}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */