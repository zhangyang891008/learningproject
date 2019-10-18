package com.no905;

/*

905. 按奇偶排序数组
给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。

你可以返回满足此条件的任何数组作为答案。

 
示例：

输入：[3,1,2,4]
输出：[2,4,3,1]
输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 

提示：

1 <= A.length <= 5000
0 <= A[i] <= 5000

 */
public class OddEven {

    public int[] sortArrayByParity(int[] A) {
        if(A==null || A.length<2){
            return A;
        }
        int start = 0;
        int end = A.length-1;
        while(start<end){
            if(A[start]%2==1 && A[end]%2==0){
                swap(A,start,end);
            }else if(A[start]%2==0){
                start++;
            }else if(A[end]%2==1){
                end--;
            }

        }
        return A;
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0,5,3,6,8,2,9};
        int[] ints = new OddEven().sortArrayByParity(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
