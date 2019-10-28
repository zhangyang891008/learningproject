package com.no561;

/*
561. 数组拆分 I
给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。

示例 1:

输入: [1,4,3,2]

输出: 4
解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
提示:

n 是正整数,范围在 [1, 10000].
数组中的元素范围在 [-10000, 10000].
*******************


1,3,4,5,6,9




 */
public class ArrayPairSum {

    public int arrayPairSum(int[] nums) {
        if(nums == null)
            return 0;
        sort(nums, 0, nums.length-1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++,i++) {
            sum += nums[i];
        }

        return sum;
    }

    private void sort(int[] nums, int start , int end){
        if(start == end)
            return;

        int mid = start + (end - start)/2;
        sort(nums, start, mid);
        sort(nums, mid+1,end);
        merge(nums, start,mid,end);
        return;
    }

    private void merge(int[] nums, int start,int mid, int end) {

        int[] help = new int[end-start+1];
        int count = 0 ;
        int left = start;
        int right = mid+1;
        while(left<=mid && right<=end){
            if(nums[left] <= nums[right]){
                help[count++] = nums[left++];
            }else{
                help[count++] = nums[right++];
            }
        }
        while(left<=mid){
            help[count++] = nums[left++];
        }
        while(right<=end){
            help[count++] = nums[right++];
        }

        count = 0;
        //恢复数组
        for (int i = 0; i < help.length; i++) {
            nums[start+count] = help[count++];
        }

    }


    public static void main(String[] args) {
        int[] arr = {1,4,3,2,6,7};
        int i = new ArrayPairSum().arrayPairSum(arr);
        System.out.println(i);
    }
}
