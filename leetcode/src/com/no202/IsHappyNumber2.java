package com.no202;

import java.util.HashSet;
import java.util.Set;

/*
202.快乐数
编写一个算法来判断一个数是不是“快乐数”。

一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

示例: 

输入: 19
输出: true
解释:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

 */
public class IsHappyNumber2 {
    public boolean isHappy(int n) {
        Set<Integer> visitHistory = new HashSet<>();
        int m = 0;
        while(true){
            while(n!=0){
                m += Math.pow(n%10,2);
                n = n/10;
            }

            if(m==1)
                return true;
            else if(visitHistory.contains(m)){
                return false;
            }else{
                visitHistory.add(m);
                n = m;
                m = 0;
            }
        }

    }

    public static void main(String[] args) {
        int number = 28;
        boolean happy = new IsHappyNumber2().isHappy(number);
        System.out.println(happy);
    }
}
