package com.no821;

import java.util.*;

/*
821. 字符的最短距离
给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。

示例 1:

输入: S = "loveleetcode", C = 'e'
输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
说明:

字符串 S 的长度范围为 [1, 10000]。
C 是一个单字符，且保证是字符串 S 里的字符。
S 和 C 中的所有字母均为小写字母。

 */
public class ShortestToChar {

    public int[] shortestToChar(String S, char C) {
        List<Integer> ePos = new ArrayList<>();
        int[] ret = new int[S.length()];
        //find all e and store
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == C){
                ePos.add(i);
            }
        }

        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == C){
                ret[i] = 0;
            }else{
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < ePos.size(); j++) {
                    if(i <= ePos.get(j) || j == (ePos.size() -1)){
                        ret[i] = j>0? Math.min( Math.abs(i-ePos.get(j)), Math.abs(i-ePos.get(j-1))): Math.abs(ePos.get(j) - i);
                        break;
                    }
                }

            }
        }
        return ret;
    }


    public static void main(String[] args) {
        String S = "loveleetcode";
        char C = 'e';
        int[] ints = new ShortestToChar().shortestToChar(S, C);
        for (int anInt : ints) {
            System.out.print(anInt+",");
        }
    }
}
