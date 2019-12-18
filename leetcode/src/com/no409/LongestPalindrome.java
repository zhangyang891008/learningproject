package com.no409;

import java.util.HashMap;
import java.util.Map;

/*
409. 最长回文串
给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return 0;
        Map<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charCounts.put(s.charAt(i), charCounts.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        boolean oneTimesChar = false;
        for (Character character : charCounts.keySet()) {
            if (charCounts.get(character) % 2 == 1) {
                oneTimesChar = true;
            }
            count += charCounts.get(character)/2 *2;

        }
        return oneTimesChar ? count+1:count;
    }

    public static void main(String[] args) {
        String s = "abccccddda";
        int i = new LongestPalindrome().longestPalindrome(s);
        System.out.println(i);
    }
}
