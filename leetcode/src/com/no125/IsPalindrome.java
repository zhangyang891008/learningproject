package com.no125;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/*
125. 验证回文串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:
输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false

 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        if(s == null ||s.length()<2)
            return true;
        s = s.toLowerCase();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new ArrayDeque<>();
        Stack<Character> stackReverse = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c>='0'&&c<='9') {
                queue.add(c);
                stack.push(c);
            }
            if(c>='a'&&c<='z') {
                queue.add(c);
                stack.push(c);
            }
        }
        boolean flag = true;
        while(!stack.isEmpty()){
            if(stack.pop()!=queue.remove()){
                flag = false;
                break;
            }
        }
        return flag;

    }

    public static void main(String[] args) {
        String s = "A man, a plan a canal: Panama";
        boolean palindrome = new IsPalindrome().isPalindrome(s);
        System.out.println(palindrome);
    }
}
