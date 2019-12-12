package com.no541;

/*
541.
官网解法：
 */

public class ReverseStrK_elegant {
    public String reverseStr(String s, int k) {

        if(k<=0)
            return null;
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i= i+2*k) {
            int start = i;
            int end = Math.min(i+k-1,s.length()-1);
            while(start<end){
                char temp = arr[start];
                arr[start] =arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String s1 = new ReverseStrK_elegant().reverseStr(s, k);
        System.out.println(s1);
    }
}
