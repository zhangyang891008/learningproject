package com.no389;

import java.util.HashMap;
import java.util.Map;
/*
389.找不同
给定两个字符串 s 和 t，它们只包含小写字母。

字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

请找出在 t 中被添加的字母。

示例:

输入：
s = "abcd"
t = "abcde"

输出：
e

解释：
'e' 是那个被添加的字母。

 */
public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        Map<Character,Integer> valueOccurenceTimes = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            valueOccurenceTimes.put(t.charAt(i), valueOccurenceTimes.getOrDefault(t.charAt(i),0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            valueOccurenceTimes.put(s.charAt(i), valueOccurenceTimes.get(s.charAt(i))-1);
        }

        char a = '0';
        for (Character character : valueOccurenceTimes.keySet()) {
            if(valueOccurenceTimes.get(character)>0){
                a = character;
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        char theDifference = new FindTheDifference().findTheDifference(s, t);
        System.out.println(theDifference);
    }
}
