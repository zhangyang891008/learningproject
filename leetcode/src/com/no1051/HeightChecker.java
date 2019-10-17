package com.no1051;

/*
1051. 高度检查器
学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。

请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。

 

示例：

输入：[1,1,4,2,1,3]
输出：3
解释：
高度为 4、3 和最后一个 1 的学生，没有站在正确的位置。
 

提示：

1 <= heights.length <= 100
1 <= heights[i] <= 100
**************
桶排序：时间复杂度为O(N),空间复杂度O(1)

 */
public class HeightChecker {

    public static int heightChecker(int[] heights){
        if(heights==null || heights.length<2){
            return 0;
        }
        //高度最高100，定以常数量的数组
        int[] arr = new int[101];

        for (int i = 0; i < heights.length; i++) {
            arr[heights[i]]++;
        }

        int count = 0;
        for(int i = 1,j=0;i<arr.length;i++){
            while(arr[i]>0){
                if(heights[j++]!=i)
                    count++;
                arr[i]--;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr = {1,1,4,2,1,3};
        int ret = heightChecker(arr);
        System.out.println(ret);
    }
}
