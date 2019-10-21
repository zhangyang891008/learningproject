package com.no283;

import java.util.Arrays;

/*
283.移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
********************
从-1位置开始记录非零元素下标，然后开始循环判断，如果当前位置元素i是零，直接下一个，如果非零，移动到++nonZeroPos的位置，最后把末几位全部填0


 */
public class MoveZero {
    public void moveZero(int[] nums){
        if(nums==null || nums.length<2)
            return;
        int nonZeroPos = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[++nonZeroPos] = nums[i];
            }
        }
        while(nonZeroPos<nums.length-1){
            nums[++nonZeroPos] = 0;
        }
    }


    public static void main(String[] args) {

        int[] arr ={1,0,0};
        new MoveZero().moveZero(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
