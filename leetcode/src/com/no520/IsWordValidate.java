package com.no520;
/*
520.检测大写字母
给定一个单词，你需要判断单词的大写使用是否正确。

我们定义，在以下情况时，单词的大写用法是正确的：

全部字母都是大写，比如"USA"。
单词中所有字母都不是大写，比如"leetcode"。
如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
否则，我们定义这个单词没有正确使用大写字母。

示例 1:

输入: "USA"
输出: True
示例 2:

输入: "FlaG"
输出: False
注意: 输入是由大写和小写拉丁字母组成的非空单词。

 */
public class IsWordValidate {

    public boolean detectCapitalUse(String word) {
        boolean flag = true;
        boolean lastChar = false;
        boolean isUpper = isUpper(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            Character c = word.charAt(i);
            if( !isUpper && isUpper(c)) {
                flag = false;
                break;
            }
            if( isUpper){
                if(i!=1){
                    boolean curChar = isUpper(c);
                    if( lastChar != curChar){
                        flag = false;
                        break;
                    }
                }else{
                     lastChar = isUpper(c);
                }
            }
        }
        return flag;
    }

    private static boolean isUpper(Character c){
        return (c>='a'&&c<='z')? false :true;
    }

    public static void main(String[] args) {
        String s = "sss";
        boolean b = new IsWordValidate().detectCapitalUse(s);
        System.out.println(b);
    }
}
