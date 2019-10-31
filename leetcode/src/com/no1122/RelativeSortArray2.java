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
***************************
方法2：桶排序

 */
public class RelativeSortArray2 {


    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if(arr1 == null || arr1.length <2 || arr2 == null || arr2.length<2)
            return arr1;
        int[] bucket = new int[1001];
        int[] notExist = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            if(isContains(arr2, arr1[i])){
                bucket[arr1[i]]++;
            }else{
                notExist[arr1[i]]++;
            }
        }

        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            int times = bucket[arr2[i]];
            while(times>0){
                arr1[index++] = arr2[i];
                times--;
            }
        }

        for (int i = 0; i < notExist.length && index < arr1.length; i++) {
            while(notExist[i]!=0){
                arr1[index++] = i;
                notExist[i]--;
            }
        }

        return arr1;
    }

    private boolean isContains(int[] a, int value) {
        for (int j = 0; j < a.length; j++) {
            if(a[j] == value)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println("hello");
 /*
        int[] arr1 = {2,3,1,3,2,4,6,9,2};
        int[] arr2 = {2,1,4,3,9,6};
      */

        int [] arr1 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int [] arr2 = {2,42,38,0,43,21};

 /*
        int [] arr1 ={26,21,11,20,50,34,1,18};
        int [] arr2 = {21,11,26,20};
*/

        int[] ints = new RelativeSortArray2().relativeSortArray(arr1, arr2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

/*

[301,831,772,544,337,869,243,650,948,708,98,857,796,821,526,283,695,859,628,88,798,131,938,825,529,519,548,779,471,336,983,452,843,227,49,192,879,524,496,339,792,281,975,370,449,124,815,994,469,972,887,797,590,190,752,78,65,662,549,159,648,853,901,133,986,809,768,980,847,637,136,303,240,578,514,587,672,717,432,611,274,793,484,329,891,776,617,771,917,436,2,750,174,141,357,862,880,898,391,748,242,375,144,396,394,995,641,876,997,683,168,773,812,349,997,698,405,737,640,39,454,1000,738,150,719,411,506,435,949,500,589,185,58,143,574,104,522,751,985,36,487,119,981,409,320,66,474,451,439,902,80,118,155,197,461,674,114,272,268,180,202,683,633,37,487,537,182,491,488,787,507,724,629,669,94,18,419,953,577,730,287,724,295,782,963,503,81,914,538,179,699,67,392,916,737,166,525,910,221,254]
[190,994,938,917,879,192,847,549,983,526,303,449,337,821,336,301,329,590,831,798,859,809,124,901,529,519,544,131,524,628,484,283,548,578,78,617,825,776,948,514,357,141,750,887,891,672,432,274,391,796,227,240,843,772,695,133,648,793,980,880,281,496,768,771,815,611,98,339,436,662,797,975,174,587,708,898,986,752,49,650,136,792,471,748,2,88,469,972,243,869,159,370,65,853,717,637,779,862,452,857]
 */