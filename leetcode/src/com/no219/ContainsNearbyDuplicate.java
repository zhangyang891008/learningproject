package com.no219;

import java.util.HashMap;
import java.util.Map;

/*
219.存在重复元素II
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。

示例 1:

输入: nums = [1,2,3,1], k = 3
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1
输出: true
示例 3:

输入: nums = [1,2,3,1,2,3], k = 2
输出: false

 */
public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> valueAndPos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(valueAndPos.containsKey(nums[i]) && (i- valueAndPos.get(nums[i]) <=k ))
                return true;
            valueAndPos.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        boolean b = new ContainsNearbyDuplicate().containsNearbyDuplicate(nums, k);
        System.out.println(b);
    }
}
