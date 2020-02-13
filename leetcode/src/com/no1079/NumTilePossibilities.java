package com.no1079;

/*
1079. 活字印刷
你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。

示例 1：

输入："AAB"
输出：8
解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
示例 2：

输入："AAABBC"
输出：188

提示：

1 <= tiles.length <= 7
tiles 由大写英文字母组成
****************************

排列组合的问题：可以通过树减枝
回溯法：每种可能的结果进行验证，并回退

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumTilePossibilities {
    public int numTilePossibilities(String tiles) {
        Map<String,Integer> counts = new HashMap<>();
        for (int i = 0; i < tiles.length(); i++) {
            counts.put(tiles.substring(i,i+1),counts.getOrDefault(tiles.substring(i,i+1),0)+1);
        }

        List<String> ret= new ArrayList<>();
        for (String s : counts.keySet()) {
            //ret.add(s);
            counts.put(s,counts.get(s)-1);

            subString(ret,counts,s);
            counts.put(s,counts.get(s)+1);
        }


        for (String s : ret) {
            System.out.println(s);
        }
        return ret.size();
    }

    private void subString(List<String> ret, Map<String, Integer> counts, String s) {
        ret.add(s);

        for (String key : counts.keySet()) {
            int curKeyCount = 0;
            //字母剩余数量大于零时拼接
            if( (curKeyCount = counts.get(key)) > 0){
                String curString = s+key;
                counts.put(key,curKeyCount-1);
                subString(ret,counts,curString);
                counts.put(key,curKeyCount);
            }
        }
    }

    public static void main(String[] args) {
        String s = "AAABBC";
        int i = new NumTilePossibilities().numTilePossibilities(s);
        System.out.println(i);
    }
}
