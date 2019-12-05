package com.no557;

import java.util.Stack;

/*
557. 反转字符串中的单词 III
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc" 
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

**********
PS:可以先用split分开，然后每个单词反转
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if(s==null || "".equals(s))
            return s;
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(" ".equals(s.substring(i,i+1)) ){
                while(!stack.isEmpty()){
                    stringBuilder.append(stack.pop());
                }
                stringBuilder.append(" ");
                continue;
            }
            //pushstack
            stack.push(s.charAt(i));
        }
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String s1 = new ReverseWords().reverseWords(s);
        System.out.println(s1);
    }
}
