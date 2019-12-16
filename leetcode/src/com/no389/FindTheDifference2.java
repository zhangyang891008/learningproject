package com.no389;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference2 {

    public char findTheDifference(String s, String t) {
        if(s == null || s.length() == 0)
            return t.charAt(0);
        char a = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            a ^= s.charAt(i);
        }

        for (int i = 0; i < t.length(); i++) {
            a ^= t.charAt(i);
        }
        return a;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "aabc";
        char theDifference = new FindTheDifference2().findTheDifference(s, t);
        System.out.println(theDifference);
    }
}
