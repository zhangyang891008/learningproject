package com.no169;

/*
169.求众数
给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

**************方案
1.Boyer-Moore 投票算法:时间复杂度O(N),空间复杂度O(1)
2.分治法
3.哈希表法:需要额外的空间复杂度O(N)

 */

public class MajorityElement {
    public static int majorityElement(int[] nums){

        int curElem = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == curElem){
                count++;
            }else if(count == 0){
                curElem = nums[i];
                count = 1;
            }else{
                count--;
            }
        }
        return curElem;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        int i = majorityElement(arr);
        System.out.println(i);
    }
}
