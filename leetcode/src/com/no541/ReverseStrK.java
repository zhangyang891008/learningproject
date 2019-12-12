package com.no541;

import java.util.Stack;

/*
541. 反转字符串 II
给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
示例:

输入: s = "abcdefg", k = 2
输出: "bacdfeg"
要求:

该字符串只包含小写的英文字母。
给定字符串的长度和 k 在[1, 10000]范围内。

 */
public class ReverseStrK {

    public String reverseStr(String s, int k) {

        Stack<Character> stack = new Stack<>();
        StringBuilder ret = new StringBuilder();
        boolean pushStack = true;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(pushStack){
                if(count < k -1) {
                    stack.push(s.charAt(i));
                    count++;
                }else{
                    stack.push(s.charAt(i));
                    //出栈
                    while(!stack.isEmpty()){
                        ret.append(stack.pop());
                    }
                    pushStack = false;
                    count = 0;
                }
            }else{
                if(count<k - 1){
                    ret.append(s.charAt(i));
                    count++;
                }else{
                    ret.append(s.charAt(i));
                    pushStack = true;
                    count = 0;
                }

            }
        }

        while(!stack.isEmpty()){
            ret.append(stack.pop());
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String s1 = new ReverseStrK().reverseStr(s, k);
        System.out.println(s1);

    }
}
