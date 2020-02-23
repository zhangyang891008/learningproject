package com.no111;

import java.util.HashMap;
import java.util.Map;

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
public class minTreeDepth2 {

    static Map<TreeNode,Integer> map = new HashMap<>();

    public int minDepth(TreeNode root) {
        return getDepth(root);

    }

    private static int getDepth(TreeNode node){
        if(node == null){
            map.put(node,0);
            return 0;
        }

        int left = map.containsKey(node.left)? map.get(node.left):getDepth(node.left);
        int right = map.containsKey(node.right)?map.get(node.right):getDepth(node.right);
        if(left == 0){
            map.put(node,1+right);
            return 1+ right;
        }

        if(right == 0) {
            map.put(node,1+left);
            return 1 + left;
        }

        int min = 1+ Math.min(getDepth(node.left), getDepth(node.right));
        map.put(node,min);
        return min;
    }

    public static void main(String[] args) {

    }
}
