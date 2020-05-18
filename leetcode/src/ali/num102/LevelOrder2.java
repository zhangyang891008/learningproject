package ali.num102;

import java.util.*;

public class LevelOrder2 {
    /**
     * 2递归方法：
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root ==null)
            return result;
        result.add(Arrays.asList(root.val));
        traverse(root.left, root.right, 1, result);
        return  result;
    }

    private void traverse(TreeNode left, TreeNode right, int level, List<List<Integer>> result) {
        if(left == null && right == null)
            return ;

        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        if(left != null) {
            result.get(level).add(left.val);
            traverse(left.left, left.right,level+1,result);
        }
        if(right != null) {
            result.get(level).add(right.val);
            traverse(right.left, right.right, level+1, result);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        root.left = n1;
        root.right = n2;
        List<List<Integer>> lists = new LevelOrder2().levelOrder(root);
        System.out.println("finish");


    }
}
