package com.no513;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
513. 找树左下角的值
给定一个二叉树，在树的最后一行找到最左边的值。

示例 1:

输入:

    2
   / \
  1   3

输出:
1

示例 2:

输入:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

输出:
7

注意: 您可以假设树（即给定的根节点）不为 NULL。

 */
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int ret = root.val;  //**注意，在只有一个根结点的情况，所以此处要初始化为root值
        while(queue.size()>0){
            int size = queue.size();
            TreeNode cur = null;
            boolean isLeaf = true;
            for (int i = 0; i < size; i++) {
                cur = queue.remove(0);
                if (cur.left != null) {
                    if (isLeaf) {
                        ret = cur.left.val;
                        isLeaf = false;
                    }
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    if (isLeaf) {
                        ret = cur.right.val;
                        isLeaf = false;
                    }
                    queue.add(cur.right);
                }

            }
        }
        return ret;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        root.left = n2;
        root.right = n3;
        TreeNode n4 = new TreeNode(4);
        n2.left = n4;
        TreeNode n5 = new TreeNode(5);
        n3.left = n5;
        TreeNode n6 = new TreeNode(6);
        n3.right = n6;
        TreeNode n7 = new TreeNode(7);
        n5.left = n7;
        int bottomLeftValue = new FindBottomLeftValue().findBottomLeftValue(root);
        System.out.println(bottomLeftValue);
    }
}
 class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }