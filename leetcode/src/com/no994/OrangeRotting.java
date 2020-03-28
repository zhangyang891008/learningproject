package com.no994;

import java.util.*;

/*
994. 腐烂的橘子
在给定的网格中，每个单元格可以有以下三个值之一：

值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。

返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。

示例 1：

输入：[[2,1,1],[1,1,0],[0,1,1]]
输出：4
示例 2：

输入：[[2,1,1],[0,1,1],[1,0,1]]
输出：-1
解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
示例 3：

输入：[[0,2]]
输出：0
解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。


提示：

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] 仅为 0、1 或 2
 */
public class OrangeRotting {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        //找到腐烂橘子
        Queue<Integer> queue = new ArrayDeque(); //存储层次遍历的节点
        Map<Integer,Integer> levels = new HashMap<>();  //存储节点是第几层腐烂的
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 2){
                    queue.add(i*col+j);
                    levels.put(i*col+j,0);
                }
            }
        }
        //腐烂的橘子作为0层进行广度优先遍历
        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.remove();
            int x = node/col;
            int y = node%col;
            if(x-1>=0 && grid[x-1][y]==1){
                grid[x-1][y] = 2;
                int freshNode = (x-1)*col+y;
                queue.add(freshNode);
                levels.put(freshNode,levels.get(node)+1);
                count = levels.get(freshNode);
            }
            if(x+1<row && grid[x+1][y]==1){
                grid[x+1][y] = 2;
                int freshNode = (x+1)*col+y;
                queue.add(freshNode);
                levels.put(freshNode,levels.get(node)+1);
                count = levels.get(freshNode);
            }

            if(y-1>=0 && grid[x][y-1]==1){
                grid[x][y-1] = 2;
                int freshNode = x*col+(y-1);
                queue.add(freshNode);
                levels.put(freshNode,levels.get(node)+1);
                count = levels.get(freshNode);
            }
            if(y+1<col && grid[x][y+1]==1){
                grid[x][y+1] = 2;
                int freshNode = x*col + (y+1);
                queue.add(freshNode);
                levels.put(freshNode,levels.get(node)+1);
                count = levels.get(freshNode);
            }
        }

        //判断是否还是新鲜橘子存在
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 1)
                    return -1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};
        int [][] arr2 = {{1},{2}};
        int i = new OrangeRotting().orangesRotting(arr2);
        System.out.println(i);
    }
}
