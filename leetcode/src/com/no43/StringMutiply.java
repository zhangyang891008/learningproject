package com.no43;

import java.util.ArrayList;
import java.util.List;

public class StringMutiply {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2))
            return "0";
        List<String> addResult = new ArrayList<>();

        StringBuilder carryStr = new StringBuilder();
        for (int i = num1.length()-1; i >= 0; i--) {
            int multiply1 = Integer.valueOf(num1.substring(i,i+1));
            String sum = "0";
            if(multiply1 > 0){
                for (int j = 0; j < multiply1; j++) {
                    sum = addStrings(sum, num2);
                }
            }
            addResult.add(sum+carryStr.toString());
            carryStr.append("0");
        }

        String tempsum = "0";
        for (String s : addResult) {
            tempsum = addStrings(tempsum, s);
        }
        return tempsum;

    }

    private static String addStrings(String num1, String num2) {
        if(num1 == null || num1.length() == 0)
            return num2;
        if(num2 == null || num2.length() == 0)
            return num1;
        int pos1 = num1.length()-1;
        int pos2 = num2.length()-1;
        int carry = 0;
        int sum = 0;
        StringBuilder ret = new StringBuilder("");
        while(pos1>=0 || pos2>=0){
            int val1 = (pos1>=0) ? num1.charAt(pos1)-'0':0;
            int val2 = (pos2>=0)? num2.charAt(pos2)-'0' :0;
            sum = carry + val1 +val2;
            ret.append(sum%10);
            carry = sum/10;
            pos1--;
            pos2--;
        }
        if(carry ==1)
            ret.append(carry);
        return ret.reverse().toString();
    }

    public static void main(String[] args) {
        //System.out.println(Integer.valueOf("1"));
        String multiply = new StringMutiply().multiply("222", "22");
        System.out.println(multiply);
    }
}
