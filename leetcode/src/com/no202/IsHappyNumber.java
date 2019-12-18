package com.no202;

import java.util.HashSet;
import java.util.Set;

public class IsHappyNumber {
    public boolean isHappy(int n) {
        String value = String.valueOf(n);
        Set<String> visitHistory = new HashSet<>();
        while(!"1".equals(value) && !visitHistory.contains(value)){
            int sum = 0;
            for (int i = 0; i < value.length(); i++) {
                sum += Integer.valueOf(value.substring(i,i+1)) * Integer.valueOf(value.substring(i,i+1));
            }
            visitHistory.add(value);
            value = String.valueOf(sum);
        }

        return "1".equals(value)?true:false;
    }

    public static void main(String[] args) {
        int number = 28;
        boolean happy = new IsHappyNumber().isHappy(number);
        System.out.println(happy);
    }
}
