package com.no167;

/*
167求两个数的和，有序

给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:

返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
示例:

输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。

 */
public class SumOfTwo {

    public static int[] twoSum(int[] numbers, int target){
        int[] ret = new int[2];
        int start = 0;
        int end = numbers.length-1;
        for(;;){
            if((numbers[start]+numbers[end]) == target){
                return new int[]{start+1, end+1};
            }else if(numbers[start]+numbers[end]<target){
                start++;
            }else{
                end--;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {-5,-2,-1,0,2};
        int[] ret = twoSum(arr, -6);
        System.out.println(ret[0]+","+ret[1]);

    }
}
