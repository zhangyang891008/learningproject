package com.no283;

/*
283.移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

 */
public class MoveZero {
    public static void moveZero(int[] nums){
        if(nums == null||nums.length<2)
            return;

        int curZero = 0;
        int curNonZero = 0;
        boolean finish = false;

        while(curZero < nums.length && curNonZero<nums.length){
            while(curZero<nums.length && nums[curZero]!=0){
                curZero++;
                if(curZero>nums.length-2){
                    finish = true;
                    break;
                }
            }
            curNonZero = curZero;
            while(curNonZero<nums.length && nums[curNonZero]==0){
                curNonZero++;
                if(curNonZero>nums.length-1){
                    finish = true;
                    break;
                }
            }

            //交换
            if(!finish){
                nums[curZero] = nums[curNonZero];
                nums[curNonZero]=0;
                curZero++;
            }
        }
    }


    public static void main(String[] args) {

        int[] arr = {0,1};
        moveZero(arr);
        System.out.println("finish");
    }
}
