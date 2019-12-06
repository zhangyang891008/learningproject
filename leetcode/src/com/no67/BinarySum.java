package com.no67;

import java.util.Stack;

/*
给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"

 */
public class BinarySum {
    public String addBinary(String a, String b) {
        Stack<Character> aStack = new Stack<>();
        Stack<Character> bStack = new Stack<>();
        if(a==null || a.length() == 0)
            return b;
        if(b==null || b.length() == 0)
            return a;
        //加数入栈
        for (int i = 0; i < a.length(); i++) {
            aStack.push(a.charAt(i));
        }

        for (int i = 0; i < b.length(); i++) {
            bStack.push(b.charAt(i));
        }
        //出栈相加

        int carry = 0;
        StringBuilder ret = new StringBuilder();
        while(!aStack.isEmpty() && !bStack.isEmpty()){
            char val_a = aStack.pop();
            char val_b = bStack.pop();
            int sum = carry + Integer.valueOf(val_a - 48) + Integer.valueOf(val_b - 48);
            switch (sum){
                case 0:
                    ret.append('0');
                    carry = 0;
                    break;
                case 1:
                    ret.append('1');
                    carry = 0;
                    break;
                case 2:
                    ret.append('0');
                    carry = 1;
                    break;
                case 3:
                    ret.append('1');
                    carry = 1;
                    break;
            }
        }

        while(!aStack.isEmpty()){
            char val_a = aStack.pop();
            int sum = carry + Integer.valueOf(val_a-48);
            switch(sum){
                case 0:
                    ret.append('0');
                    carry = 0;
                    break;
                case 1:
                    ret.append('1');
                    carry = 0;
                    break;
                case 2:
                    ret.append('0');
                    carry=1;
                    break;
            }
        }

        while(!bStack.isEmpty()){
            char val_b = bStack.pop();
            int sum = carry + Integer.valueOf(val_b-48);
            switch(sum){
                case 0:
                    ret.append('0');
                    carry = 0;
                    break;
                case 1:
                    ret.append('1');
                    carry = 0;
                    break;
                case 2:
                    ret.append('0');
                    carry=1;
                    break;
            }
        }

        if(carry==1)
            ret.append('1');

        return ret.reverse().toString();
    }

    public static void main(String[] args) {
        String s = new BinarySum().addBinary("1", "101");
        System.out.println(s);
    }
}
