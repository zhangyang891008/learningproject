package com.no1137;

/*
1137.第N个泰波那契数
泰波那契序列 Tn 定义如下： 
T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
给你整数 n，请返回第 n 个泰波那契数 Tn 的值。

示例 1：

输入：n = 4
输出：4
解释：
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
示例 2：

输入：n = 25
输出：1389537
 

提示：

0 <= n <= 37
答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
*******************

要缓存中间结果，否则会超时
 */
public class Tribonacci {

    int[] arr = new int[38];
    public int tribonacci(int n) {
        if(n<0)
            return 1;
        return getN(n);
    }
    private int getN(int n){
        switch(n){
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 1;
            default:
                int a = arr[n-1] == 0? getN(n-1):arr[n-1];
                int b = arr[n-2] == 0? getN(n-2):arr[n-2];
                int c = arr[n-3] == 0? getN(n-3):arr[n-3];
                arr[n] = a + b+c;
                return arr[n];


        }
    }
    public static void main(String[] args) {
        int tribonacci = new Tribonacci().tribonacci(4);
        System.out.println(tribonacci);
    }
}
