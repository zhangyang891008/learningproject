package com.no720;

import java.util.*;

/*
720. 词典中最长的单词
    给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。

若无答案，则返回空字符串。

示例 1:

输入:
words = ["w","wo","wor","worl", "world"]
输出: "world"
解释:
单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
示例 2:

输入:
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
输出: "apple"
解释:
"apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
注意:

所有输入的字符串都只包含小写字母。
words数组长度范围为[1,1000]。
words[i]的长度范围为[1,30]。

 */
public class LongestWord2 {

    //2。 Tire 字典树
    public String longestWord(String[] words) {
        Tire tire = new Tire();
        int index  = 0;
        for (String word : words) {
            tire.insert(word, ++index);
        }

        tire.words = words;
        String dfs = tire.dfs();
        return dfs;

    }

    class Node{
        char c;
        Map<Character, Node> children = new HashMap<>();
        int end;
        public Node(char ch){
            c = ch;
        }
    }

    class Tire{
        Node root;
        String[] words;

        public Tire(){
            root = new Node('0');
        }

        public void insert(String word, int index){
            Node cur = root;
            for (char c : word.toCharArray()) {
                cur.children.putIfAbsent(c, new Node(c));
                cur = cur.children.get(c);
            }
            cur.end = index;
        }

        public String dfs(){
            String ans = "";

            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                Node cur = stack.pop();
                if( cur.end>0 || cur == root){
                    if(cur != root){
                        String curWord = words[cur.end -1 ];
                        if(curWord.length() == ans.length() && curWord.compareTo(ans)<0 || curWord.length() > ans.length()){
                            ans = curWord;
                        }
                    }

                    for (Node node : cur.children.values()) {
                        stack.push(node);
                    }

                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        String[] strings = {"a", "banana", "app", "appl", "ap", "apple"};
        String s = new LongestWord2().longestWord(strings);
        System.out.println(s);
    }
}
