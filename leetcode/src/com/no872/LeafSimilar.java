package com.no872;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
872. 叶子相似的树

请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。

举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。

如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。

如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。

 */
public class LeafSimilar {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> allLeaves = getAllLeaves(root1);
        List<Integer> allLeaves1 = getAllLeaves(root2);
        if(allLeaves.size() != allLeaves1.size())
            return false;
        boolean flag = true;
        for (int i = 0; i < allLeaves.size(); i++) {
            if(allLeaves.get(i)!= allLeaves1.get(i)){
                flag = false;
                break;
            }
        }

        return flag;
    }

    private static List<Integer> getAllLeaves(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> list = new ArrayList<>();

        while(!stack.isEmpty() ){
            TreeNode cur = stack.pop();
            if(cur.right == null && cur.left ==null){
                list.add(cur.val);
            }
            if(cur.right != null ){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
        return list;
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