package com.no74;

/*
74. 搜索二维矩阵
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true
示例 2:

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
输出: false
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0|| matrix[0].length == 0)
            return false;
        int row = matrix.length;
        int col= matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        int mid = start + (end - start) /2;
        while(start <= end){
            int x = mid/col;
            int y = mid%col;
            if(target == matrix[x][y]){
                return true;
            }else if(target > matrix[x][y]){
                start = mid+1;
                mid = start + (end - start) /2;
            }else if(target < matrix[x][y]){
                end = mid-1;
                mid = start + (end - start) /2;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //System.out.println(2/3);
        int[][] matrix = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}};
        boolean b = new SearchMatrix().searchMatrix(matrix, 33);
        System.out.println(b);
    }
}
