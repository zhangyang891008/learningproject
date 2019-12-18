package com.no961;

import java.util.ArrayList;
import java.util.List;

/*
961. 重复 N 次的元素
在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。

返回重复了 N 次的那个元素。
示例 1：

输入：[1,2,3,3]
输出：3
示例 2：

输入：[2,1,2,5,3,2]
输出：2
示例 3：

输入：[5,1,5,2,5,3,5,4]
输出：5
 

提示：

4 <= A.length <= 10000
0 <= A[i] < 10000
A.length 为偶数

 */
public class RepeatedNTimes {

    public static void main(String[] args) {
        int[] arr = {5,1,5,2,5,3,5,4};
        int i = new RepeatedNTimes().repeatedNTimes(arr);
        System.out.println(i);
    }

    public int repeatedNTimes(int[] A) {
        if(A==null || A.length ==0 )
            return -1;
        List<Integer> history = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if(history.contains(A[i])){
                return A[i];
            }
            history.add(A[i]);
        }
        return -1;
    }
}
