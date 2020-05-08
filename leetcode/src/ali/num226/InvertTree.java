package ali.num226;

/*
226. 翻转二叉树

翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class InvertTree {

  class TreeNode { int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }


    /*

    方法1：递归
     */
    public TreeNode invertTree(TreeNode root) {
        if(root ==null)
            return null;
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }


    /*

    方法2：广度优先遍历
     */
    public TreeNode invertTree2(TreeNode root) {

        if(root==null)
            return null;
        Queue<TreeNode>  queue = new ArrayDeque<>();

        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            TreeNode left = cur.left;
            TreeNode right= cur.right;
            cur.left = right;
            cur.right = left;
            if(left!=null)
                queue.offer(left);
            if(right!=null)
                queue.offer(right);
        }

        return root;
    }

    public static void main(String[] args) {

    }
}
