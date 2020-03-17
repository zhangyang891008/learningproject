package com.interview10_01;

/*
面试题 10.01. 合并排序的数组
给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。

初始化 A 和 B 的元素数量分别为 m 和 n。

示例:

输入:
A = [1,2,3,0,0,0], m = 3
B = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
说明:

A.length == n + m
 */
public class Merge {

    public void merge(int[] A, int m, int[] B, int n) {
        int aPos = m - 1;
        int bPos = n - 1;
        int cur = A.length -1;
        while(aPos >- 1 || bPos >- 1){
            if(aPos>=0 && bPos>=0){
                if(A[aPos] > B[bPos]){
                    A[cur] = A[aPos];
                    aPos--;
                    cur--;
                }else{
                    A[cur] = B[bPos];
                    bPos--;
                    cur--;
                }
            }else if(aPos>=0){
                A[cur--] = A[aPos--];
            }else if(bPos>=0){
                A[cur--] = B[bPos--];
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,0,0,0};
        int[] B = {2,5,6};
        int m = 3;
        int n = 3;
        new Merge().merge(A,m,B,n);
        for (int i : A) {
            System.out.println(i);
        }
    }
}
