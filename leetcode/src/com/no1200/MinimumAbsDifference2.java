package com.no1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1200. 最小绝对差
给你个整数数组 arr，其中每个元素都 不相同。

请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。

示例 1：

输入：arr = [4,2,1,3]
输出：[[1,2],[2,3],[3,4]]
示例 2：

输入：arr = [1,3,6,10,15]
输出：[[1,3]]
示例 3：

输入：arr = [3,8,-10,23,19,-4,-14,27]
输出：[[-14,-10],[19,23],[23,27]]
 

提示：

2 <= arr.length <= 10^5
-10^6 <= arr[i] <= 10^6
**************
两次遍历：1次找到最小绝对值，第二次查找所有符合要求的结果。比方法一快一倍

 */
public class MinimumAbsDifference2 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        if(arr == null || arr.length == 0)
            return new ArrayList<>();
        Arrays.sort(arr);
        List<List<Integer>> minAbsDifference = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minDistance = minDistance < (arr[i] - arr[i-1]) ? minDistance : (arr[i] - arr[i-1]);
        }

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] -arr[i-1] == minDistance){
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i-1]);
                pair.add(arr[i]);
                minAbsDifference.add(pair);
            }
        }
        return minAbsDifference;
    }

    public static void main(String[] args) {
        int[] arr = {3,8,-10,23,19,-4,-14,27};
        List<List<Integer>> lists = new MinimumAbsDifference2().minimumAbsDifference(arr);
        for (List<Integer> list : lists) {
            System.out.println("***");
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
}
