package com.no485;

/*
485.最大连续1的个数
给定一个二进制数组， 计算其中最大连续1的个数。

示例 1:

输入: [1,1,0,1,1,1]
输出: 3
解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
注意：

输入的数组只包含 0 和1。
输入数组的长度是正整数，且不超过 10,000。

**************
时间复杂度O(N),空间复杂度O(1)

 */
public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length==0)
            return 0;
        int lastZero = -1;//假设-1位置存在一个0
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                maxLength = (i-lastZero-1) > maxLength ?  (i-lastZero-1):maxLength;
                lastZero = i;
            }
        }
        //计算末尾位置连续1的数量
        return (nums.length-lastZero-1) > maxLength ? (nums.length-lastZero-1):maxLength;
    }


    public static void main(String[] args) {
        int[] arr = {0,0,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}
