package com.no1287;

/*

1287.有序数组中出现次数超过25%的元素
给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。

请你找到并返回这个整数

示例：

输入：arr = [1,2,2,6,6,6,6,7,10]
输出：6
 
提示：

1 <= arr.length <= 10^4
0 <= arr[i] <= 10^5

 */
public class FindSpecialInteger2 {

    public int findSpecialInteger(int[] arr) {
        if(arr == null)
            return -1;
        int start = 0;
        int end = 0;
        int curVal = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == curVal){
                end = i;
            }else{
                if(end -start+1> arr.length/4){
                    break;
                }

                start = end = i;
                curVal = arr[i];
            }
        }
        return curVal;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,6,6,6,7,10};
        int specialInteger = new FindSpecialInteger2().findSpecialInteger(arr);
        System.out.println(specialInteger);
    }
}
