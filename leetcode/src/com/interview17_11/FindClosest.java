package com.interview17_11;

import java.util.HashSet;
import java.util.Set;

/*
面试题 17.11. 单词距离
有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?

示例：

输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
输出：1
 */
public class FindClosest {
    public int findClosest(String[] words, String word1, String word2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            if(word1.equals(words[i])){
                set1.add(i);
            }
            if(word2.equals(words[i])){
                set2.add(i);
            }
        }

        int min = Integer.MAX_VALUE;
        for (Integer v1 : set1) {
            for (Integer v2 : set2) {
                min = min>Math.abs(v1-v2)? Math.abs(v1-v2):min;
            }
        }
        return min;
    }

    public static void main(String[] args) {

    }
}
