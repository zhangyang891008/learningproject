package com.no647;

import java.util.ArrayList;
import java.util.List;

/*
647. 回文子串
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。

示例 1:

输入: "abc"
输出: 3
解释: 三个回文子串: "a", "b", "c".
示例 2:

输入: "aaa"
输出: 6
说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
注意:

输入的字符串长度不会超过1000。

*****************
分奇偶两种情况，分别从一个元素向外扩充

 */
public class CountSubstrings_elegant {

    int count = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            count(s, i,i);
            count(s, i,i+1);
        }
        return count;
    }

    private void count(String s, int start, int end) {
        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
            count++;
            start--;
            end++;
        }
    }

    public static void main(String[] args) {
        String s = "aaa";
        int i = new CountSubstrings_elegant().countSubstrings(s);
        System.out.println(i);
    }
}
