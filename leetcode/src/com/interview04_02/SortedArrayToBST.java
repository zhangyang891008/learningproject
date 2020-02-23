package com.interview04_02;

/*
面试题 04.02. 最小高度树
给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

示例:
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

          0
         / \
       -3   9
       /   /
     -10  5
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int mid = (nums.length-1)/2;
        TreeNode root = new TreeNode(nums[mid]);
        fillTree(nums, root,0,mid-1);
        fillTree(nums, root, mid+1,nums.length-1);
        return root;
    }

    private static void fillTree(int[] nums, TreeNode curNode, int start, int end){
        if(start>end){
            return ;
        }
        int mid = start + (end - start)/2;
        if(nums[mid] > curNode.val){
            TreeNode node = new TreeNode(nums[mid]);
            curNode.right = node;
            fillTree(nums, node, start, mid-1);
            fillTree(nums, node,mid+1,end);
        }else{
            TreeNode node = new TreeNode(nums[mid]);
            curNode.left = node;
            fillTree(nums,node ,start,mid-1);
            fillTree(nums,node,mid+1,end);
        }
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