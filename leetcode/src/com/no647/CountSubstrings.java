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
 */
public class CountSubstrings {

    static List<String> list = new ArrayList<>();
    public int countSubstrings(String s) {
        try {
            if(s==null)
                return 0;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i+1; j <= s.length(); j++) {
                    //System.out.println("current:" + i+"-"+j);
                    if(IsPalindrome(s.substring(i,j)))
                        count++;
                }
            }
            return count;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return 0;
    }

    private static boolean IsPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        if(end<start)
            return false;
        boolean flag = true;
        while(start<end){
            if(s.charAt(start++) != s.charAt(end--)){
                flag = false;
                break;
            }
        }
        /*
        if(flag){
            list.add(s);
        }*/
        return flag;
    }

    public static void main(String[] args) {
        String s = "abc";
        int i = new CountSubstrings().countSubstrings(s);
        System.out.println(i);
    }
}
