package com.no415;


import java.util.Stack;

/*
415.字符串相加
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

注意：

num1 和num2 的长度都小于 5100.
num1 和num2 都只包含数字 0-9.
num1 和num2 都不包含任何前导零。

 */
public class StringAddition {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num1.length() == 0)
            return num2;
        if(num2 == null || num2.length() == 0)
            return num1;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < num1.length(); i++) {
            stack1.push(Integer.valueOf(num1.substring(i,i+1)));
        }

        for (int i = 0; i < num2.length(); i++) {
            stack2.push(Integer.valueOf(num2.substring(i,i+1)));
        }

        int carry = 0;
        StringBuilder ret = new StringBuilder();
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            int sum = stack1.pop() + stack2.pop() + carry;
            carry = sum/10;
            ret.append(""+sum%10);
        }
        while(!stack1.isEmpty()){
            int sum = stack1.pop() + carry;
            carry = sum/10;
            ret.append(""+sum%10);
        }
        while(!stack2.isEmpty()){
            int sum = stack2.pop() + carry;
            carry = sum/10;
            ret.append(""+sum%10);
        }

        if(carry == 1){
            ret.append(""+1);
        }
        return ret.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "12345";
        String s2 = "7658329";
        String s = new StringAddition().addStrings(s1, s2);
        System.out.println(s);

    }
}
