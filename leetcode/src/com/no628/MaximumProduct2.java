package com.no628;

import java.util.Arrays;

/*
628. 三个数的最大乘积
给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

示例 1:

输入: [1,2,3]
输出: 6
示例 2:

输入: [1,2,3,4]
输出: 24
注意:

给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。

________________
方法二： 时间复杂度O(N),空间复杂度为O(1),比方法一的先排序的时间复杂度低

 */
public class MaximumProduct2 {

    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            if(curNum>max3){
                max3 = curNum;
                if(max2<max3){
                    int temp = max3;
                    max3 = max2;
                    max2 = temp;
                }
                if(max1<max2){
                    int temp = max2;
                    max2 = max1;
                    max1 =temp;
                }
            }

            if(curNum<min2){
                min2 = curNum;
                if(min1 > min2){
                    int temp = min1;
                    min1 = min2;
                    min2 = temp;
                }
            }
        }

        return Math.max( max1* min1*min2, max1*max2*max3 );
    }

    public static void main(String[] args) {
        int[] arr1 = {-9, -1, 4,6,9};

        int i = new MaximumProduct2().maximumProduct(arr1);
        System.out.println(i);
    }
}
