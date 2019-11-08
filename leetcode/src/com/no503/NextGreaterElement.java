package com.no503;

import java.util.Stack;

/*
给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。

示例 1:

输入: [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数；
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
注意: 输入数组的长度不会超过 10000。


***********************

tips:循环数组可以通过加倍的方式解决
a b c -> a b c a b c

 */
public class NextGreaterElement {

    public int[] nextGreaterElements(int[] nums) {

        if(nums ==null || nums.length <1)
            return nums;
        Stack<Integer> data = new Stack<>();
        int[] ret = new int[nums.length];

        for (int i = nums.length * 2 - 1; i >= 0; i--) {
            int real = i % nums.length;
            while(!data.isEmpty() && data.peek()<=nums[real]){
                data.pop();
            }
            ret[real] = data.isEmpty()?-1: data.peek();
            data.push(nums[real]);
        }

        return ret;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int[] ints = new NextGreaterElement().nextGreaterElements(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
