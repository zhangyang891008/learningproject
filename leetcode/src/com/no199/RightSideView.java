package com.no199;

import java.util.ArrayList;
import java.util.List;

/*
199. 二叉树的右视图
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:

输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */
public class RightSideView {
    //按层次遍历，找到每层最靠右（也就是最后一个元素）的元素，加入结果集合
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<TreeNode> tempList = new ArrayList<>();
        tempList.add(root);
        List<Integer> ret = new ArrayList<>();
        int size = 0;
        while(!tempList.isEmpty()){
            size = tempList.size();
            TreeNode curNode = null;
            for (int i = 0; i < size; i++) {
                curNode = tempList.remove(0);
                if(curNode.left!=null){
                    tempList.add(curNode.left);
                }
                if(curNode.right!=null){
                    tempList.add(curNode.right);
                }
            }
            ret.add(curNode.val);
        }

        return ret;
    }

    public static void main(String[] args) {

    }
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }