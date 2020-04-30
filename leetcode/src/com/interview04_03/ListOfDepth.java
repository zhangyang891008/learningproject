package com.interview04_03;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
面试题 04.03. 特定深度节点链表
给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。

示例：

输入：[1,2,3,4,5,null,7,8]

        1
       /  \
      2    3
     / \    \
    4   5    7
   /
  8

输出：[[1],[2,3],[4,5,7],[8]]
 */
public class ListOfDepth {

    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree ==null){
            return new ListNode[0];
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(tree);
        List<ListNode> retList = new ArrayList<>();
        while(queue.size()>0){

            int size = queue.size();
            TreeNode cur = queue.remove(0);
            ListNode list = new ListNode(cur.val);
            ListNode head = list;
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right !=null){
                queue.add(cur.right);
            }
            for (int i = 1; i < size; i++) {
                cur = queue.remove(0);
                list.next = new ListNode(cur.val);
                list = list.next;
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
            retList.add(head);
        }

        ListNode[] arr = new ListNode[retList.size()];
        retList.toArray(arr);
        return arr;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t7;
        t4.left = t8;

        ListNode[] listNodes = new ListOfDepth().listOfDepth(t1);


    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

