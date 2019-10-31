package com.no238;

/*
238. 除自身以外数组的乘积
给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

示例:

输入: [1,2,3,4]
输出: [24,12,8,6]
说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

进阶：
你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
*******************************

[1,2,3,4]
[1,1,2,6]

[1,2,3,4]
[1,1,1,1]
[24,12,4,1]

[1,1,2,6]
[24,12,4,1]
[24,12,8,6]

 */

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        if(nums == null || nums.length == 0)
            return nums;

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            left[i] = 1;
            right[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        for (int i = nums.length-2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            left[i] = left[i] * right[i];
        }

        return left;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};

        int[] ints = new ProductExceptSelf().productExceptSelf(arr);

    }
}
