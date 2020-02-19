package com.no1302;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/*
1302.层数最深叶子节点的和
给你一棵二叉树，请你返回层数最深的叶子节点的和。
                1
             2     3
          4    5       6
        7                 8
示例：
输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
输出：15
 */
public class DeepestLeavesSum {
    //分层遍历
    public int deepestLeavesSum(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
        queue.offer(root);
        int sum = 0;
        while(!queue.isEmpty()){
            sum = 0;
            int levelCount = queue.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode curNode = queue.poll();
                sum += curNode.val;
                if(curNode.left != null)
                    queue.offer(curNode.left);
                if(curNode.right != null)
                    queue.offer(curNode.right);
            }

        }
        return sum;
    }

    private int level = -1;
    private int sum = 0;
    //深度优先遍历
    //1.如果level与curLevel相等，累加
    //2.如果level小于curLevel，更新
    public int deepestLeavesSum2(TreeNode root) {
        dfs(root,0);
        return sum;
    }
    private void dfs(TreeNode root, int curLevel) {
        if(root == null)
            return;
        if(level == curLevel){
            sum += root.val;
        }else if(level<curLevel){
            level = curLevel;
            sum = root.val;
        }

        dfs(root.left ,curLevel+1);
        dfs(root.right,curLevel+1);
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