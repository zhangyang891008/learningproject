package com.no108;

/*
108. 将有序数组转换为二叉搜索树
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

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
        int mid = (nums.length-1)/2;
        TreeNode root = new TreeNode(nums[mid]);

        fillTree(nums, 0, mid-1 , root);
        fillTree(nums, mid+1,nums.length-1,root);
        return root;
    }

    private void fillTree(int[] nums, int start, int end, TreeNode curNode) {
        if(start > end){
            return;
        }

        int mid = start + (end -start) /2;
        if(nums[mid] < curNode.val){
            TreeNode left = new TreeNode(nums[mid]);
            curNode.left = left;
            curNode = left;

        }else{
            TreeNode right = new TreeNode(nums[mid]);
            curNode.right = right;
            curNode = right;
        }

        fillTree(nums, start, mid-1,curNode);
        fillTree(nums, mid+1, end,curNode);

    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode treeNode = new SortedArrayToBST().sortedArrayToBST(nums);
        System.out.println(treeNode);
    }
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }