package com.no1277;

/*\
1277.统计全为1的正方形矩阵
给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。

示例 1：

输入：matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
输出：15
解释：
边长为 1 的正方形有 10 个。
边长为 2 的正方形有 4 个。
边长为 3 的正方形有 1 个。
正方形的总数 = 10 + 4 + 1 = 15.
示例 2：

输入：matrix =
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
输出：7
解释：
边长为 1 的正方形有 6 个。
边长为 2 的正方形有 1 个。
正方形的总数 = 6 + 1 = 7.
 

提示：

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1

 */
public class CountSquares {

    public int countSquares(int[][] matrix) {
        //List<String> ret = new ArrayList<>();
        int count = 0;
        int row = matrix.length;
        int col= matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean allOne = true;
                int cur_row = i;
                int cur_col = j;
                while(cur_row < row && cur_col < col){
                    allOne = true;
                    //检查当前行是否含有零元素
                    for (int k = j; k <= cur_col; k++) {
                        if(matrix[cur_row][k] == 0){
                            allOne = false;
                            break;
                        }
                    }
                    //检查当前列是否有零元素
                    for (int k = i; k <= cur_row && allOne; k++) {
                        if(matrix[k][cur_col] == 0){
                            allOne = false;
                            break;
                        }
                    }

                    if(!allOne)
                        break;
                    //如果符合要求，增加一个,否则会在前面的校验中直接返回
                    count++;
                    //ret.add("**(" + i+","+j+"),("+cur_row+","+cur_col+")" );
                    //行列各自增加一，进入下一轮校验
                    cur_row++;
                    cur_col++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,0,1},
                {1,1,0},
                {1,1,0}};
        int i = new CountSquares().countSquares(matrix);
        System.out.println(i);

    }
}


