package com.interview32_III;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
面试题32 - III. 从上到下打印二叉树 III
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [20,9],
  [15,7]
]

提示：

节点总数 <= 1000
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        List<List<Integer>> retList = new ArrayList<>();

        queue.add(root);
        List<Integer> tempList = null;
        boolean flag = true;
        while(queue.size()>0){
            tempList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove(0);
                tempList.add(cur.val);
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
            if(flag){
                retList.add(tempList);
                flag = false;
            }else{
                Collections.reverse(tempList);
                retList.add(tempList);
                flag = true;
            }

        }

        return retList;
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
