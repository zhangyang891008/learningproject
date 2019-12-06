package com.no917;

import java.util.Stack;

/*
917. 仅仅反转字母
给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。

示例 1：

输入："ab-cd"
输出："dc-ba"
示例 2：

输入："a-bC-dEf-ghIj"
输出："j-Ih-gfE-dCba"
示例 3：

输入："Test1ng-Leet=code-Q!"
输出："Qedo1ct-eeLg=ntse-T!"
 */
public class ReverseLettersOnly {
    public String reverseOnlyLetters(String S) {
        if(S==null || S.length()<2)
            return S;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if(canReverse(S.charAt(i))){
                stack.push(S.charAt(i));
            }
        }
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if(!canReverse(S.charAt(i))){
                ret.append(S.charAt(i));
            }else{
                ret.append(stack.pop());
            }
        }

        return ret.toString();

    }

    private static boolean canReverse(char c){
        if((c>='a' && c<='z') || (c>='A' && c<='Z') )
            return true;
        return false;
    }
    public static void main(String[] args) {
        String S = "a-bC-dEf-^ghIj!";
        String s = new ReverseLettersOnly().reverseOnlyLetters(S);
        System.out.println(s);
    }
}
