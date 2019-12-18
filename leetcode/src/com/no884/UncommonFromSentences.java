package com.no884;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
884.两句话中的不常见单词
给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）

如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。

返回所有不常用单词的列表。

您可以按任何顺序返回列表。

示例 1：

输入：A = "this apple is sweet", B = "this apple is sour"
输出：["sweet","sour"]
示例 2：

输入：A = "apple apple", B = "banana"
输出：["banana"]
 

提示：

0 <= A.length <= 200
0 <= B.length <= 200
A 和 B 都只包含空格和小写字母。

 */
public class UncommonFromSentences {


    public String[] uncommonFromSentences(String A, String B) {

        if(A == null || "".equals(A))
            return B.split(" ");
        if(B == null || "".equals(B))
            return A.split(" ");
        HashMap<String,Integer> wordCounts = new HashMap<>();
        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");
        for (int i = 0; i < wordsA.length; i++) {
            wordCounts.put(wordsA[i], wordCounts.getOrDefault(wordsA[i],0)+1);
        }
        for (int i = 0; i < wordsB.length; i++) {
            wordCounts.put(wordsB[i], wordCounts.getOrDefault(wordsB[i],0)+1);
        }

        List<String> ret = new ArrayList<>();
        for (String key : wordCounts.keySet()) {
            if(wordCounts.get(key) == 1) {
                ret.add(key);
            }
        }
        String[] s = new String[ret.size()];
        return ret.toArray(s);
    }

    public static void main(String[] args) {
        String A = "hello world java bye";
        String B = "hello bye";
        String[] strings = new UncommonFromSentences().uncommonFromSentences(A, B);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
