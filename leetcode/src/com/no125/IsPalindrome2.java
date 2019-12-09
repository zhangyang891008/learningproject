package com.no125;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class IsPalindrome2 {
    public boolean isPalindrome(String s) {
        if(s == null ||s.length()<2)
            return true;
        String regEx  =  "[^a-zA-Z0-9]";
        String tempStr = s.replaceAll(regEx,"").toLowerCase();
        System.out.println(tempStr);
        int left = 0;
        int right = tempStr.length()-1;
        boolean flag = true;
        while(left<right){
            if(tempStr.charAt(left)!= tempStr.charAt(right)) {
                //System.out.println(s.charAt(0)+","+s.charAt(right));
                flag = false;
                break;
            }
            left++;
            right--;
        }
        return flag;
    }

    public static void main(String[] args) {
        String s = "A man, a plan a canal: Panama7";
        boolean palindrome = new IsPalindrome2().isPalindrome(s);
        System.out.println(palindrome);
    }
}
