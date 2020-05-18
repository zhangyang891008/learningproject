package ali.num103;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
103. 二叉树的锯齿形层次遍历

给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]
 */
public class ZigzagLevelOrder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null)
            return result;

        queue.add(root);
        boolean zigzagFlag = true;
        while(!queue.isEmpty()){
            TreeNode cur = null;
            int countOfLevel = queue.size();
            List<Integer> nodes = new LinkedList<>();
            for (int i = 0; i < countOfLevel; i++) {
                cur = queue.remove();
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
                if(zigzagFlag) {
                    nodes.add(cur.val);
                }else {
                    nodes.add(0, cur.val);
                }
            }
            zigzagFlag = !zigzagFlag;
            result.add(nodes);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
