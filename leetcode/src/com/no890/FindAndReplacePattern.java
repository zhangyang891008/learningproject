package com.no890;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
（回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
返回 words 中与给定模式匹配的单词列表。
你可以按任何顺序返回答案。
示例：

输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
输出：["mee","aqq"]
解释：
"mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
"ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
因为 a 和 b 映射到同一个字母。
 
提示：

1 <= words.length <= 50
1 <= pattern.length = words[i].length <= 20

 */
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        if(words==null || words.length==0 || pattern == null || pattern.length() == 0)
            return new ArrayList<>();

        List<String> retList = new ArrayList<>();
        for (String word : words) {
            //存储当前字符串和pattern字符串的映射关系
            Map<Character,Character> map = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                //word不存在key中，并且pattern不存在于value中
                if(!map.containsKey(word.charAt(i)) && !map.values().contains(pattern.charAt(i))){
                    map.put(word.charAt(i),pattern.charAt(i));
                }
            }

            StringBuilder s = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                s.append(map.get(word.charAt(i)));
            }
            if(s.toString()!=null && s.toString().equals(pattern))
                retList.add(word);
        }

        return retList;
    }

    public static void main(String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        List<String> andReplacePattern = new FindAndReplacePattern().findAndReplacePattern(words, pattern);
        for (String s : andReplacePattern) {
            System.out.println(s);
        }
    }

}
