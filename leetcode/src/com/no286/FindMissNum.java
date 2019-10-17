package com.no286;

/*
给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

示例 1:

输入: [3,0,1]
输出: 2
示例 2:

输入: [9,6,4,2,3,5,7,0,1]
输出: 8

********
排序：
1.排序法；
    首先排序，
2.异或方法
    异或方法实现：时间复杂度O(N),空间复杂度O(1)
 */
public class FindMissNum {

    //异或方法实现
    public static int missingNumber(int[] nums){
        int ret = 0;
        for (int num : nums) {
            ret = ret ^ num;
        }

        for (int i = 0; i <= nums.length; i++) {
            ret = ret ^ i;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int ret = missingNumber(arr);
        System.out.println(ret);
    }
}

