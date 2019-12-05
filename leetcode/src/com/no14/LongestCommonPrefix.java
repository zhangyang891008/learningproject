package com.no14;
/*
14.最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。

 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length<1)
            return "";
        if(strs.length==1)
            return strs[0];
        int maxPos = Integer.MAX_VALUE;
        //计算循环次数
        for (int i = 0; i < strs.length; i++) {
            maxPos = maxPos < strs[i].length()? maxPos:strs[i].length();
        }

        for (int i = 0; i < maxPos; i++) {
            char curChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(curChar!= strs[j].charAt(i))
                    return i >0 ? strs[j].substring(0,i):"";
            }
        }

        return strs[0].substring(0,maxPos);
    }
    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        String s = new LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(s);
    }
}
