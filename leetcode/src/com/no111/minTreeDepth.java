package com.no111;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/*
111. 二叉树的最小深度
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.

 */
public class minTreeDepth {

    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        ArrayList<TreeNode> nodeList = new ArrayList<>();
       int level = 0;
       nodeList.add(root);
       while(nodeList.size()>0){
           ++level;
           int size = nodeList.size();
           for (int i = 0; i < size; i++) {
               TreeNode cur = nodeList.remove(0);
               if(cur.left == null && cur.right == null)
                   return level;
               if(cur.left != null)
                   nodeList.add(cur.left);
               if(cur.right != null)
                   nodeList.add(cur.right);
           }
       }
       return 0;
    }

    public static void main(String[] args) {

    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}