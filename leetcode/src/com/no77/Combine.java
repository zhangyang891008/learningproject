package com.no77;

import java.util.ArrayList;
import java.util.List;

/*
77.组合
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        combine(ret, n,k,new ArrayList<>(), 1);
        return ret;
    }

    private void combine(List<List<Integer>> ret, int fence, int k, List<Integer> curList, int curVal){
        if(curList.size() == k){
            ret.add(curList);
            return;
        }

        for (int i = curVal; i <= fence ; i++) {
            List<Integer> integers = new ArrayList<>(curList);
            integers.add(i);
            combine(ret, fence,k,integers, i+1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> combine = new Combine().combine(n, k);
        for (List<Integer> integers : combine) {
            System.out.println("***");
            for (Integer integer : integers) {
                System.out.println(integer);
            }
        }
    }
}
