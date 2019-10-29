package com.no1002;

import java.util.ArrayList;
import java.util.List;

/*
1002. 查找常用字符
给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。

你可以按任意顺序返回答案。

示例 1：

输入：["bella","label","roller"]
输出：["e","l","l"]
示例 2：

输入：["cool","lock","cook"]
输出：["c","o"]
 

提示：

1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] 是小写字母

 */
public class CommonChars {
    public List<String> commonChars(String[] A) {
        if(A == null || A.length == 0)
            return new ArrayList<>();

        List<String> retList = new ArrayList<>();
        int[][] table = new int[A.length][26];

        //将每个字符串包含多少个字符都存到table数组中，每行对应一个字符串
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                table[i][(A[i].charAt(j)-'a')]++;
            }
        }

        for (int j = 0; j < 26; j++) {
            int minTimes = Integer.MAX_VALUE;
            for (int i = 0; i < A.length; i++) {
                minTimes = minTimes > table[i][j] ? table[i][j] : minTimes;
            }
            if(minTimes>0){
                for (int times = 0; times < minTimes; times++) {
                    retList.add(String.valueOf((char)('a'+j)));
                }

            }
        }
        return retList;
    }

    public static void main(String[] args) {
        String[] arr = {"hello" ,"lloy", "lol"};
        List<String> strings = new CommonChars().commonChars(arr);
        strings.forEach(System.out::println);
    }

}
