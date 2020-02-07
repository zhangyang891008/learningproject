package com.no313;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
313. 超级丑数
编写一段程序来查找第 n 个超级丑数。

超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。

示例:

输入: n = 12, primes = [2,7,13,19]
输出: 32
解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
说明:

1 是任何给定 primes 的超级丑数。
 给定 primes 中的数字以升序排列。
0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
第 n 个超级丑数确保在 32 位有符整数范围内。

 */
public class NthSuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {

        Set<Integer> primesSet = new HashSet<>();
        for (int i = 0; i < primes.length; i++) {
            primesSet.add(primes[i]);
        }

        List<Integer> ret = new ArrayList<>();
        int count = 0;
        int curVal = 0;
        while(count < n){
            curVal++;
            boolean flag = true;
            for (int i = 2; i <= curVal; i++) {
                if(curVal % i == 0 && isPrime(i) && !primesSet.contains(i)){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                //ret.add(curVal);
                count++;
            }
        }
        //System.out.println(curVal);
        return curVal;

    }

    private boolean isPrime(int num){
        boolean flag = true;
        for (int i = 2; i < num; i++) {
            if(num % i == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int n = 12;
        int[] primes = {2,7,13,19};
        new NthSuperUglyNumber().nthSuperUglyNumber(n, primes);

    }
}
