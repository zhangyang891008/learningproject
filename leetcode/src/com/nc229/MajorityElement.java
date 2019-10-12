package com.nc229;

/*
229.求众数2
给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。

示例 1:

输入: [3,2,3]
输出: [3]
示例 2:

输入: [1,1,1,3,3,2,2,2]
输出: [1,2]

**************
步骤：1，投票选出候选元素，2，比对验证候选元素是否符合要求

 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MajorityElement {

    public static List<Integer> majorityElement(int[] nums){
        if(nums==null||nums.length==0)
            return new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        if(nums.length ==1){
            tempList.add(nums[0]);
            return tempList;
        }

        int num1,num2,count1, count2;
        num1 = num2 = Integer.MAX_VALUE;
        count1 = count2 = 0;
        int len = nums.length/3;

        //查找候选元素
        for (int i = 0; i < nums.length; i++) {
            if(num1==nums[i]){
                count1++;
            }else if(num2 == nums[i]){
                count2++;
            }else if(count1==0){
                num1 = nums[i];
                count1++;
            }else if(count2 == 0){
                num2 = nums[i];
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0; //复用计数器
        //校验备选元素是否符合要求
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==num1){
                count1++;
            }
            if(nums[i]==num2){
                count2++;
            }

        }

        if(count1>len)
            tempList.add(num1);
        if(count2>len)
            tempList.add(num2);


        return tempList;
    }
    public static void main(String[] args) {
        int[] arr = {2,2};
        List<Integer> integers = majorityElement(arr);
        for (Integer integer : integers) {
            System.out.println("result:"+integer);
        }
    }
}
