package com.no120;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
120. 三角形最小路径和
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

______________________
从末行开始，选择较小的值，与上一行的值相加。

 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        List<Integer> integers = triangle.get(m - 1);
        int n = integers.size(); //最后一行元素
        int[] dp = new int[m];

        for (int i = 0; i < n; i++) {
            dp[i] = integers.get(i);
        }

        for (int i = m-2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        int i = new MinimumTotal().minimumTotal(list);
        System.out.println(i);
    }
}
