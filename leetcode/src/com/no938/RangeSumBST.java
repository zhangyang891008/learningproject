package com.no938;

/*
938. 二叉搜索树的范围和
给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。

二叉搜索树保证具有唯一的值。

示例 1：

输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
输出：32
示例 2：

输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
输出：23
 

提示：

树中的结点数量最多为 10000 个。
最终的答案保证小于 2^31。

 */
public class RangeSumBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null)
            return 0;
        int sum = partSum(root, L, R);
        return sum;
    }

    private static int partSum(TreeNode node,int L, int R){
        int sum = 0;
        if(node.val >= L && node.val <=R){
            sum += node.val;
        }

        if(node.left!= null && node.val >= L){
            sum += partSum(node.left, L, R);
        }
        if(node.right!= null && node.val <= R){
            sum += partSum(node.right,L,R);
        }
        return sum;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        root.left = node5;
        TreeNode node15 = new TreeNode(15);
        root.right = node15;
        TreeNode node3 = new TreeNode(3);
        node5.left = node3;
        TreeNode node7 = new TreeNode(7);
        node5.right = node7;
        TreeNode node18 = new TreeNode(18);
        node15.right = node18;

        int i = new RangeSumBST().rangeSumBST(root, 7, 15);
        System.out.println(i);
    }
}
