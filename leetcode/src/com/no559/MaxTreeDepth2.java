package com.no559;

import java.util.ArrayList;
import java.util.Collections;
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
public class MaxTreeDepth2 {
//递归
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }else if(root.children==null || root.children.isEmpty()){
            return 1;
        }else{
            List<Integer> childrenHeights = new ArrayList<>();
            for (Node child : root.children) {
                childrenHeights.add(maxDepth(child));
            }
            return Collections.max(childrenHeights)+1;
        }

    }



    public static void main(String[] args) {

    }
}
