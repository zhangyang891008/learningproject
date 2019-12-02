package com.no500;

import java.util.*;
/*
给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。

示例：

输入: ["Hello", "Alaska", "Dad", "Peace"]
输出: ["Alaska", "Dad"]

注意：

你可以重复使用键盘上同一字符。
你可以假设输入的字符串将只包含字母。

 */

public class FindWords {

    public String[] findWords(String[] words) {

        List<String> retList = new ArrayList(Arrays.asList(words));

        Character[] lineOneCharacter = {'Q','W','E','R','T','Y','U','I','O','P'};
        Character[] lineTwoCharacter = {'A','S','D','F','G','H','J','K','L'};
        Character[] lineThreeCharacter = {'Z','X','C','V','B','N','M'};
        Map<Character,Integer> lineOne = new HashMap<>();
        Map<Character,Integer> lineTwo = new HashMap<>();
        Map<Character,Integer> lineThree = new HashMap<>();
        for (Character character : lineOneCharacter) {
            lineOne.put(character,1);
        }
        for (Character character : lineTwoCharacter) {
            lineTwo.put(character,2);
        }

        for (Character character : lineThreeCharacter) {
            lineThree.put(character,3);
        }

        for (String word : words) {
            int histLine = -1;
            String wordUpper = word.toUpperCase();
            for (int i = 0; i < word.length(); i++) {
                int curLine = -1;
                if(lineOne.keySet().contains(wordUpper.charAt(i))){
                    curLine = 1;
                }else if(lineTwo.keySet().contains(wordUpper.charAt(i))){
                    curLine = 2;
                }else{
                    curLine = 3;
                }

                if(histLine < 0){
                    histLine = curLine;
                }else{
                    if(histLine != curLine) {
                        retList.remove(word);
                        break;
                    }
                }
            }
        }

        return retList.toArray(new String[retList.size()]);
    }



    public static void main(String[] args) {

        String[] params = {"asdfghjkl","qwertyuiop","zxcvbnm"};
        String[] words = new FindWords().findWords(params);
        for (String word : words) {

            System.out.println(word);
        }

    }
}
