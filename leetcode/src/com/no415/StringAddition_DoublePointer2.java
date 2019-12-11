package com.no415;


/*
415.字符串相加
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

注意：

num1 和num2 的长度都小于 5100.
num1 和num2 都只包含数字 0-9.
num1 和num2 都不包含任何前导零。

 */
public class StringAddition_DoublePointer2 {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num1.length() == 0)
            return num2;
        if(num2 == null || num2.length() == 0)
            return num1;
        int pos1 = num1.length()-1;
        int pos2 = num2.length()-1;
        int carry = 0;
        int sum = 0;
        StringBuilder ret = new StringBuilder("");
        while(pos1>=0 || pos2>=0){
            int val1 = (pos1>=0) ? num1.charAt(pos1)-'0':0;
            int val2 = (pos2>=0)? num2.charAt(pos2)-'0' :0;
            sum = carry + val1 +val2;
            ret.append(sum%10);
            carry = sum/10;
            pos1--;
            pos2--;
        }
        if(carry ==1)
            ret.append(carry);
        return ret.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "12345";
        String s2 = "7658329";
        String s = new StringAddition_DoublePointer2().addStrings(s1, s2);
        System.out.println(s);

    }
}
