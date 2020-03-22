package com.interview32_II;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
面试题32 - II. 从上到下打印二叉树 II 》》》 类似于102题
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
提示：

节点总数 <= 1000
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> retList  = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        List<Integer> tempList = null;
        while(!queue.isEmpty()){
            tempList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.remove(0);
                tempList.add(curNode.val);
                if(curNode.left != null){
                    queue.add(curNode.left);
                }
                if(curNode.right !=null){
                    queue.add(curNode.right);
                }
            }
            retList.add(tempList);

        }

        return retList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        root.left = n1;
        TreeNode n2 = new TreeNode(3);
        root.right = n2;
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        n1.left = n3;
        n1.right = n4;
        List<List<Integer>> lists = new LevelOrder().levelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println("---");
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }

    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
