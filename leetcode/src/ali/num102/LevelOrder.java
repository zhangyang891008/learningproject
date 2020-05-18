package ali.num102;

import java.util.*;
/*
102. 二叉树的层序遍历

给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
 */
public class LevelOrder {
    /**
     * 1.层次遍历:用queue保存节点顺序
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();

        if(root == null)
            return result;

        queue.add(root);


        TreeNode cur = null;
        while(!queue.isEmpty()){
            int countOfLevel = queue.size();
            List<Integer> nodes = new LinkedList<>();
            for (int i = 0; i < countOfLevel; i++) {
                cur = queue.remove();
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
                nodes.add(cur.val);
            }
            result.add(nodes);
        }

        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        root.left = n1;
        root.right = n2;
        List<List<Integer>> lists = new LevelOrder().levelOrder(root);
        System.out.println("finish");


    }
}
