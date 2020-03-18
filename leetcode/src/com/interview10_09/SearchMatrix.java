package com.interview10_09;
/*
面试题 10.09. 排序矩阵查找  >>>240题相同
给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。

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
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
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

    }
}
