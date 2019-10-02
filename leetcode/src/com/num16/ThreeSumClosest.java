package com.num16;

import java.util.Collections;

public class ThreeSumClosest {

    public static  int threeSumClosest(int[] nums, int target) {

    }

    private static void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        nums[i] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {-1,0,4,0};
        int ret = threeSumClosest(arr, 0);
        System.out.println(ret);

    }
}
