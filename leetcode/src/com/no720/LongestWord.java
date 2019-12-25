package com.no720;

import java.util.HashSet;
import java.util.Set;

/*
720. 词典中最长的单词
    给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。

若无答案，则返回空字符串。

示例 1:

输入:
words = ["w","wo","wor","worl", "world"]
输出: "world"
解释:
单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
示例 2:

输入:
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
输出: "apple"
解释:
"apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
注意:

所有输入的字符串都只包含小写字母。
words数组长度范围为[1,1000]。
words[i]的长度范围为[1,30]。

 */
public class LongestWord {

    //1。常规解法
    public String longestWord(String[] words) {
        if(words == null || words.length == 0 )
            return null;
        Set<String> wordsSet = new HashSet<>();
        for (String word : words) {
            wordsSet.add(word);
        }
        String result = "";
        for (String word : words) {
            if( word.length() == result.length() && result.compareTo(word)>0 || word.length()>result.length() ){
                boolean change = true;
                //check if sub string exist
                for (int i = 1; i < word.length(); i++) {
                    if( !wordsSet.contains(word.substring(0,i))){
                        change = false;
                        break;
                    }
                }

                if(change)
                    result = word;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"a", "banana", "app", "appl", "ap", "appla", "apple"};
        String s = new LongestWord().longestWord(strings);
        System.out.println(s);
    }
}
