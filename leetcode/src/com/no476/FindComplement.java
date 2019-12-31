package com.no476;

import java.util.Stack;

/*

476.数字的补数
给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。

注意:

给定的整数保证在32位带符号整数的范围内。
你可以假定二进制数不包含前导零位。
示例 1:

输入: 5
输出: 2
解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
示例 2:

输入: 1
输出: 0
解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。
*******************

17
10001

01110
0 + 2 + 4 + 8 = 14
 */
public class FindComplement {

    public int findComplement(int num) {
        Stack<Integer> resultCache = new Stack<>();
        int countPos = 0;
        int complementNum = 0;
        while(num!=0){
            complementNum = complementNum + (((num%2)^1)<<countPos++);
            num = num/2;
        };

        return complementNum;
    }

    public static void main(String[] args) {
        int complement = new FindComplement().findComplement(17);
        System.out.println(complement);

        int temp = 1<<2;
        System.out.println(temp);
    }
}
