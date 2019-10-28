package com.no1160;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
1160.拼写单词

    给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。

假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。

注意：每次拼写时，chars 中的每个字母都只能用一次。

返回词汇表 words 中你掌握的所有单词的 长度之和。

示例 1：

输入：words = ["cat","bt","hat","tree"], chars = "atach"
输出：6
解释：
可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
示例 2：

输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
输出：10
解释：
可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 
提示：
1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
所有字符串中都仅包含小写英文字母

********************
["dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin","ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb","ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl","boygirdlggnh","xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx","nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop","hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx","juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr","lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo","oxgaskztzroxuntiwlfyufddl","tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp","qnagrpfzlyrouolqquytwnwnsqnmuzphne","eeilfdaookieawrrbvtnqfzcricvhpiv","sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz","yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue","hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv","cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo","teyygdmmyadppuopvqdodaczob","qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs","qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"]
"usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp"
 */

public class CountCharactors {
    public int countCharacters(String[] words, String chars) {

        int[] table = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            table[chars.charAt(i)-'a']++;
        }

        int count = 0;
        for (String word : words) {
            if(isWordConstains(table, word)){
                count = count+word.length();
            }
        }

        return count;
    }

    private boolean isWordConstains(int[] table, String word) {
        int[] temp  = new int[26];

        for (int i = 0; i < word.length(); i++) {
            if(temp[word.charAt(i)-'a'] == table[word.charAt(i)-'a']){
                //说明不存在，因为当前字符的个数再添加就超过了table表中的数量
                return false;
            }else{
                temp[word.charAt(i)-'a']++;
            }
        }
        return true;
    }


    public static void main(String[] args) {
         String[] strs = {"hello","world","leetcode"};
         String chars = "welldonehoneyr";

         String[] strs2 = {"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin",
                 "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb","ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl",
                 "boygirdlggnh","xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx",
                 "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop",
                 "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx","juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr",
                 "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo","oxgaskztzroxuntiwlfyufddl",
                 "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp",
                 "qnagrpfzlyrouolqquytwnwnsqnmuzphne","eeilfdaookieawrrbvtnqfzcricvhpiv","sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz",
                 "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue",
                 "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv",
                 "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo","teyygdmmyadppuopvqdodaczob",
                 "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs","qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"};


         String chars2 = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";

        int i = new CountCharactors().countCharacters(strs2, chars2);
        System.out.println(i);

        int count = new CountCharactors().countCharacters(strs, chars);
        System.out.println(count);
    }
}
