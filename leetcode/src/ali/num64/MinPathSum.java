package ali.num64;

/*
64. 最小路径和

给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinPathSum {

    /*
    解答：典型的动态规划
     */
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(i==0 && j==0)
                    continue;
                int tempMin = Integer.MAX_VALUE;
                if(i!=0){
                    tempMin = Math.min(grid[i-1][j],tempMin);
                }
                if(j!=0){
                    tempMin = Math.min(grid[i][j-1], tempMin);
                }
                grid[i][j]= tempMin + grid[i][j];
            }
        }

        return grid[r-1][c-1];
    }

    public static void main(String[] args) {

    }
}
