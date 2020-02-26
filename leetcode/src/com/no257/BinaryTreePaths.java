package com.no257;

import java.util.ArrayList;
import java.util.List;

/*
257. 二叉树的所有路径
给定一个二叉树，返回所有从根节点到叶子节点的路径。
说明: 叶子节点是指没有子节点的节点。
示例:
输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

 */
public class BinaryTreePaths {

    private List<String> traverseList = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        traverse(root, ""+root.val);
        return traverseList;
    }

    private void traverse(TreeNode curNode, String curStr) {
        if(curNode.left == null && curNode.right == null){
            traverseList.add(curStr);
            return;
        }

        if(curNode.left != null){
            traverse(curNode.left, curStr+"->"+curNode.left.val);
        }
        if(curNode.right !=null){
            traverse(curNode.right, curStr+"->"+curNode.right.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        root.right = n1;
        TreeNode n2 = new TreeNode(2);
        root.left = n2;
        List<String> strings = new BinaryTreePaths().binaryTreePaths(root);
        strings.forEach(System.out::println);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}