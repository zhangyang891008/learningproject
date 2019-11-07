package com.no349;

import java.util.*;

/*

349. 两个数组的交集
给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [9,4]
说明:

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。

*******************
4 5 9
4 4 8 9 9


 */
public class ArrayIntersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null ||nums1.length <1)
            return nums1;
        if(nums2 == null || nums2.length<1)
            return nums2;

        List<Integer> ret = new ArrayList<>();
         //1.先排序
        sort(nums1);
        sort(nums2);

        int nums1Ptr = 0;
        int nums2Ptr = 0;

        while(nums1Ptr<nums1.length && nums2Ptr < nums2.length){
            if(nums1[nums1Ptr] == nums2[nums2Ptr]){

                if(!ret.contains(nums1[nums1Ptr])){
                    ret.add(nums1[nums1Ptr]);
                }
                nums1Ptr++;
                nums2Ptr++;
            }else if(nums1[nums1Ptr] < nums2[nums2Ptr]){
                nums1Ptr++;
            }else{
                nums2Ptr++;
            }
        }
        return ret.stream().mapToInt(i -> i).toArray();
    }

    private void sort(int[] arr){
        for (int i = arr.length-1; i >0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr, j,j+1);
                }
            }
        }
    }

    private void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;

    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] intersection = new ArrayIntersection().intersection(nums1, nums2);
        System.out.println();
    }
}
