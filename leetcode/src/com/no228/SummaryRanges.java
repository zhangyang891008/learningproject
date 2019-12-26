package com.no228;

import java.util.ArrayList;
import java.util.List;

/*
228. 汇总区间
给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。

示例 1:

输入: [0,1,2,4,5,7]
输出: ["0->2","4->5","7"]
解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
示例 2:

输入: [0,2,3,4,6,8,9]
输出: ["0","2->4","6","8->9"]
解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。

 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {

        if(nums==null || nums.length == 0)
            return new ArrayList<>();

        List<String> retList = new ArrayList<>();

        int head = nums[0];
        int tail = head;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i]- nums[i-1] == 1){
                tail = nums[i];
            }else{
                StringBuilder s = new StringBuilder();
                s.append(""+head);
                if( (tail-head) != 0){
                    s.append("->");
                    s.append(tail);
                }

                retList.add(s.toString());
                head = nums[i];
                tail = head;
            }
        }

        StringBuilder s = new StringBuilder();
        s.append(""+head);
        if((tail-head)!=0){
            s.append("->");
            s.append(tail);
        }
        retList.add(s.toString());

        return retList;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        List<String> strings = new SummaryRanges().summaryRanges(nums);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
