package com.no977;

/*

977.有序数组的平方
给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。

示例 1：

输入：[-4,-1,0,3,10]
输出：[0,1,9,16,100]
示例 2：

输入：[-7,-3,2,3,11]
输出：[4,9,9,49,121]
 

提示：

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A 已按非递减顺序排序。

 */
public class SortedSquares {
    public int[] sortedSquares(int[] A) {
        if(A==null)
            return null;
        if(A.length<1)
            return new int[]{};
        int[] ret = new int[A.length];
        if(A[0]>=0){
            //只有非负数
            for (int i = 0; i < A.length; i++) {
                ret[i] = A[i]*A[i];
            }
            return ret;
        }
        int index = A.length-1;
        if(A[A.length-1]<=0){
            //没有正数
            for (int i = 0; i < A.length; i++) {
                ret[index--] = A[i]*A[i];
            }
            return ret;
        }

        int bound = 0;

        //找到正负分界点
        while(A[bound]<0){
            bound++;
        }

        index = 0;
        int positive = bound;
        int negtive = bound-1;
        while(positive<A.length && negtive>=0){
            ret[index++] = A[positive]*A[positive]> A[negtive]*A[negtive]? A[negtive]*A[negtive--]: A[positive]*A[positive++] ;
        }
        while(positive<A.length){
            ret[index++] = A[positive]*A[positive++];
        }
        while(negtive>=0){
            ret[index++] = A[negtive]*A[negtive--];
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] arr = {-2};
        int[] ints = new SortedSquares().sortedSquares(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
