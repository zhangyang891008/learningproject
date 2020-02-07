package com.no677;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
实现一个 MapSum 类里的两个方法，insert 和 sum。

对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。

对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。

示例 1:

输入: insert("apple", 3), 输出: Null
输入: sum("ap"), 输出: 3
输入: insert("app", 2), 输出: Null
输入: sum("ap"), 输出: 5

 */
public class MapSum {

    private Node root = null;
    class Node{
        char ch;
        Map<String,Integer> valMap  = new HashMap<>();
        boolean isTail = true;
        Map<Character,Node> children = new HashMap();

        Node(char ch){
            this.ch = ch;
        }
    }

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node(' ');
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            //if(cur.ch == ' '){
                if(cur.children.containsKey(key.charAt(i))){
                    cur = cur.children.get(Character.valueOf(key.charAt(i)));
                    cur.valMap.put(key, val);
                }else{
                    Node node = new Node(key.charAt(i));
                    cur.children.put(key.charAt(i),node);
                    cur.isTail = false;
                    cur = node;
                    node.valMap.put(key,val);
                }
            //}else{

            //}

        }
    }

    public int sum(String prefix) {
        Node cur = root;
        int sum = 0;
        for (int i = 0; i < prefix.length(); i++) {
            cur = cur.children.get(Character.valueOf(prefix.charAt(i)));
            if(cur == null)
                     return sum;
            if(i == prefix.length()-1){
                for(Integer val: cur.valMap.values()){
                    sum += val;
                }
                return sum;
            }

            if(cur.isTail){
                return sum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MapSum sum = new MapSum();
        sum.insert("apple",3);
        sum.insert("app",3);
        sum.insert("ap",34);
        sum.insert("appeee",1);
        int val = sum.sum("b");
        System.out.println(val);
    }
}


