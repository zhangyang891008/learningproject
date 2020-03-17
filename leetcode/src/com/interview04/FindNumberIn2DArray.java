package com.interview04;
/*
面试题04. 二维数组中的查找 》〉》与240题相同
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。
给定 target = 20，返回 false。

限制：
0 <= n <= 1000
0 <= m <= 1000
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length==0 || matrix[0].length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int rPos = 0;
        int cPos = col-1;
        while(rPos<row && cPos>=0){
            if(target == matrix[rPos][cPos]) {
                return true;
            }
            else if(target > matrix[rPos][cPos]){
                rPos++;
            }else if(target < matrix[rPos][cPos]){
                cPos--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        FindNumberIn2DArray res = new FindNumberIn2DArray();
        boolean find = res.findNumberIn2DArray(arr, 0);
        System.out.println(find);

    }
    
}
