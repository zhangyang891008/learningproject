package com.no1078;
/*
1078. Bigram 分词
给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。

对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。

示例 1：

输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
输出：["girl","student"]
示例 2：

输入：text = "we will we will rock you", first = "we", second = "will"
输出：["we","rock"]
 

提示：

1 <= text.length <= 1000
text 由一些用空格分隔的单词组成，每个单词都由小写英文字母组成
1 <= first.length, second.length <= 10
first 和 second 由小写英文字母组成

 */

import java.util.ArrayList;
import java.util.List;

public class FindOcurrences {

    public String[] findOcurrences(String text, String first, String second) {
        if(text== null || "".equals(text) || first == null || "".equals(first) || second == null || "".equals(second))
            return new String[0];
        List<String> ret = new ArrayList<>();
        String[] words = text.split(" ");
        for (int i = 0; i < words.length-2; i++) {
            if(first.equals(words[i]) && second.equals(words[i+1])){
                ret.add(words[i+2]);
            }
        }
        String[] retWord = new String[ret.size()];
        return ret.toArray(retWord);
    }

    public static void main(String[] args) {
        String text  = "alice is a good girl she is a good a good student";
        String first = "a";
        String second = "good";
        String[] ocurrences = new FindOcurrences().findOcurrences(text, first, second);
        for (String ocurrence : ocurrences) {
            System.out.println(ocurrence);
        }
    }
}
