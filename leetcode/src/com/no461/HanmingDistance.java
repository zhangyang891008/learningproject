package com.no461;

/*
261.汉明距离

两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

给出两个整数 x 和 y，计算它们之间的汉明距离。

注意：
0 ≤ x, y < 231.

示例:

输入: x = 1, y = 4

输出: 2

解释:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

上面的箭头指出了对应二进制位不同的位置。
********************
异或得到不同的位置，然后统计

 */
public class HanmingDistance {

    public int hammingDistance(int x, int y) {
       int num =  x^y;
       int count = 0;
       if(num == 0)
           return count;

       while(num!=0){
           count+= num%2;
           num = num>>1;
       }
       return count;
    }
    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        int i = new HanmingDistance().hammingDistance(x, y);
        System.out.println(i);
    }
}
