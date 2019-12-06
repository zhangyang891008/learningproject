package com.no345;

import java.util.Stack;

/*
345.反转字符串中的元音字母
编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
示例 1:

输入: "hello"
输出: "holle"
示例 2:

输入: "leetcode"
输出: "leotcede"
说明:
元音字母不包含字母"y"。

 */
public class ReverseVowels {

    public String reverseVowels(String s) {
        if(s == null || s.length()<2)
            return s;
        String vowelStr = "aeiouAEIOU";
        Stack<Character> vowelStack =  new Stack<>();
        //元音字符存到stack中
        for (int i = 0; i < s.length(); i++) {
            if(vowelStr.contains(s.substring(i,i+1)))
                vowelStack.push(s.charAt(i));
        }

        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if(vowelStr.contains(s.substring(i,i+1))){
                ret.append(vowelStack.pop());
            }else{
                ret.append(s.charAt(i));
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s = "hello";
        String s1 = new ReverseVowels().reverseVowels(s);
        System.out.println(s1);
    }
}
