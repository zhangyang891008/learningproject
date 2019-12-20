package com.no350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
350. 两个数组的交集 II

给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
我们可以不考虑输出结果的顺序。
进阶:

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
在真实的面试中遇到过这道题？

 */
public class ArrayIntersection2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int posA = 0;
        int posB = 0;
        List<Integer> ret = new ArrayList<>();
        while(posA < nums1.length && posB < nums2.length) {
            if(nums1[posA] < nums2[posB]){
                posA++;
            } else if(nums1[posA] > nums2[posB]){
                posB++;
            } else{
                ret.add(nums1[posA]);
                posA++;
                posB++;
            }
        }
        int[] num = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            num[i] = ret.get(i);
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] intersect = new ArrayIntersection2().intersect(nums1, nums2);
        for (int i : intersect) {
            System.out.println(i);
        }
    }
}
