package com.no442;

import java.util.ArrayList;
import java.util.List;

/*
442. 数组中重复的数据

给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。

找到所有出现两次的元素。

你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？

示例：

输入:
[4,3,2,7,8,2,3,1]

输出:
[2,3]

 */
public class FindDuplicatesNumber {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> retList= new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            while(true){
                if(value == nums[value-1]){
                    if(!retList.contains(value) && (value!=(i+1)))
                        retList.add(value);
                    break;
                }else{
                    nums[i] = nums[value-1];
                    nums[value-1] = value;
                    value = nums[i];
                }
            }
        }
        return retList;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> retList= new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int value = Math.abs(nums[i]); //每个数组中的值用来标记是否访问过，访问过就设置成负数，如果访问发现是负数，说明之前就访问过。
            if(nums[value -1] < 0){
                if(!retList.contains(value))
                    retList.add(value);
            }else{
                nums[value-1] = -nums[value-1];
            }

        }
        return retList;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> duplicates = new FindDuplicatesNumber().findDuplicates2(nums);
        for (Integer duplicate : duplicates) {
            System.out.println(duplicate);
        }
    }
}
