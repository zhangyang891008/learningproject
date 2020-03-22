package com.no107;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
107. 二叉树的层次遍历 II
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(retList);
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
        List<List<Integer>> lists = new LevelOrderBottom().levelOrderBottom(root);
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
