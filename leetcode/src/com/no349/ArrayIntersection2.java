package com.no349;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayIntersection2 {

    public int[] intersection(int[] nums1, int[] nums2) {

        if(nums1 == null ||nums1.length<1)
            return nums1;
        if(nums2 == null || nums2.length<1)
            return nums2;

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < nums1.length ; i++) {
            set1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }

        if(set1.size()>set2.size()){
            for (Integer integer : set2) {
                if(set1.contains(integer)){
                    ret.add(integer);
                }
            }
        }else{
            for (Integer integer : set1) {
                if(set2.contains(integer)){
                    ret.add(integer);
                }
            }
        }

        return ret.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] intersection = new ArrayIntersection2().intersection(nums1, nums2);
        System.out.println();
    }
}
