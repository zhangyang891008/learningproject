package com.no18;

import java.util.*;

/*
18. 四数之和
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：
4
-1,5
-4
-1 -3

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class FourSum {

    static int count = 0;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        //TODO 不会啊。。。
        Arrays.sort(nums);

        List<List<Integer>> ret = new ArrayList<>();
        sum(ret, new ArrayList<Integer>(),nums, target,0);

        //System.out.println("count:"+count);
        return ret;
    }

    private void sum(List<List<Integer>> ret, ArrayList<Integer> integers,
                     int[] nums, int leftSum, int curPos) {
        //count++;
        if(integers.size() == 4){
            if(leftSum == 0){
                ret.add(integers);
            }
            return ;
        }

        if(curPos < nums.length){
            for (int i = curPos; i < nums.length && ( integers.size() + (nums.length - i) >=4 ); i++) {
                if( nums[i]>= 0 && leftSum >= nums[i] || nums[i]<0  ){

                    //if(i == 0 || nums[i]!= nums[i-1]){
                        ArrayList<Integer> temp = new ArrayList<>(integers);
                        temp.add(nums[i]);
                        sum(ret, temp, nums, leftSum - nums[i], i+1);
                    //}
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> lists = new FourSum().fourSum(nums, target);
        for (List<Integer> list : lists) {
            System.out.println("***");
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
}
