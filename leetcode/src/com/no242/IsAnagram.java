package com.no242;
/*
242.有效的字母异位词
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if(s == null || t ==null || s.length() != t.length())
            return false;
        int[] sCount = new int[26];
        //int[] tCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i)-'a']++;
            sCount[t.charAt(i)-'a']--;
        }
        boolean flag = true;
        for (int i = 0; i < sCount.length; i++) {
            if(sCount[i] != 0){
                flag = false;
                break;
            }
        }
        return flag;
    }


    public static void main(String[] args) {
        String s = "anagrame";
        String t = "nagaramr";
        boolean anagram = new IsAnagram().isAnagram(s, t);
        System.out.println(anagram);
    }
}
