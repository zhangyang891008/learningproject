package com.interview58_II;
/*
面试题58 - II. 左旋转字符串
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
示例 1：

输入: s = "abcdefg", k = 2
输出: "cdefgab"
示例 2：

输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"

限制：

1 <= k < s.length <= 10000
 */
public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        if(n<1 || n>= s.length()){
            return s;
        }
        int count = s.length();
        int pos = n;
        while(count>0){
            count--;
            stringBuilder.append(s.charAt(pos));
            pos = (pos+1) % s.length();
        }
        return stringBuilder.toString();
    }

    public String reverseLeftWords2(String s, int n) {
        if(n<1 || n>= s.length()){
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.substring(n,s.length()));
        stringBuilder.append(s.substring(0,n));
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        int n = 2;
        String s = new ReverseLeftWords().reverseLeftWords(str, n);
        System.out.println(s);
    }
}
