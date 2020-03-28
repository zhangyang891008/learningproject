package com.no515;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
515. 在每个树行中找最大值
您需要在二叉树的每一行中找到最大的值。

示例：
输入:

          1
         / \
        3   2
       / \   \
      5   3   9

输出: [1, 3, 9]
 */
public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        List<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return new ArrayList<>();
        queue.add(root);
        while(queue.size()>0){
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            TreeNode cur = null;
            for (int i = 0; i < size; i++) {
                cur = queue.remove(0);
                max = Math.max(cur.val,max);
                if(cur.left !=null){
                    queue.add(cur.left);
                }
                if(cur.right !=null){
                    queue.add(cur.right);
                }
            }
            retList.add(max);
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