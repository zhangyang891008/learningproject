package com.no90;

import java.util.*;

/*

90 子集2
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class SubsetsWithDup {

    Stack<Integer> path = new Stack<>();
    List<List<Integer>> retList = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //1.首先需要排序
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        findSub(nums, 0);
        return retList;

    }

    private void findSub(int[] nums, int start) {

        retList.add(new LinkedList<>(path));

        for (int i = start; i < nums.length; i++) {
            if((i-1)>=0 && (i-1)>= start && nums[i-1] == nums[i]) continue;
            path.push(nums[i]);
            findSub(nums, i+1);
            path.pop();
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,2};
        List<List<Integer>> lists = new SubsetsWithDup().subsetsWithDup(arr);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
