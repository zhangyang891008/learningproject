package com.no784;

import java.util.ArrayList;
import java.util.List;

/*
784.字母大小写全排列
给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

示例:
输入: S = "a1b2"
输出: ["a1b2", "a1B2", "A1b2", "A1B2"]

输入: S = "3z4"
输出: ["3z4", "3Z4"]

输入: S = "12345"
输出: ["12345"]
注意：

S 的长度不超过12。
S 仅由数字和字母组成。

 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        if(S == null || S.length() == 0)
            return new ArrayList<>();
        List<String> ret = new ArrayList<>();
        countLetters(ret, S,0, "");

        return ret;
    }

    private void countLetters(List<String> ret, String s, int curPos, String curLetter) {
        if(curLetter.length() == s.length()){
            ret.add(curLetter);
            return;
        }

        for (int i = curPos; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if(isLowerCase(curChar)){
                countLetters(ret, s ,i+1,curLetter+(char) (curChar - 32));
            }
            if(isUpperCase(curChar)){
                countLetters(ret,s,i+1, curLetter+(char) (curChar +32));
            }
            countLetters(ret,s,i+1, curLetter + curChar);
        }
    }

    private boolean isUpperCase(char ch) {
        if(ch >= 'A' && ch <= 'Z')
            return true;
        return false;
    }

    private boolean isLowerCase(char ch){
        if(ch >= 'a' && ch <= 'z')
            return true;
        return false;
    }


    public List<String> letterCasePermutation2(String S) {
        if(S == null || S.length() == 0)
            return new ArrayList<>();
        List<String> ret = new ArrayList<>();
        List<StringBuilder> subStrings = new ArrayList<>();
        subStrings.add(new StringBuilder());
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int size = subStrings.size();
            if(isLetter(ch)){
                for (int j = 0; j < size; j++) {
                    subStrings.add(new StringBuilder(subStrings.get(j)));
                    subStrings.get(j).append(Character.toLowerCase(ch));
                    subStrings.get(j+size).append(Character.toUpperCase(ch));

                }
            }else{
                for (int j = 0; j< subStrings.size();j++) {
                    subStrings.get(j).append(ch);
                }
            }
        }

        for (StringBuilder subString : subStrings) {
            ret.add(subString.toString());
        }

        return ret;
    }


    private boolean isLetter(char ch){
        if( (ch >='a' && ch <='z') || (ch >= 'A' && ch <= 'Z'))
            return true;
        return false;
    }

    public static void main(String[] args) {
        List<String> ret = new LetterCasePermutation().letterCasePermutation2("a1b2");
        ret.stream().spliterator().forEachRemaining(System.out::println);
    }
}
