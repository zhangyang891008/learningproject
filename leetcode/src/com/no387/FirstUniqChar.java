package com.no387;

import java.util.HashMap;
import java.util.Map;

/*
387. 字符串中的第一个唯一字符
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:
s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
注意事项：您可以假定该字符串只包含小写字母。

**************
如果字符串长度大于26的话，计数数组不用整个字符串的长度那么长，只要26个和小写字母个数一样就行了，第二次遍历的时候，最多遍历26个
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        if(s == null)
            return -1;
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.substring(i,i+1),map.getOrDefault(s.substring(i,i+1),0)+1);
        }

        int index = s.length();
        for (String key : map.keySet()) {
            if(map.get(key)==1)
                index = Math.min(index, s.indexOf(key));
        }
        return index == s.length()? -1:index;
       
        /*
        //此方法可能会导致s字符串遍历超过26次，如果是遍历hashmap，最多26次
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.substring(i,i+1))==1) {
                index = i;
                break;
            }
        }
        return index;

         */

    }

    public static void main(String[] args) {
        String  s = "lleetcode";
        int i = new FirstUniqChar().firstUniqChar(s);
        System.out.println(i);
    }
}
