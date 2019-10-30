package com.no697;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
697 数组的度
给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。

你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

示例 1:

输入: [1, 2, 2, 3, 1]
输出: 2
解释:
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.
示例 2:

输入: [1,2,2,3,1,4,2]
输出: 6
注意:

nums.length 在1到50,000区间范围内。

 */
public class FindShortestSubArray {

    public int findShortestSubArray(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;

        //第一遍循环，找到数组的度
        Map<Integer,Integer> timesMap = new HashMap<>();
        //找到并存储与度值出现次数相同的点
        List<Integer> values =  new ArrayList<>();
        int max = 0; //统计度
        for (int i = 0; i < nums.length; i++) {
            timesMap.put(nums[i],timesMap.getOrDefault(nums[i],0)+1);
            if(max == timesMap.get(nums[i]))
                values.add(nums[i]);
            if(max < timesMap.get(nums[i])){
                max = timesMap.get(nums[i]);
                values.clear();
                values.add(nums[i]);
            }
        }

/*
        for (Integer integer : timesMap.keySet()) {
            if(timesMap.get(integer) == max)
                values.add(integer);
        }
*/
        int minLength = Integer.MAX_VALUE;
        for (Integer value : values) {
            int left = 0;
            int right = nums.length - 1;
            //算出左右边界
            while(nums[left] != value)
                left++;
            while(nums[right] != value)
                right--;
            minLength = minLength < (right -left +1 ) ? minLength : (right -left+1); //与当前的间隔长度比较
        }

        return minLength;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,0,1};
        int shortestSubArray = new FindShortestSubArray().findShortestSubArray(arr);
        System.out.println(shortestSubArray);
    }
}
