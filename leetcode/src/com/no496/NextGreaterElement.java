package com.no496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*

496. 下一个更大元素 I
给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。

nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。

示例 1:

输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
输出: [-1,3,-1]
解释:
    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
示例 2:

输入: nums1 = [2,4], nums2 = [1,2,3,4].
输出: [3,-1]
解释:
    对于num1中的数字2，第二个数组中的下一个较大数字是3。
    对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
注意:

nums1和nums2中所有元素是唯一的。
nums1和nums2 的数组大小都不超过1000。


**************************

nums2数组从末端遍历，存入data栈，如果栈中有元素，比较栈顶元素和当前元素的大小，如果栈顶元素小则出栈，这是为了找到当前元素最相近的较大元素。

 */

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        if(nums1 == null || nums1.length<1)
            return nums1;
        Stack<Integer> data = new Stack<>();
        int[] dataCreater = new int[nums2.length];
        int[] ret = new int[nums1.length];
        Map<Integer,Integer> dataMap = new HashMap<>();
        for (int i = nums2.length-1; i >= 0; i--) {
            while(!data.isEmpty() && data.peek()<nums2[i]){
                data.pop();
            }
            dataCreater[i] = data.isEmpty()?-1:data.peek();
            dataMap.put(Integer.valueOf(nums2[i]), dataCreater[i]);
            data.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            ret[i] = dataMap.get(Integer.valueOf(nums1[i]));
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] ints = new NextGreaterElement().nextGreaterElement(nums1, nums2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
