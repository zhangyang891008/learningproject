package com.no46;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
46. 全排列
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

 */
public class Permute {
    private List<List<Integer>> retList = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,1);
        }

        for (int num : nums) {
            map.put(num,0);
            ArrayList<Integer> list = new ArrayList<>();
            list.add(num);
            traverse(map,list,1);
            map.put(num,1);
        }
        return retList;
    }
    ArrayList<Integer> tempList = null;
    private void traverse(Map<Integer, Integer> map, ArrayList curList, int count) {
        if(count == map.keySet().size()){
            retList.add(curList);
            return;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1){
                //修改
                map.put(entry.getKey(),0);
                tempList = new ArrayList<>(curList);
                tempList.add(entry.getKey());

                traverse(map,tempList,count+1);
                map.put(entry.getKey(),1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = new Permute().permute(nums);
        for (List<Integer> integers : permute) {
            System.out.println("------");
            integers.forEach(System.out::println);
        }
    }
}
