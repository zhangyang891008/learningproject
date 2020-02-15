package com.interview55_1;

import java.util.ArrayDeque;
import java.util.Queue;

/*
面试题55 - I. 二叉树的深度
输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

例如：

给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。

提示：

节点总数 <= 10000
注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/

 */
public class MaxDepthOfTree {
    class TreeNode {
         int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    //1.递归
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    //2.非递归,层次遍历
    public int maxDepth2(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque();
        if(root == null)
            return 0;
        queue.offer(root);
        int level= 0;
        while(queue.size()>0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if(curNode.left!=null)
                    queue.offer(curNode.left);
                if(curNode.right!=null)
                    queue.offer(curNode.right);
            }
            level++;
        }
        return level;
    }


    public static void main(String[] args) {

    }
}
