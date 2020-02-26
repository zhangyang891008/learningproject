package com.no559;

import java.util.ArrayList;
import java.util.List;


/*
559. N叉树的最大深度
给定一个 N 叉树，找到其最大深度。

最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

例如，给定一个 3叉树 :
                    1
               /    |    \
               3    2     4
            /    \
           5     6

我们应返回其最大深度，3。
说明:
树的深度不会超过 1000。
树的节点总不会超过 5000。
 */
public class MaxTreeDepth {

    public int maxDepth(Node root) {
        if(root==null)
            return 0;
        List<Node> list =  new ArrayList<>();
        list.add(root);
        int level = 0;
        int size = 1;
        while(!list.isEmpty()){
            level++;
            size = list.size();
            for (int i = 0; i < size; i++) {
                Node remove = list.remove(0);
                if(remove.children!=null){
                    list.addAll(remove.children);
                }
            }
        }
        return level;
    }



    public static void main(String[] args) {

    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};