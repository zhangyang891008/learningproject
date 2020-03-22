package com.interview32_I;

import java.util.ArrayList;
import java.util.List;

/*
面试题32 - I. 从上到下打印二叉树
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回：

[3,9,20,15,7]

提示：

节点总数 <= 1000
 */
public class LevelOrder {

    public int[] levelOrder(TreeNode root) {
        if(root == null)
            return new int[0];
        List<Integer> retList = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while(queue.size()>0){
            TreeNode cur = queue.remove(0);
            retList.add(cur.val);
            if(cur.left !=null){
                queue.add(cur.left);
            }
            if(cur.right !=null){
                queue.add(cur.right);
            }
        }
        int[] retArr = new int[retList.size()];
        int index = 0;
        for (Integer integer : retList) {
            retArr[index++] = integer;
        }
        return retArr;
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
        int [] arr = new LevelOrder().levelOrder(root);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
