package com.no1122;

import java.util.HashMap;
import java.util.Map;


/*
1122. 数组的相对排序
给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

示例：

输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]
 

提示：

arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
arr2 中的元素 arr2[i] 各不相同
arr2 中的每个元素 arr2[i] 都出现在 arr1 中

 */
public class RelativeSortArray {


    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if(arr1 == null || arr1.length <2 || arr2 == null || arr2.length<2)
            return arr1;

        Map<Integer,Integer> count = new HashMap<>();
        int sum = 0; //标记存在于arr2数组中的长度，也就是不存在于arr2中的数在arr1中的存储位置
        for (int i = 0; i < arr1.length; i++) {
            int pos = contains(arr2, arr1[i]);
            if(pos != -1){
                count.put(arr1[i], count.getOrDefault(arr1[i],0)+1);
                sum++;
            }

        }

        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            int times = count.get(arr2[i]).intValue();
            while(times>0){
                if(!count.containsKey(arr1[index])){
                    arr1[sum++] = arr1[index];
                }
                arr1[index++] = arr2[i];
                times--;
            }
        }

        //index~max之间需要排序
        if(index<arr1.length-1)
            sort(arr1, index);

        return arr1;
    }

    private void sort(int[] a, int index) {
        for (int i = a.length -1 ; i > index ; i--) {
            for (int j = index; j < i; j++) {
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    private int contains(int[] arr2, int i) {
        for (int j = 0; j < arr2.length; j++) {
            if(arr2[j] == i)
                return j;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("hello");
        /*
        int[] arr1 = {2,3,1,3,2,4,6,9,2};
        int[] arr2 = {2,1,4,3,9,6};
        */

        int [] arr1 ={26,21,11,20,50,34,1,18};
        int [] arr2 = {21,11,26,20};


        int[] ints = new RelativeSortArray().relativeSortArray(arr1, arr2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
