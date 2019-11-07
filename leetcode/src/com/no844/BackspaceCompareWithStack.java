package com.no844;

import java.util.Stack;

/*
用两个栈实现
 */
public class BackspaceCompareWithStack {
    public boolean backspaceCompare(String S, String T) {
        if(S == null || T==null)
            return false;

        String parseA = parse(S);
        String parseB = parse(T);
        if(parseA.equals(parseB))
            return true;
        else
            return false;
    }

    private String parse(String S){
        StringBuilder sb = new StringBuilder();
        int index = -1;
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i)!='#'){
                sb.append(S.charAt(i));
                index++;
            }else{
                if(index >= 0)
                    sb.deleteCharAt(index--);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String a="##abc#";;
        String b = "ab";
        boolean b1 = new BackspaceCompare().backspaceCompare(a, b);
        System.out.println(b1);
    }
}
