package ali.num200;

import java.util.ArrayDeque;
import java.util.Queue;

/*
200. 岛屿数量

给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

示例 1:

输入:
11110
11010
11000
00000
输出: 1
示例 2:

输入:
11000
11000
00100
00011
输出: 3
解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */
public class NumIslands {

    /*
    方法一：深度优先遍历，每当找到一个为1的点，将其所在的岛屿中的所有节点都表0
     */
    public static int gr;
    public static int gc;

    public int numIslands(char[][] grid) {
        if(grid==null || grid.length == 0){
            return 0;
        }
        gr = grid.length;
        gc = grid[0].length;

        int islandsCount = 0;
        for (int i = 0; i < gr; i++) {
            for (int j = 0; j < gc; j++) {
                if(grid[i][j] == '1'){
                    islandsCount++;
                    mark(grid, i, j);
                }
            }
        }

        return islandsCount;
    }

    private void mark(char[][] grid, int r , int c){
        if( r>=gr || c>=gc || r<0 || c < 0 || grid[r][c]=='0'){
            return ;
        }

        grid[r][c]= '0';

        mark(grid, r-1, c);
        mark(grid, r, c-1);
        mark(grid, r+1,c);
        mark(grid, r, c+1);
    }

    /*

     */
    public int numIslands2(char[][] grid) {
        if(grid==null || grid.length == 0){
            return 0;
        }
        int gr = grid.length;
        int gc = grid[0].length;

        int islandsCount = 0;

        Queue<Integer[]> queue = new ArrayDeque<>();
        int x = 0;
        int y = 0;

        for (int i = 0; i < gr; i++) {
            for (int j = 0; j < gc; j++) {

                if(grid[i][j] == '1'){

                    //1.统计岛屿数量
                    islandsCount++;

                    //2.加入队列进行广度优先遍历，把相同岛屿的其他节点都设置为0
                    queue.offer(new Integer[]{i,j});
                    while(!queue.isEmpty()){
                        Integer[] arr = queue.poll();

                        x = arr[0];
                        y = arr[1];

                        if( ((x-1) >=0) && grid[x-1][y] == '1'){
                            grid[x-1][y] = '0';
                            queue.offer(new Integer[]{x-1,y});
                        }

                        if( ( (x+1) < gr) && grid[x+1][y] == '1'){
                            grid[x+1][y] = '0';
                            queue.offer(new Integer[]{x+1,y});
                        }

                        if( ((y-1)>=0) && grid[x][y-1] == '1'){
                            grid[x][y-1] = '0';
                            queue.offer(new Integer[]{x,y-1});
                        }

                        if( ((y+1) < gc) && grid[x][y+1] == '1'){
                            grid[x][y+1] = '0';
                            queue.offer(new Integer[]{x,y+1});
                        }

                    }

                }
            }
        }

        return islandsCount;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','1'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','1'}};

        int i = new NumIslands().numIslands(grid);
        System.out.println(i);
    }
}
