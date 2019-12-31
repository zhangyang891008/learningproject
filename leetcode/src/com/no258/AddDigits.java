package com.no258;

/*
258. 各位相加
给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。

示例:

输入: 38
输出: 2
解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
进阶:
你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？

 */
public class AddDigits {

    public int addDigits(int num) {
        while(num>9){
            int sum = 0;
            while(num>0){
                sum += num%10;
                num = num/10;
            }
            num = sum;
        }

        return num;
    }

    public int addDigits2(int num) {
        if(num==0)
            return 0;
        return (num % 9 )!=0? num%9 : 9;
    }
    public static void main(String[] args) {
        int i = new AddDigits().addDigits2(38);
        System.out.println(i);
    }
}
