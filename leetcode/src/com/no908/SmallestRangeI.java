package com.no908;

import java.util.Arrays;

/*
908. 最小差值 I
给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。

在此过程之后，我们得到一些数组 B。

返回 B 的最大值和 B 的最小值之间可能存在的最小差值。

示例 1：

输入：A = [1], K = 0
输出：0
解释：B = [1]
示例 2：

输入：A = [0,10], K = 2
输出：6
解释：B = [2,8]
示例 3：

输入：A = [1,3,6], K = 3
输出：0
解释：B = [3,3,3] 或 B = [4,4,4]
 

提示：

1 <= A.length <= 10000
0 <= A[i] <= 10000
0 <= K <= 10000

 */
public class SmallestRangeI {
    //时间复杂度O(N*logN)
    public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        return (A[A.length-1] - A[0] - 2*K) >0 ? (A[A.length-1] - A[0] - 2*K) :0;
    }

    //时间复杂度：O(N)
    public int smallestRangeI2(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
        return Math.max( max-min-2*K, 0);
    }

    public static void main(String[] args) {
        int[] A = {1,3,6};
        int K = 3;
        int i = new SmallestRangeI().smallestRangeI2(A, K);
        System.out.println(i);

    }
}
