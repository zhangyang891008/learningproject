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
public class LeafSimilar2 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        dfs(root1, leaves1);
        dfs(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    private void dfs(TreeNode root, List<Integer> leaves) {
        if(root != null){
            if(root.left == null && root.right == null)
                leaves.add(root.val);
            if(root.left != null)
                dfs(root.left, leaves);
            if(root.right != null)
                dfs(root.right, leaves);
        }
    }


}

