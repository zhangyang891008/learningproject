package com.no1309;

import java.util.HashMap;
import java.util.Map;

/*
1309. 解码字母到整数映射

给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：

字符（'a' - 'i'）分别用（'1' - '9'）表示。
字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
返回映射之后形成的新字符串。

题目数据保证映射始终唯一。

示例 1：

输入：s = "10#11#12"
输出："jkab"
解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
示例 2：

输入：s = "1326#"
输出："acz"
示例 3：

输入：s = "25#"
输出："y"
示例 4：

输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
输出："abcdefghijklmnopqrstuvwxyz"


提示：

1 <= s.length <= 1000
s[i] 只包含数字（'0'-'9'）和 '#' 字符。
s 是映射始终存在的有效字符串。
 */
public class FreqAlphabets {

    static Map<String,String> kvMap = new HashMap<>();
    static {
        kvMap.put("1","a");
        kvMap.put("2","b");
        kvMap.put("3","c");
        kvMap.put("4","d");
        kvMap.put("5","e");
        kvMap.put("6","f");
        kvMap.put("7","g");
        kvMap.put("8","h");
        kvMap.put("9","i");
        kvMap.put("10#","j");
        kvMap.put("11#","k");
        kvMap.put("12#","l");
        kvMap.put("13#","m");
        kvMap.put("14#","n");
        kvMap.put("15#","o");
        kvMap.put("16#","p");
        kvMap.put("17#","q");
        kvMap.put("18#","r");
        kvMap.put("19#","s");
        kvMap.put("20#","t");
        kvMap.put("21#","u");
        kvMap.put("22#","v");
        kvMap.put("23#","w");
        kvMap.put("24#","x");
        kvMap.put("25#","y");
        kvMap.put("26#","z");
    }
    public String freqAlphabets(String s) {
        int pos = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while(pos<s.length()){
            if(isSingleNumber(pos,s)){
                System.out.println("-"+s.substring(pos,pos+1));
                stringBuilder.append(kvMap.get(s.substring(pos,pos+1)));
                pos++;
            }else{
                System.out.println("--"+s.substring(pos,pos+2));
                stringBuilder.append(kvMap.get(s.substring(pos,pos+3)));
                pos = pos+3;
            }
        }
        return stringBuilder.toString();
    }

    private boolean isSingleNumber(int pos ,String string){
        if(pos+2<string.length()){
            if("#".equals(string.substring(pos+2,pos+3))){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String s = "10#11#12";
        String s1 = new FreqAlphabets().freqAlphabets(s);
        System.out.println(s1);
    }

}
