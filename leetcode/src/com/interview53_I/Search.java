package com.interview53_I;
/*
面试题53 - I. 在排序数组中查找数字 I
统计一个数字在排序数组中出现的次数。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: 0

限制：

0 <= 数组长度 <= 50000
 */
public class Search {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                count++;
            }
            if(nums[i] > target)
                break;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,8};
        int search = new Search().search(nums, 8);
        System.out.println(search);
    }
}
